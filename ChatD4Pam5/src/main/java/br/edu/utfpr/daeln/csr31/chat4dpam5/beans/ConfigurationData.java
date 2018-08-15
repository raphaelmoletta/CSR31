package br.edu.utfpr.daeln.csr31.chat4dpam5.beans;

import br.edu.utfpr.daeln.csr31.chat4dpam5.MainView;
import java.net.InetAddress;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 *
 * @author rapha
 */
public class ConfigurationData {

    private boolean changedPort = false, connected = false, debug = false, running = true;
    private int port = 6969;
    private String nick = "you";
    private InetAddress serverAddress = null;
    private final MainView view;
    private final Queue<Exception> exceptions = new ConcurrentLinkedQueue<>();
    private final Queue<String> messages = new ConcurrentLinkedQueue<>();

    public ConfigurationData(MainView view) {
        this.view = view;
    }
    
    public synchronized MainView getView() {
        return view;
    }

    public synchronized boolean changedPort() {
        return changedPort;
    }
    
    public synchronized void removeChanged() {
        changedPort = false;
    }

    public synchronized int getPort() {
        return port;
    }

    public synchronized void setPort(int port) {
        changedPort = true;
        this.port = port;
    }

    public synchronized void debug(Exception ex) {
        if(debug)
            exceptions.add(ex);
    }
    
    public synchronized void debug(String message) {
        if(debug)
            messages.add(message);
    }

    public synchronized void setChangedPort(boolean changedPort) {
        this.changedPort = changedPort;
    }

    public synchronized void setConnected(boolean connected) {
        this.connected = connected;
    }

    public synchronized boolean isDebug() {
        return debug;
    }

    public synchronized void setDebug(boolean debug) {
        this.debug = debug;
    }

    public synchronized String getNick() {
        return nick;
    }

    public synchronized void setNick(String nick) {
        this.nick = nick;
    }

    public synchronized InetAddress getServerAddress() {
        return serverAddress;
    }

    public synchronized void setServerAddress(InetAddress serverAddress) {
        this.serverAddress = serverAddress;
    }

    public synchronized boolean isConnected() {
        return connected;
    }

    public synchronized boolean isRunning() {
        return running;
    }

    public synchronized void stop() {
        running = false;
    }
}
