package com.designpatterns.structural.adapter.numbers;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class Adapter implements PhoneTarget {
	CheckNumberAdaptee checkNumberAdapptee = new CheckNumberAdaptee();

	@Override
	public boolean checkPhoneNumber(String input) {
		if (!checkNumberAdapptee.checkNumber(input)) {
			return false;
		}
		if (input.length() > 11 || input.length() < 10) {
			return false;
		}
		return true;
	}
}