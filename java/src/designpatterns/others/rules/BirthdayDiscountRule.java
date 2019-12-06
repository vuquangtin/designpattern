package rules;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class BirthdayDiscountRule implements IDiscountRule {
	public double calculateCustomerDiscount(Customer customer) {
		return customer.getDateOfBirth() == null ? 0.10 : 0;
	}
}
