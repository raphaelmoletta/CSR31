package br.edu.utfpr.daeln.csr31.chat4dpam5.core;

import br.edu.utfpr.daeln.csr31.chat4dpam5.beans.ConfigurationData;
import br.edu.utfpr.daeln.csr31.chat4dpam5.beans.ListnerData;

/**
 *
 * @author rapha
 */
public class CoreThread implements Runnable {

    private final ConfigurationData config;
    private final ListnerData listner;
    
    public CoreThread(ConfigurationData config, ListnerData listner) {
        this.listner = listner;
        this.config = config;
    }

    
    
    @Override
    public void run() {
        while(config.isRunning()){
            
        }
    }
    
}
