package br.edu.utfpr.daeln.csr31.chat4dpam5.core;

import br.edu.utfpr.daeln.csr31.chat4dpam5.beans.ChatoParameters;
import br.edu.utfpr.daeln.csr31.chat4dpam5.interfaces.Messenger;
import java.net.DatagramPacket;

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
        Chato.messenger().systemMessage(packet.getAddress().toString(), Messenger.MESSAGES_TYPES.DEBUG);
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
