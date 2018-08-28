package br.edu.utfpr.daeln.csr31.chato.interfaces;

import br.edu.utfpr.daeln.csr31.chato.beans.Message;
import br.edu.utfpr.daeln.csr31.chato.beans.RemoteMessage;

/**
 *
 * @author rapha
 */
public interface Messenger {

    /**
     * MESSAGES_TYPES
     */
    public enum MESSAGES_TYPES { 

        /**
         * HELP
         */
        HELP, 

        /**
         * INFO
         */
        INFO, 

        /**
         * WARN
         */
        WARN, 

        /**
         * ERROR
         */
        ERROR, 

        /**
         * DEBUG
         */
        DEBUG}

    /**
     *
     * @param message
     */
    public void userMessage(Message message);

    /**
     *
     * @param message
     * @param type
     */
    public void systemMessage(String message, MESSAGES_TYPES type);

    /**
     *
     * @param message
     */
    public void remoteUserMessage(RemoteMessage message);
}
