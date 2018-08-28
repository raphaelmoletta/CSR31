package br.edu.utfpr.daeln.csr31.chato.core;

import br.edu.utfpr.daeln.csr31.chato.beans.ChatoParameters;
import br.edu.utfpr.daeln.csr31.chato.beans.User;
import br.edu.utfpr.daeln.csr31.chato.interfaces.Messenger;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.Charset;

/**
 *
 * @author rapha
 */
public class ProcessDatagramPackageThread implements Runnable {

    private final ChatoParameters param;
    private final DatagramPacket packet;

    /**
     *
     * @param packet
     * @param param
     */
    public ProcessDatagramPackageThread(DatagramPacket packet, ChatoParameters param) {
        this.param = param;
        this.packet = packet;
    }

    /**
     * run
     */
    @Override
    public void run() {
        try {
            if (InetAddress.getLocalHost().getHostAddress().equals(packet.getAddress().toString().substring(1, packet.getAddress().toString().length()))) {
                Chato.messenger().systemMessage("ECOcococo.", Messenger.MESSAGES_TYPES.DEBUG);
                return;
            }
        } catch (UnknownHostException e) {
            Chato.messenger().systemMessage("run :: UnknownHostException :: " + e.toString(), Messenger.MESSAGES_TYPES.DEBUG);
        }

        switch (packet.getData()[0]) {
            case 1: //PING
                if (packet.getData()[1] == -127) {
                    Chato.messenger().systemMessage("Recived ping from: " + packet.getAddress(), Messenger.MESSAGES_TYPES.DEBUG);
                    User user = new User();
                    user.setInetAddress(packet.getAddress());
                    Chato.add(user);
                    user.setNick((new String(packet.getData(), Charset.forName("UTF-8"))).split("\n")[1]);
                    Chato.send(Chato.Commands.PONG);
                }
                //param.getUsers()
                break;
            case 2: //PONG
                if (packet.getData()[1] == -127) {
                    Chato.messenger().systemMessage("Recived pong from: " + packet.getAddress(), Messenger.MESSAGES_TYPES.DEBUG);
                    User user = new User();
                    user.setInetAddress(packet.getAddress());
                    user.setNick((new String(packet.getData(), Charset.forName("UTF-8"))).split("\n")[1]);
                    Chato.add(user);
                }
                break;
            case 3:
            case 10: //Send Message
                param.getUsers();
                break;
            default:
        }
    }

}
