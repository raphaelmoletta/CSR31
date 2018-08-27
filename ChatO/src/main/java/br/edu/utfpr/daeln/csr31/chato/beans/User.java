package br.edu.utfpr.daeln.csr31.chato.beans;

import java.net.InetAddress;

/**
 *
 * @author rapha
 */
public class User {

    private InetAddress inetAddress;
    
    public InetAddress getInetAddress() {
        return inetAddress;
    }

    public void setInetAddress(InetAddress address) {
        this.inetAddress = address;
    }
}
