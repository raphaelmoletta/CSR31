package br.edu.utfpr.daeln.csr31.chat4dpam5.core;

import br.edu.utfpr.daeln.csr31.chat4dpam5.MainView;
import br.edu.utfpr.daeln.csr31.chat4dpam5.beans.ConfigurationData;
import br.edu.utfpr.daeln.csr31.chat4dpam5.beans.ListnerData;
import br.edu.utfpr.daeln.csr31.chat4dpam5.beans.Message;
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
    private final ConfigurationData config;
    private final ListnerData listnerData;
    Thread listnerThread = null;
    
    public Chat(MainView frame) {
        config = new ConfigurationData(frame);
        listnerData = new ListnerData();
        listnerThread = new Thread(new ListnerThread(listnerData, config));
        start();
    }
    
    private void start() {
        listnerThread.start();
    }
    
    public void stop() {
        config.stop();
        listnerData.stop();
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
            socket.send(new DatagramPacket(ping.getBytes(),ping.length(), InetAddress.getByName("255.255.255.255"), config.getPort()));
            DatagramPacket dp = new DatagramPacket(ping.getBytes(),ping.length());
            try{
                socket.receive(dp);
                if (new String(dp.getData()).equals("PONG")) {
                    config.setServerAddress(dp.getAddress());
                    return true;
                }
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
        return config.getNick();
    }

    public boolean executeCommand(String text) {
        String[] data = text.split(" ");
        switch(data[0].toLowerCase()) {
            case "/nick" :
                if(data.length == 2) {
                    config.setNick(data[1]);
                    config.getView().messageSystem("[INFO] Nickname setted to " + config.getNick());
                    return true;
                }
                break;
            case "/server" :
                if(data.length >= 2) {
                    if("port".equals(data[1].trim().toLowerCase()) && data.length == 3 ) {
                        try {
                            int port = Integer.parseInt(data[2]);
                            if(port >= 1 && port <= 65535) {
                                config.setPort(port);
                                config.getView().messageSystem("[INFO] Server port setted to " + port);
                            } else {
                                config.getView().messageSystem("[ERROR] Port must be between 1 and 65535");
                            }
                            return true;
                        } catch(NumberFormatException e) {
                            config.getView().messageSystem("[ERROR] Wrong port format");
                        }
                    } else if("search".equals(data[1].trim().toLowerCase())) {
                        config.getView().messageSystem("[INFO] Starting search server ... ");
                        config.getView().messageSystem("[INFO] Port: " + config.getPort());
                        return true;
                    } else if("start".equals(data[1].trim().toLowerCase())) {
                        config.getView().messageSystem("[INFO] Starting server on this host ... ");
                        config.getView().messageSystem("[INFO] Port: " + config.getPort());
                        return true;
                    }
                } else {
                    config.getView().messageSystem("[HELP] Help for '/server'");
                    config.getView().messageSystem("[HELP]    port <port number> \t- Define port number for comunication, must be between 1 and 65535");
                    config.getView().messageSystem("[HELP]    search \t- Search for a server in a defined port.");
                    return true;
                }
                break;
            case "/connect" :
                break;
            case "/list" :
                break;
            case "/debug" :
                if(data.length == 2) {
                    if("enable".equals(data[1].toLowerCase().trim())) {
                        config.setDebug(true);
                        config.getView().messageSystem("[INFO] Debug Mode is on");
                        return true;
                    } else if("disable".equals(data[1].toLowerCase().trim())) {
                        config.setDebug(false);
                        config.getView().messageSystem("[INFO] Debug Mode is off");
                        return true;
                    }
                }
                break;
        }
        return false;
    }

    public boolean isConnected() {
        return config.isConnected();
    }
}
