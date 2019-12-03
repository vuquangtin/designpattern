package com.designpatterns.structural.bridge;
/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class TPBank extends Bank {
	 
    public TPBank(Account account) {
        super(account);
    }
 
    @Override
    public void openAccount() {
        System.out.print("Open your account at TPBank is a ");
        account.openAccount();
    }
}