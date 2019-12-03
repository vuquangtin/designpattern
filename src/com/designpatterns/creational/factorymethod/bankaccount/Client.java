package com.designpatterns.creational.factorymethod.bankaccount;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class Client {

	public static void main(String[] args) {
		BankAccount newAccount = new BankAccount.BankAccountBuilder("GP Coder",
				"0123456789").withEmail("contact@gpcoder.com")
				.wantNewsletter(true).build();
		System.out.println(newAccount);
	}
}