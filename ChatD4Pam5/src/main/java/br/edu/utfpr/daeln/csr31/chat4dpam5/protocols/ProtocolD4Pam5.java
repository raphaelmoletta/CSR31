/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.daeln.csr31.chat4dpam5.protocols;

import br.edu.utfpr.daeln.csr31.chat4dpam5.datas.DataD4Pam5;
import br.edu.utfpr.daeln.csr31.chat4dpam5.interfaces.Data;
import br.edu.utfpr.daeln.csr31.chat4dpam5.interfaces.Protocol;

/**
 *
 * @author rapha
 */
public class ProtocolD4Pam5 implements Protocol {
    @Override
    public String decode(Data[] message) {
        if(message instanceof DataD4Pam5[]) {
            StringBuilder result = new StringBuilder();
            for(DataD4Pam5 data : (DataD4Pam5[]) message) {
                result.append(convert(data.getData()[0],
                        data.getData()[1],
                        data.getData()[2],
                        data.getData()[3]));
            }
            return result.toString();
        }
        return "";
    }

    @Override
    public Data[] encode(String binaryMsg) {
        DataD4Pam5[] result = new DataD4Pam5[binaryMsg.length() /8];
        int pos = 0;
        for(int i = 0; i < binaryMsg.length() / 8; i++) {
            result[i] = new DataD4Pam5();
            pos = i * 8;
            for(int j = 0; j < 4; j++) {
                result[i].getData()[j] = convert(binaryMsg.charAt(pos + j*2), binaryMsg.charAt(pos + (j*2) + 1));    
            }
        }
        return result;
    }
    
    private char convert(int i0, int i1, int i2, int i3) {
        int sum = 0;
        switch(i0) {
            case -1:
                sum+=64;
                break;
            case 1:
                sum+=128;
                break;
            case 2:
                sum +=192;
                break;
        }
        switch(i1) {
            case -1:
                sum+=16;
                break;
            case 1:
                sum+=32;
                break;
            case 2:
                sum +=48;
                break;
        }
        switch(i2) {
            case -1:
                sum+=4;
                break;
            case 1:
                sum+=8;
                break;
            case 2:
                sum +=12;
                break;
        }
        switch(i3) {
            case -1:
                sum+=1;
                break;
            case 1:
                sum+=2;
                break;
            case 2:
                sum +=3;
                break;
        }
        return (char)sum;
    }
    
    private byte convert(char c1, char c2) {
        if(c1 == '0' && c2 == '0') {
            return -2;
        } else if(c1 == '0' && c2 == '1'){
            return -1;
        }else if(c1 == '1' && c2 == '0'){
            return 1;
        } else {
            return 2;
        }
    }
}
