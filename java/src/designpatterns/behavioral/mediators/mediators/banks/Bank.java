package mediators.banks;
/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
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