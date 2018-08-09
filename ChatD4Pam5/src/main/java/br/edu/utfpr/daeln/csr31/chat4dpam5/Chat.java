package br.edu.utfpr.daeln.csr31.chat4dpam5;

import br.edu.utfpr.daeln.csr31.chat4dpam5.beans.Message;
import br.edu.utfpr.daeln.csr31.chat4dpam5.core.Encoder;
import br.edu.utfpr.daeln.csr31.chat4dpam5.interfaces.Protocol;
import br.edu.utfpr.daeln.csr31.chat4dpam5.interfaces.Protocol.ENCODER;

/**
 *
 * @author rapha
 */
public class Chat {
    private static ENCODER encoder = Protocol.ENCODER.D4Pam5;
    
    public static Message send(String message) {
        Message m = new Message();
        m.setEncoder(encoder);
        m.setText(message);
        m.setBinary(Encoder.toBinary(message));
        m.setData(Protocol.getProtocol(encoder).encode(m.getBinary()));
        return m;
    }
}
