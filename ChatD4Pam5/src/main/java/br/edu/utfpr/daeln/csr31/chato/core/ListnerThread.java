package br.edu.utfpr.daeln.csr31.chato.core;

import br.edu.utfpr.daeln.csr31.chato.beans.ChatoParameters;
import br.edu.utfpr.daeln.csr31.chato.interfaces.Messenger;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;

/**
 *
 * @author rapha
 */
public class ListnerThread implements Runnable {

    private final ChatoParameters param;
    private int port;

    public ListnerThread(ChatoParameters param) {
        this.param = param;
        port = param.getPort();
    }

    @Override
    public void run() {

        try {
            DatagramSocket socket = new DatagramSocket(param.getPort(), InetAddress.getByName("0.0.0.0"));
            byte[] buffer = new byte[1024];
            Chato.messenger().systemMessage("Listeningchato.", Messenger.MESSAGES_TYPES.DEBUG);
            socket.setSoTimeout(1000);
            while (param.isRunning()) {
                try {
                    if (port != param.getPort()) {
                        socket.close();
                        port = param.getPort();
                        socket = new DatagramSocket(port, InetAddress.getByName("0.0.0.0"));
                        socket.setSoTimeout(1000);
                    }

                    DatagramPacket dp = new DatagramPacket(buffer, buffer.length);

                    socket.receive(dp);

                    Chato.messenger().systemMessage("RecivedMessage: " + new String(dp.getData()), Messenger.MESSAGES_TYPES.DEBUG);
                    new Thread(new ProcessDatagramPackageThread(dp, param)).start();
                } catch (SocketTimeoutException ex) {
                    Chato.messenger().systemMessage("Waited Exception :: Socket Timeout Exception\n", Messenger.MESSAGES_TYPES.DEBUG);
                }
            }
        } catch (SocketException ex) {
            Chato.messenger().systemMessage("Listner Thread :: SocketException\n" + ex.getLocalizedMessage(), Messenger.MESSAGES_TYPES.ERROR);
        } catch (IOException ex) {
            Chato.messenger().systemMessage("Listner Thread :: IOException\n" + ex.getLocalizedMessage(), Messenger.MESSAGES_TYPES.ERROR);
        }
    }

}
