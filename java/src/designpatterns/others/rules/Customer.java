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
public class Customer {
	private DateTime dateOfFirstPurchase;
	private DateTime dateOfBirth;
	private boolean isVeteran;

	public DateTime getDateOfFirstPurchase() {
		return dateOfFirstPurchase;
	}

	public void setDateOfFirstPurchase(DateTime dateOfFirstPurchase) {
		this.dateOfFirstPurchase = dateOfFirstPurchase;
	}

	public DateTime getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(DateTime dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public boolean getIsVeteran() {
		return isVeteran;
	}

	public void setIsVeteran(boolean isVeteran) {
		this.isVeteran = isVeteran;
	}

	public boolean hasBeenLoyalForYears(int yearsAsCustomer, DateTime date) {		
		return false;
	}
}