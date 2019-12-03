package com.designpatterns.creational.builder.banks;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class Client {

	public static void main(String[] args) {
		BankAccount account = new BankAccount.Builder(1234L).withOwner("Marge")
				.atBranch("Springfield").openingBalance(100).atRate(2.5)
				.build();
		System.out.println(account.getAccountNumber());
		BankAccount anotherAccount = new BankAccount.Builder(4567L)
				.withOwner("Homer").atBranch("Springfield").openingBalance(100)
				.atRate(2.5).build();
		System.out.println(anotherAccount.getAccountNumber());

	}
}
