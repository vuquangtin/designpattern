package com.designpatterns.structural.bridge;
/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class VietcomBank extends Bank {
	 
    public VietcomBank(Account account) {
        super(account);
    }
 
    @Override
    public void openAccount() {
        System.out.print("Open your account at VietcomBank is a ");
        account.openAccount();
    }
}