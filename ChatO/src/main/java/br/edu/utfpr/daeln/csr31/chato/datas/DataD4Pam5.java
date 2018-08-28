package br.edu.utfpr.daeln.csr31.chato.datas;

import br.edu.utfpr.daeln.csr31.chato.interfaces.Data;

/**
 *
 * @author rapha
 */
public class DataD4Pam5 implements Data {
    private byte[] data;

    /**
     * DataD4Pam5
     */
    public DataD4Pam5() {
        data = new byte[4];
    }
    
    /**
     *
     * @return
     */
    public byte[] getData() {
        return data;
    }

    /**
     *
     * @param data
     */
    public void setData(byte[] data) {
        this.data = data;
    }
    
    @Override
    public String toString(){
        return "{" + data[0] + ", " + data[1] + ", " + data[2] + ", " + data[3] + "}";
    }
}
