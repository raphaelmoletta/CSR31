package br.edu.utfpr.daeln.csr31.chat4dpam5.core;

import br.edu.utfpr.daeln.csr31.chat4dpam5.beans.ChatoParameters;
import br.edu.utfpr.daeln.csr31.chat4dpam5.interfaces.Messenger;
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
                Chato.messenger().systemMessage("ECOcococo...", Messenger.MESSAGES_TYPES.DEBUG);
                return;
            }
        } catch (UnknownHostException e) {

        }

        switch (packet.getData()[0]) {
            case 1: //PING

                //param.getUsers()
                break;
            case 2: //PONG
                break;
            case 10: //
                break;
        }
    }

}
