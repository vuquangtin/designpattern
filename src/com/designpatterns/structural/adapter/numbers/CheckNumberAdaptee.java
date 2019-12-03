package com.designpatterns.structural.adapter.numbers;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class CheckNumberAdaptee {

	public boolean checkNumber(String input) {
		String regex = "[0-9]+";
		return input.matches(regex);
	}
}