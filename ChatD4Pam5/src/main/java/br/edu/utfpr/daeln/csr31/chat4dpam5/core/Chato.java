package br.edu.utfpr.daeln.csr31.chat4dpam5.core;

import br.edu.utfpr.daeln.csr31.chat4dpam5.beans.ChatoParameters;
import br.edu.utfpr.daeln.csr31.chat4dpam5.beans.Message;
import br.edu.utfpr.daeln.csr31.chat4dpam5.interfaces.Messenger;
import br.edu.utfpr.daeln.csr31.chat4dpam5.interfaces.Protocol;

/**
 *
 * @author rapha
 */
public class Chato {
    private final Messenger messanger;
    private final ChatoParameters param;
    private static Chato instance = null;

    private Chato(Messenger messanger) {
        this.messanger = messanger;
        param = new ChatoParameters();
    }

    public static void initialize(Messenger messanger) {
        instance = new Chato(messanger);
    }

    public synchronized static void send(String message) {
        Message m = new Message();
        m.setEncoder(instance.param.getEncoder());
        m.setText(message);
        m.setBinary(Encoder.toBinary(message));
        m.setData(Protocol.getProtocol(instance.param.getEncoder()).encode(m.getBinary()));
        Chato.messenger().userMessage(m);
    }

    public static void execute(String command) {
        String parts[] = command.trim().split(" ");
        if ("/nick".equals(parts[0].trim().toLowerCase())) {
            if (parts.length >= 2) {
                instance.param.setNick(parts[1]);
                if (parts[1].length() > 15) {
                    Chato.messenger().systemMessage("Max lenght to nick is 15 characteres." + parts[1], Messenger.MESSAGES_TYPES.ERROR);
                    return;
                }
                Chato.messenger().systemMessage("New Nick : " + parts[1], Messenger.MESSAGES_TYPES.INFO);
                return;
            } else {
                Chato.messenger().systemMessage("Command syntax: /nick <newNick>", Messenger.MESSAGES_TYPES.HELP);
                return;
            }

        }
        for (int i = 0; i < parts.length; i++) {
            parts[i] = parts[i].trim().toLowerCase();
        }

        switch (parts[0]) {
            case "/list":
                if (parts.length > 1) {

                } else {
                    Chato.messenger().systemMessage("Command syntax: /list <subcommand>", Messenger.MESSAGES_TYPES.HELP);
                    Chato.messenger().systemMessage("  - users", Messenger.MESSAGES_TYPES.HELP);
                    Chato.messenger().systemMessage("  - servers", Messenger.MESSAGES_TYPES.HELP);
                    Chato.messenger().systemMessage("  - config", Messenger.MESSAGES_TYPES.HELP);
                }
                break;
            case "/server":
                if (parts.length > 1) {
                    switch(parts[1]) {
                        case "start" :
                            break;
                        case "stop" :
                            break;
                        case "port" :
                            if(parts.length >= 3) {
                                try {
                                    instance.param.setPort(Integer.parseInt(parts[2]));
                                    Chato.messenger().systemMessage("New port: " + instance.param.getPort(), Messenger.MESSAGES_TYPES.INFO);
                                } catch (NumberFormatException e) {
                                    Chato.messenger().systemMessage("Parameter is not a number.", Messenger.MESSAGES_TYPES.WARN);
                                }
                            } else {
                                Chato.messenger().systemMessage("Missing port number parameter", Messenger.MESSAGES_TYPES.WARN);
                            }
                            break;
                    }
                } else {
                    Chato.messenger().systemMessage("Command syntax: /server <subcommand>", Messenger.MESSAGES_TYPES.HELP);
                    Chato.messenger().systemMessage("  - start", Messenger.MESSAGES_TYPES.HELP);
                    Chato.messenger().systemMessage("  - stop", Messenger.MESSAGES_TYPES.HELP);
                    Chato.messenger().systemMessage("  - port <n.port>", Messenger.MESSAGES_TYPES.HELP);
                }
                break;
            case "/connect":
                break;
            default:
                Chato.messenger().systemMessage("Invalid command: '" + parts[0] + "'", Messenger.MESSAGES_TYPES.WARN);
        }
    }

    public synchronized static Messenger messenger() {
        return instance.messanger;
    }
    
    public synchronized static boolean isDebuging() {
        return instance.param.isDebuging();
    }
    
    
    public synchronized static String getNick() {
        return instance.param.getNick();
    }
}
