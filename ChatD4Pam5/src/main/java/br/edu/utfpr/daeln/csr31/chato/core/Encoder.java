/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.daeln.csr31.chato.core;

/**
 *
 * @author rapha
 */
public class Encoder {
    public static String toBinary(String message) {
        String result = "";
        for(char c : message.toCharArray()) {
            result += toBinary(c);
        }
        return result;
    }
    
    public static String toBinary(char c) {
        int b = (int) c;
        int count = 1;
        String result = "";
        for(int i = 7; i >= 0; i--) {
            int factor = (int) Math.pow(2,i);
            if(b >= factor) {
                result += "1";
                b -= factor;
            } else {
                result += "0";
            }
        }
        return result;
    }
    
    public static String toString(String binaryMessage) {
        String result = "";
        if(binaryMessage.length() % 8 == 0) {
            int c = 7, sum = 0;
            StringBuilder res = new StringBuilder("");
            for(int i = 0; i < binaryMessage.length(); i++) {
                if(binaryMessage.charAt(i) == '1') {
                    sum += Math.pow(2, c);
                }
                if(c == 0) {
                    c = 8;
                    res.append((char) sum);
                    sum = 0;
                }
                c--;
                
            }
            result = res.toString();
        }
        return result;
    }
    
    public static char toChar(String byteMsg) {
        if(byteMsg.length() == 8) {
            int result = 0;
            for(int i = 0; i < 8; i++) {
                if(byteMsg.charAt(i) == '1') {
                    result += Math.pow(2, i);
                }
            }
            return (char) result;
        }
        return (char)0;
    }
}
