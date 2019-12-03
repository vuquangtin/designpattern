package com.designpattern.mvp;
/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class Model {
    private String password;
    
    public Model() {
        password = "password"; //just set a default password.
    }
    
    public void setPassword(String pass) {
        password = pass;
    }
    
    public String getPassword() {
        return password;
    }
}

