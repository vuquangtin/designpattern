package com.designpattern.concurrent.beginner;
/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class Temp6 {
    private String name;
 
    public String getName() {
        synchronized(this.name){
            return name;
        }
    }
 
    public void setName(String name) {
        synchronized(this.name){
            this.name = name;
        }
    }
}