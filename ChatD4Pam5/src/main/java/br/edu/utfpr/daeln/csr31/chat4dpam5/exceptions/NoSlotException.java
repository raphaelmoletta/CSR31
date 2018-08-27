package br.edu.utfpr.daeln.csr31.chat4dpam5.exceptions;

/**
 *
 * @author rapha
 */
public class NoSlotException extends Exception {
    @Override
    public String getLocalizedMessage() {
        return "Not avaliable slot";
    }
}
