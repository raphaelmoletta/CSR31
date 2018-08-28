package br.edu.utfpr.daeln.csr31.chato.beans;

import br.edu.utfpr.daeln.csr31.chato.interfaces.Protocol;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author rapha
 */
public class ChatoParameters {
    private String nick;
    private final Protocol.ENCODER encoder;
    private boolean debug;
    private int port;
    private boolean running;
    private boolean[] slots;
    private Map<String,User> users;

    /**
     * ChatoParameters
     */
    public ChatoParameters() {
        nick = "me";
        encoder = Protocol.ENCODER.D4Pam5;
        debug = true;
        port = 6969;
        running = true;
        users = new HashMap<>();
        slots = new boolean[256];
        for(int i = 0; i < slots.length; i++) {
            slots[i] = true;
        }
    }

    /**
     *
     * @return
     */
    public synchronized boolean[] getSlots() {
        return slots;
    }

    /**
     *
     * @param slots
     */
    public synchronized void setSlots(boolean[] slots) {
        this.slots = slots;
    }
    
    /**
     *
     * @return
     */
    public synchronized boolean isRunning() {
        return running;
    }

    /**
     *
     * @param running
     */
    public synchronized void setRunning(boolean running) {
        this.running = running;
    }

    /**
     *
     * @return
     */
    public synchronized String getNick() {
        return nick;
    }

    /**
     *
     * @param nick
     */
    public synchronized void setNick(String nick) {
        this.nick = nick;
    }

    /**
     *
     * @return
     */
    public synchronized Protocol.ENCODER getEncoder() {
        return encoder;
    }

    /**
     *
     * @return
     */
    public synchronized boolean isDebuging() {
        return debug;
    }
    
    /**
     *
     * @param debug
     */
    public synchronized void setDebug(boolean debug) {
        this.debug = debug;
    }

    /**
     *
     * @return
     */
    public synchronized int getPort() {
        return port;
    }

    /**
     *
     * @param port
     */
    public synchronized void setPort(int port) {
        this.port = port;
    }

    /**
     *
     * @return
     */
    public synchronized Map<String, User> getUsers() {
        return users;
    }

    /**
     *
     * @param users
     */
    public synchronized void setUsers(Map<String, User> users) {
        this.users = users;
    }
    
}
