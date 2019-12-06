package rules;

import org.joda.time.DateTime;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class DiscountCalculator {
	public double CalculateDiscountPercentage(Customer customer) {
		double discount = 0;
		if (customer.getDateOfBirth().getMillis() < new DateTime().plusYears(
				-65).getMillis()) {
			// senior discount 5%
			discount = .05;
		}

		if (customer.getDateOfBirth().getDayOfMonth() == DateTime.now()
				.getDayOfMonth()
				&& customer.getDateOfBirth().getMonthOfYear() == DateTime.now()
						.getMonthOfYear()) {
			// birthday 10%
			discount = Math.max(discount, .10);
		}

		if (customer.getDateOfFirstPurchase() != null) {
			if (customer.getDateOfFirstPurchase().getMillis() < DateTime.now()
					.plusYears(-1).getMillis()) {
				// after 1 year, loyal customers get 10%
				discount = Math.max(discount, .10);
				if (customer.getDateOfFirstPurchase().getMillis() < DateTime
						.now().plusYears(-5).getMillis()) {
					// after 5 years, 12%
					discount = Math.max(discount, .12);
					if (customer.getDateOfFirstPurchase().getMillis() < DateTime
							.now().plusYears(-10).getMillis()) {
						// after 10 years, 20%
						discount = Math.max(discount, .2);
					}
				}

				if (customer.getDateOfBirth().getDayOfMonth() == DateTime.now()
						.getDayOfMonth()
						&& customer.getDateOfBirth().getDayOfMonth() == DateTime
								.now().getDayOfMonth()) {
					// birthday additional 10%
					discount += .10;
				}
			}
		} else {
			// first time purchase discount of 15%
			discount = Math.max(discount, .15);
		}
		if (customer.getIsVeteran()) {
			// veterans get 10%
			discount = Math.max(discount, .10);
		}

		return discount;
	}
}