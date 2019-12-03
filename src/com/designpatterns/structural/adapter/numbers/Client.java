package com.designpatterns.structural.adapter.numbers;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class Client {
	public static void main(String[] args) {
		PhoneTarget phoneTarget = new Adapter();
		String input1 = "sdflkqweqweq";
		String input2 = "123";
		String input3 = "01234342342";
		System.out.println(input1 + " is phone number: "
				+ phoneTarget.checkPhoneNumber(input1));
		System.out.println(input2 + " is phone number: "
				+ phoneTarget.checkPhoneNumber(input2));
		System.out.println(input3 + " is phone number: "
				+ phoneTarget.checkPhoneNumber(input3));
	}
}