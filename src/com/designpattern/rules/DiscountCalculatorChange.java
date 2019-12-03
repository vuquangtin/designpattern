package com.designpattern.rules;

import org.joda.time.DateTime;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class DiscountCalculatorChange {
	public double CalculateDiscountPercentage(Customer customer) {
		double discount = 0;
		if (isSenior(customer)) {
			discount = .05;
		}

		if (isBirthday(customer)) {
			discount = Math.max(discount, .10);
		}

		if (isExisting(customer)) {
			if (hasBeenLoyalForYears(customer, 1)) {
				discount = Math.max(discount, .10);
				if (hasBeenLoyalForYears(customer, 5)) {
					discount = Math.max(discount, .12);
					if (hasBeenLoyalForYears(customer, 10)) {
						discount = Math.max(discount, .2);
					}
				}

				if (isBirthday(customer)) {
					discount += .10;
				}
			}
		} else {
			// first time purchase discount of 15%
			discount = Math.max(discount, .15);
		}
		if (customer.getIsVeteran()) {
			discount = Math.max(discount, .10);
		}

		return discount;
	}

	private static boolean hasBeenLoyalForYears(Customer customer,
			int numberOfYears) {
		numberOfYears *= -1;
		return customer.getDateOfFirstPurchase().getMillis() < DateTime.now()
				.plusYears(numberOfYears).getMillis();
	}

	private static boolean isExisting(Customer customer) {
		return customer.getDateOfFirstPurchase() != null;
	}

	private static boolean isBirthday(Customer customer) {
		return customer.getDateOfBirth().getDayOfMonth() == DateTime.now()
				.getDayOfMonth()
				&& customer.getDateOfBirth().getDayOfMonth() == DateTime.now()
						.getDayOfMonth();
	}

	private static boolean isSenior(Customer customer) {
		return customer.getDateOfBirth().getMillis() < DateTime.now()
				.plusYears(-65).getMillis();
	}
}