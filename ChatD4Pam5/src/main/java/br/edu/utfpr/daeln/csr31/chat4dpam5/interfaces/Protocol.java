package br.edu.utfpr.daeln.csr31.chat4dpam5.interfaces;

import br.edu.utfpr.daeln.csr31.chat4dpam5.protocols.ProtocolD4Pam5;

/**
 *
 * @author rapha
 */
public abstract class Protocol {
    public enum ENCODER {D4Pam5}
    public abstract Data[] encode(String binaryMsg);
    public abstract String decode(Data[] message);
    
    public static Protocol getProtocol(ENCODER encoder) {
        switch(encoder.toString()){
            case "D4Pam5" :
                return new ProtocolD4Pam5();
                
                
        }
            
        return null;
    }
}
