package com.designpatterns.structural.bridge;
/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class Client {
	 
    public static void main(String[] args) {
        Bank vietcomBank = new VietcomBank(new CheckingAccount());
        vietcomBank.openAccount();
 
        Bank tpBank = new TPBank(new CheckingAccount());
        tpBank.openAccount();
    }
}