package com.designpattern.concurrent.thread;
/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class BetterRunnable implements Runnable {
    @Override
    public void run() {
        while(!Thread.currentThread().isInterrupted()){
            //Heavy operation
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            //Other operation
        }
    }
}