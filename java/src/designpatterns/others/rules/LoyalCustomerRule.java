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
public class LoyalCustomerRule implements IDiscountRule
{
    private int yearsAsCustomer;
    private double discount;
    private  DateTime date;

    public LoyalCustomerRule(int yearsAsCustomer, double discount, DateTime date)
    {
        this.yearsAsCustomer = yearsAsCustomer;
        this.discount = discount;
        this.date = date;
    }

    public LoyalCustomerRule(int i, double d) {
		// TODO Auto-generated constructor stub
	}

	public double calculateCustomerDiscount(Customer customer)
    {
        if (customer.hasBeenLoyalForYears(yearsAsCustomer, date))
        {
        	IDiscountRule birthdayRule = new BirthdayDiscountRule();

            return discount + birthdayRule.calculateCustomerDiscount(customer);
        }
        return 0;
    }
}