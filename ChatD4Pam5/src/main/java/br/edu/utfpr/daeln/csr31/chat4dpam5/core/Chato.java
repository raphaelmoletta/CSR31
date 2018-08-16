package br.edu.utfpr.daeln.csr31.chat4dpam5.core;

import br.edu.utfpr.daeln.csr31.chat4dpam5.MainView;
import br.edu.utfpr.daeln.csr31.chat4dpam5.beans.Message;

/**
 *
 * @author rapha
 */
public class Chato {

    private final MainView view;
    private static Chato instance = null;

    private Chato(MainView view) {
        this.view = view;
    }

    public static void initialize(MainView view) {
        instance = new Chato(view);
    }

    public static void send(Message message) {

    }

    public static void execute(String command) {

    }

}
