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

    /**
     *
     * @return
     */
    public Data[] getData() {
        return data;
    }

    /**
     *
     * @param data
     */
    public void setData(Data[] data) {
        encoded = "";
        for (Data d : data) {
            encoded += d.toString();
        }
        this.data = data;
    }

    /**
     *
     * @return
     */
    public ENCODER getEncoder() {
        return encoder;
    }

    /**
     *
     * @param encoder
     */
    public void setEncoder(ENCODER encoder) {
        this.encoder = encoder;
    }

    /**
     *
     * @return
     */
    public String getText() {
        return text;
    }

    /**
     *
     * @param text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     *
     * @return
     */
    public String getBinary() {
        return binary;
    }

    /**
     *
     * @param binary
     */
    public void setBinary(String binary) {
        this.binary = binary;
    }

    /**
     *
     * @return
     */
    public String getEncoded() {
        return encoded;
    }

    /**
     *
     * @param encoded
     */
    public void setEncoded(String encoded) {
        this.encoded = encoded;
    }

    /**
     *
     * @return
     */
    public LocalDateTime getTime() {
        return time;
    }

    /**
     *
     * @param time
     */
    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    /**
     *
     * @return
     */
    public int size() {
        return data.length;
    }
}
