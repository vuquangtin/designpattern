package com.designpattern.rules;

import java.util.ArrayList;
import java.util.List;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class RulesDiscountCalculator implements IDiscountCalculator {
	List<IDiscountRule> rules = new ArrayList<IDiscountRule>();

	public RulesDiscountCalculator() {
		rules.add(new BirthdayDiscountRule());
		rules.add(new SeniorDiscountRule());
		rules.add(new VeteranDiscountRule());
		rules.add(new LoyalCustomerRule(1, 0.10));
		rules.add(new LoyalCustomerRule(5, 0.12));
		rules.add(new LoyalCustomerRule(10, 0.20));
		rules.add(new NewCustomerRule());
	}

	public double calculateDiscountPercentage(Customer customer) {
		double discount = 0;
		for (IDiscountRule rule : rules) {

			discount = Math.max(rule.calculateCustomerDiscount(customer),
					discount);
		}

		return discount;
	}
}