package br.edu.utfpr.daeln.csr31.chat4dpam5.core;

import br.edu.utfpr.daeln.csr31.chat4dpam5.beans.ConfigurationData;
import br.edu.utfpr.daeln.csr31.chat4dpam5.beans.ListnerData;
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

    private final ListnerData data;
    private final ConfigurationData config;

    public ListnerThread(ListnerData data, ConfigurationData config) {
        this.data = data;
        this.config = config;
    }

    @Override
    public void run() {

        try {
            DatagramSocket socket = new DatagramSocket(config.getPort(),InetAddress.getByName("0.0.0.0"));
            byte[] buffer = new byte[1024];
            while (data.keepRuning()) {
                if(config.changedPort()) {
                    socket.close();
                    socket = new DatagramSocket(config.getPort(),InetAddress.getByName("0.0.0.0"));
                    config.removeChanged();
                    socket.setSoTimeout(1000);
                }
                
                DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
                config.debug("RecivedMessage");
                socket.receive(dp);
                data.add(dp);
            }
        } catch (SocketTimeoutException ex) {
            config.debug(ex);
        } catch (SocketException ex) {
            config.debug(ex);
        } catch (IOException ex) {
            config.debug(ex);
        }
    }

}
