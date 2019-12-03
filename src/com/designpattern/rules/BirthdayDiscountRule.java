package com.designpattern.rules;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class BirthdayDiscountRule implements IDiscountRule {
	public double calculateCustomerDiscount(Customer customer) {
		return customer.getDateOfBirth() == null ? 0.10 : 0;
	}
}
