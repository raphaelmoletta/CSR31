package br.edu.utfpr.daeln.csr31.chat4dpam5;

import br.edu.utfpr.daeln.csr31.chat4dpam5.beans.Message;
import br.edu.utfpr.daeln.csr31.chat4dpam5.core.Encoder;
import br.edu.utfpr.daeln.csr31.chat4dpam5.gui.MainView;
import br.edu.utfpr.daeln.csr31.chat4dpam5.interfaces.Protocol;
import br.edu.utfpr.daeln.csr31.chat4dpam5.interfaces.Protocol.ENCODER;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;

/**
 *
 * @author rapha
 */
public class Chat {
    private static final ENCODER encoder = Protocol.ENCODER.D4Pam5;
    Thread server = null;
    private final MainView frame;
    private String nick = "you";
    
    public Chat(MainView frame) {
        this.frame = frame;
        new Thread (){
            @Override
            public void run() {
                frame.messageSystem("Localizando servidor(6969)... ");
                if(searchServer()) {
                    frame.messageSystem("Iniciando comunicação... ");
                } else {
                    frame.messageSystem("Entrando no modo servidor... ");
                    startServer();
                }
            }
        }.start();
    }
    
    public Message send(String message) {
        Message m = new Message();
        m.setEncoder(encoder);
        m.setText(message);
        m.setBinary(Encoder.toBinary(message));
        m.setData(Protocol.getProtocol(encoder).encode(m.getBinary()));
        return m;
    }

    public boolean searchServer() {
        try{
            DatagramSocket socket = new DatagramSocket();
            socket.setBroadcast(true);
            socket.setSoTimeout(5000);
            String ping = "PING";
            socket.send(new DatagramPacket(ping.getBytes(),ping.length(), InetAddress.getByName("255.255.255.255"), 6969));
            DatagramPacket dp = new DatagramPacket(ping.getBytes(),ping.length());
            try{
                socket.receive(dp);
                if (new String(dp.getData()).equals("PONG"))
                    return true;
                return false;
            }catch (SocketTimeoutException e) {
                return false;
            }
            
        } catch (IOException e) {
            return false;
        }
    }

    public void startServer() {
        
    }
    
    public String getNick() {
        return nick;
    }

    public void executeCommand(String text) {
        String[] data = text.split(" ");
        switch(data[0].toLowerCase()) {
            case "/nick" :
                if(data.length == 2) {
                    nick = data[1];
                    frame.messageSystem("New nickname: " + nick);
                }
                break;
                
        }
    }
}
