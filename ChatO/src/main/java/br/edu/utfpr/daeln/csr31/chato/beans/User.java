package br.edu.utfpr.daeln.csr31.chato.beans;

import java.net.InetAddress;

/**
 *
 * @author rapha
 */
public class User {

    private InetAddress inetAddress;
    private String nick = "";
    
    /**
     *
     * @return
     */
    public InetAddress getInetAddress() {
        return inetAddress;
    }

    /**
     *
     * @param address
     */
    public void setInetAddress(InetAddress address) {
        this.inetAddress = address;
    }

    /**
     *
     * @return
     */
    public String getNick() {
        return nick;
    }

    /**
     *
     * @param nick
     */
    public void setNick(String nick) {
        this.nick = nick;
    }
}
