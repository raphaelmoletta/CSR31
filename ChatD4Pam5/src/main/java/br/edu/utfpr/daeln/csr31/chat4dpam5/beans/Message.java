/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.daeln.csr31.chat4dpam5.beans;

import br.edu.utfpr.daeln.csr31.chat4dpam5.interfaces.Data;
import br.edu.utfpr.daeln.csr31.chat4dpam5.interfaces.Protocol;
import br.edu.utfpr.daeln.csr31.chat4dpam5.interfaces.Protocol.ENCODER;
import java.time.LocalDateTime;

/**
 *
 * @author rapha
 */
public class Message {
    private String text = "", binary = "", encoded = "";
    private ENCODER encoder = Protocol.ENCODER.D4Pam5;
    private LocalDateTime time = LocalDateTime.now();
    private Data[] data = null;

    public Data[] getData() {
        return data;
    }

    public void setData(Data[] data) {
        this.data = data;
    }
 
    public ENCODER getEncoder() {
        return encoder;
    }

    public void setEncoder(ENCODER encoder) {
        this.encoder = encoder;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getBinary() {
        return binary;
    }

    public void setBinary(String binary) {
        this.binary = binary;
    }

    public String getEncoded() {
        return encoded;
    }

    public void setEncoded(String encoded) {
        this.encoded = encoded;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
    
    
}
