package banks;
/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */

public class Bank {
	private int amount;
	private Mediator mediator;

	public void addMoney(int sum) {
		amount = amount + sum;
		mediator.informOfIncreasing(sum);
	}

	public void setMediator(Mediator mediator) {
		this.mediator = mediator;
	}
}