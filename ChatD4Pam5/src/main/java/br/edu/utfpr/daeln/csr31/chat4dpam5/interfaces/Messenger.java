package br.edu.utfpr.daeln.csr31.chat4dpam5.interfaces;

import br.edu.utfpr.daeln.csr31.chat4dpam5.beans.Message;
import br.edu.utfpr.daeln.csr31.chat4dpam5.beans.RemoteMessage;

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
