package com.designpattern.eventhandling;
/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class ImplSynchronousEventListener implements SynchronousListener { 
  
    @Override
    public void onSynchronousEvent() 
    { 
        System.out.println("Performing callback after synchronous Task"); 
        // perform some routine operation 
    } 
    // some class A methods 
} 