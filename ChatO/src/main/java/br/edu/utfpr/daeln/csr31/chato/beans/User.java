package br.edu.utfpr.daeln.csr31.chato.beans;

import java.net.InetAddress;

/**
 *
 * @author rapha
 */
public class User {

    private InetAddress inetAddress;
    private String nick = "";
    
    public InetAddress getInetAddress() {
        return inetAddress;
    }

    public void setInetAddress(InetAddress address) {
        this.inetAddress = address;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }
}
