package br.edu.utfpr.daeln.csr31.chato.interfaces;

import br.edu.utfpr.daeln.csr31.chato.beans.Message;
import br.edu.utfpr.daeln.csr31.chato.beans.RemoteMessage;

/**
 *
 * @author rapha
 */
public interface Messenger {
    public enum MESSAGES_TYPES {HELP, INFO, WARN, ERROR, DEBUG}
    public void userMessage(Message message);
    public void systemMessage(String message, MESSAGES_TYPES type);
    public void remoteUserMessage(RemoteMessage message);
}
