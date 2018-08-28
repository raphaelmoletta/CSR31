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

    /**
     *
     * @param message
     * @return
     */
    public static String toBinary(String message) {
        StringBuilder result = new StringBuilder();
        for(char c : message.toCharArray()) {
            result.append(toBinary(c));
        }
        return result.toString();
    }
    
    /**
     *
     * @param c
     * @return
     */
    public static String toBinary(char c) {
        int b = (int) c;
        int count = 1;
        StringBuilder result = new StringBuilder();
        for(int i = 7; i >= 0; i--) {
            int factor = (int) Math.pow(2,i);
            if(b >= factor) {
                result.append("1");
                b -= factor;
            } else {
                result.append("0");
            }
        }
        return result.toString();
    }
    
    /**
     *
     * @param binaryMessage
     * @return
     */
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
    
    /**
     *
     * @param byteMsg
     * @return
     */
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
