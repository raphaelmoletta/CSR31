package br.edu.utfpr.daeln.csr31.chat4dpam5.core;

import br.edu.utfpr.daeln.csr31.chat4dpam5.beans.ChatoParameters;
import br.edu.utfpr.daeln.csr31.chat4dpam5.beans.Message;
import br.edu.utfpr.daeln.csr31.chat4dpam5.exceptions.NoSlotException;
import br.edu.utfpr.daeln.csr31.chat4dpam5.interfaces.Messenger;
import br.edu.utfpr.daeln.csr31.chat4dpam5.interfaces.Protocol;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 *
 * @author rapha
 */
public class Chato {

    private final Messenger messanger;
    private final ChatoParameters param;
    private int seq;
    private Thread listnerThread;
    private static Chato instance = null;

    public static enum Commands {
        PING
    };

    private Chato(Messenger messanger) {
        this.messanger = messanger;
        param = new ChatoParameters();
        seq = 0;
    }

    public static void initialize(Messenger messanger) {
        instance = new Chato(messanger);
        instance.listnerThread = new Thread(new ListnerThread(instance.param));
        instance.listnerThread.start();
    }

    public synchronized void send(Message m) {
        instance.param.getUsers().values().forEach((user) -> {
            try {
                DatagramSocket socket = new DatagramSocket(param.getPort(), user.getInetAddress());

                //[code][slot][reserved][reserved][reserved][message 250]
                byte[] bytes = new byte[256];
                bytes[0] = 10;
                bytes[1] = getSlot();

                System.arraycopy(m.getData(), 0, bytes, 5, m.getData().length + 5);

                DatagramPacket dp = new DatagramPacket(bytes, m.size(), user.getInetAddress(), param.getPort());
                socket.send(dp);
            } catch (SocketException e) {
            } catch (IOException ex) {
            } catch (NoSlotException ex) {
            }
        });
    }

    public synchronized void search() {

        try (DatagramSocket socket = new DatagramSocket(param.getPort() + 1, InetAddress.getByName("0.0.0.0"))) {
            socket.setBroadcast(true);
            //[code][slot][reserved][reserved][reserved][message 250]
            byte[] bytes = new byte[256];
            bytes[0] = 1;
            bytes[1] = -127;

            DatagramPacket dp = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("0.0.0.0"), param.getPort());
            socket.send(dp);
        } catch (SocketException e) {
        } catch (IOException ex) {
        }
    }

    public byte getSlot() throws NoSlotException {
        if (seq == 256) {
            seq = 0;
        }
        if (param.getSlots()[seq]) {
            param.getSlots()[seq] = false;
            seq++;
            return (byte) seq;
        } else {
            for (int i = 0; i < 256; i++) {
                if (param.getSlots()[i]) {
                    seq = i;
                    param.getSlots()[seq] = false;
                    return (byte) seq;
                }
            }
            throw new NoSlotException();
        }
    }

    public synchronized static void send(String message) {
        Message m = new Message();
        m.setEncoder(instance.param.getEncoder());
        m.setText(message);
        m.setBinary(Encoder.toBinary(message));
        m.setData(Protocol.getProtocol(instance.param.getEncoder()).encode(m.getBinary()));
        instance.send(m);
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
                    switch (parts[1]) {
                        case "start":
                            break;
                        case "stop":
                            break;
                        case "port":
                            if (parts.length >= 3) {
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
                instance.search();
                break;
            default:
                Chato.messenger().systemMessage("Invalid command: '" + parts[0] + "'", Messenger.MESSAGES_TYPES.WARN);
        }
    }

    public synchronized static void stop() {
        instance.param.setRunning(false);
    }

    public synchronized static Messenger messenger() {
        return instance.messanger;
    }

    public synchronized static boolean isDebuging() {
        return instance.param.isDebuging();
    }

    public static boolean isConnected() {
        return instance.param.getUsers().size() > 0;
    }

    public synchronized static String getNick() {
        return instance.param.getNick();
    }
}
