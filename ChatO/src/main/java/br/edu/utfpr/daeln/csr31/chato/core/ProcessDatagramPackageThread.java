package br.edu.utfpr.daeln.csr31.chato.core;

import br.edu.utfpr.daeln.csr31.chato.beans.ChatoParameters;
import br.edu.utfpr.daeln.csr31.chato.beans.User;
import br.edu.utfpr.daeln.csr31.chato.interfaces.Messenger;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * @author rapha
 */
public class ProcessDatagramPackageThread implements Runnable {

    private final ChatoParameters param;
    private final DatagramPacket packet;

    public ProcessDatagramPackageThread(DatagramPacket packet, ChatoParameters param) {
        this.param = param;
        this.packet = packet;
    }

    @Override
    public void run() {
        try {
            if ( InetAddress.getLocalHost().getHostAddress().equals(packet.getAddress().toString().substring(1, packet.getAddress().toString().length()))) {
                Chato.messenger().systemMessage("ECOcococo.", Messenger.MESSAGES_TYPES.DEBUG);
                return;
            }
        } catch (UnknownHostException e) {

        }

        switch (packet.getData()[0]) {
            case 1: //PING
                if(packet.getData()[1] == -127) {
                    Chato.messenger().systemMessage("Recived ping from: " + packet.getAddress(), Messenger.MESSAGES_TYPES.DEBUG);
                    User user = new User();
                    user.setInetAddress(packet.getAddress());
                    Chato.add(user);
                    user.setNick((new String(packet.getData())).split("\n")[1]);
                    Chato.send(Chato.Commands.PONG);
                }
                //param.getUsers()
                break;
            case 2: //PONG
                if(packet.getData()[1] == -127) {
                    Chato.messenger().systemMessage("Recived pong from: " + packet.getAddress(), Messenger.MESSAGES_TYPES.DEBUG);
                    User user = new User();
                    user.setInetAddress(packet.getAddress());
                    user.setNick((new String(packet.getData())).split("\n")[1]);
                    Chato.add(user);
                }
                break;
            case 10: //
                break;
        }
    }

}
