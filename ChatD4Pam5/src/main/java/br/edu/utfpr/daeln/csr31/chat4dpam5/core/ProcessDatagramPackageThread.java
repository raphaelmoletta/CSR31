package br.edu.utfpr.daeln.csr31.chat4dpam5.core;

import br.edu.utfpr.daeln.csr31.chat4dpam5.beans.ConfigurationData;
import java.net.DatagramPacket;

/**
 *
 * @author rapha
 */
public class ProcessDatagramPackageThread implements Runnable {

    private final DatagramPacket dp;
    private final ConfigurationData config;
    public ProcessDatagramPackageThread(DatagramPacket dp, ConfigurationData config) {
        this.dp = dp;
        this.config = config;
    }
    
    @Override
    public void run() {
        
    }
    
}
