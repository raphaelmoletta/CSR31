package br.edu.utfpr.daeln.csr31.chat4dpam5.beans;

import br.edu.utfpr.daeln.csr31.chat4dpam5.interfaces.Protocol;

/**
 *
 * @author rapha
 */
public class ChatoParameters {
    private String nick;
    private final Protocol.ENCODER encoder;
    private boolean debug;
    private int port;

    public ChatoParameters() {
        nick = "me";
        encoder = Protocol.ENCODER.D4Pam5;
        debug = false;
        port = 6969;
    }

    public synchronized String getNick() {
        return nick;
    }

    public synchronized void setNick(String nick) {
        this.nick = nick;
    }

    public Protocol.ENCODER getEncoder() {
        return encoder;
    }

    public boolean isDebuging() {
        return debug;
    }
    
    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
