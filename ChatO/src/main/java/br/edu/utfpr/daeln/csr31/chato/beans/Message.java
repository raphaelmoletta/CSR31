package br.edu.utfpr.daeln.csr31.chato.beans;

import br.edu.utfpr.daeln.csr31.chato.interfaces.Data;
import br.edu.utfpr.daeln.csr31.chato.interfaces.Protocol;
import br.edu.utfpr.daeln.csr31.chato.interfaces.Protocol.ENCODER;
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
        encoded = "";
        for (Data d : data) {
            encoded += d.toString();
        }
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

    public int size() {
        return data.length;
    }
}
