package br.edu.utfpr.daeln.csr31.chat4dpam5.beans;

import java.net.DatagramPacket;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 *
 * @author rapha
 */
public class ListnerData {
    private boolean running = true;
    private final Queue<DatagramPacket> queue;

    public ListnerData() {
        this.queue = new ConcurrentLinkedQueue<>();
    }
    
    public synchronized boolean keepRuning() {
        return running;
    }
    
    public synchronized void setRunning(boolean status) {
        running = status;
    }

    public synchronized void add(DatagramPacket dp) {
        queue.add(dp);
    }

    public synchronized void stop() {
        running = false;
    }
}
