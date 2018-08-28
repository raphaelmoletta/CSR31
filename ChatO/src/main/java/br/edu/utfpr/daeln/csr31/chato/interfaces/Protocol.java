package br.edu.utfpr.daeln.csr31.chato.interfaces;

import br.edu.utfpr.daeln.csr31.chato.protocols.ProtocolD4Pam5;

/**
 *
 * @author rapha
 */
public abstract class Protocol {

    /**
     * ENCODER
     */
    public enum ENCODER {

        /**
         * D4Pam5
         */
        D4Pam5}

    /**
     *
     * @param binaryMsg
     * @return
     */
    public abstract Data[] encode(String binaryMsg);

    /**
     *
     * @param message
     * @return
     */
    public abstract String decode(Data[] message);
    
    /**
     *
     * @param encoder
     * @return
     */
    public static Protocol getProtocol(ENCODER encoder) {
        switch(encoder.toString()){
            case "D4Pam5" :
                return new ProtocolD4Pam5();
                
                
        }
            
        return null;
    }
}
