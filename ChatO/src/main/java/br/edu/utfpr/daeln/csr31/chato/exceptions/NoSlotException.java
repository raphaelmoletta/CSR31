package br.edu.utfpr.daeln.csr31.chato.exceptions;

/**
 *
 * @author rapha
 */
public class NoSlotException extends Exception {

    /**
     *
     * @return
     */
    @Override
    public String getLocalizedMessage() {
        return "Not avaliable slot";
    }
}
