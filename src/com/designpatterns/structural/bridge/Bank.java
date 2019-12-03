package com.designpatterns.structural.bridge;
/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public abstract class Bank {
	 
    protected Account account;
 
    public Bank(Account account) {
        this.account = account;
    }
 
    public abstract void openAccount();
}