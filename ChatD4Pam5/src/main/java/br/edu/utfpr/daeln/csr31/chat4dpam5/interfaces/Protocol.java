/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.daeln.csr31.chat4dpam5.interfaces;

/**
 *
 * @author rapha
 */
public interface Protocol {
    public abstract Data[] encode(String binaryMsg);
    public abstract String decode(Data[] message);
}
