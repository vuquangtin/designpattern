package com.designpatterns.behavioral.observer.datastore;

import java.util.Observable;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class DataStore extends Observable{
    private String data;
    
    public String getData() {
        return this.data;
    }
    
    public void setData(String newData) {
        this.data = newData;
        
        // setChanged() method called from Observable class.
        // apply change data. if you have not call this method, all action will not effect.
        setChanged();
    }
}