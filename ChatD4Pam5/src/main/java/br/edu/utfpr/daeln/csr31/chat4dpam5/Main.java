/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.daeln.csr31.chat4dpam5;

import br.edu.utfpr.daeln.csr31.chat4dpam5.core.Encoder;
import br.edu.utfpr.daeln.csr31.chat4dpam5.datas.DataD4Pam5;
import br.edu.utfpr.daeln.csr31.chat4dpam5.gui.MainView;
import br.edu.utfpr.daeln.csr31.chat4dpam5.interfaces.Data;
import br.edu.utfpr.daeln.csr31.chat4dpam5.interfaces.Protocol;
import br.edu.utfpr.daeln.csr31.chat4dpam5.protocols.ProtocolD4Pam5;

/**
 *
 * @author rapha
 */
public class Main {
    public static void main(String[] args) {
        String coco = Encoder.toBinary("Bosta com çã'*ô");
        System.out.println(coco);
        ProtocolD4Pam5 d4Pam5 = new ProtocolD4Pam5();
        Data[] data = d4Pam5.encode(coco);
        for(Data d : data) {
            System.out.println(d.toString());
        }
        System.out.println(d4Pam5.decode(data));
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainView().setVisible(true);
            }
        });
    }
}
