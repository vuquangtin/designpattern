package com.designpatterns.structural.bridge;
/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class CheckingAccount implements Account {
	 
    @Override
    public void openAccount() {
        System.out.println("Checking Account");
    }
}