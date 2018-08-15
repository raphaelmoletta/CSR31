package br.edu.utfpr.daeln.csr31.chat4dpam5.datas;

import br.edu.utfpr.daeln.csr31.chat4dpam5.interfaces.Data;

/**
 *
 * @author rapha
 */
public class DataD4Pam5 implements Data {
    private byte[] data;

    public DataD4Pam5() {
        data = new byte[4];
    }
    
    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
    
    @Override
    public String toString(){
        return "{" + data[0] + ", " + data[1] + ", " + data[2] + ", " + data[3] + "}";
    }
}
