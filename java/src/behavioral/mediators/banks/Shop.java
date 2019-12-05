package banks;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class Shop {
	private Mediator mediator;

	private int countOfProduct;

	public void makePayment(int amount) {
		countOfProduct++;
		mediator.payment(amount);
	}

	public void payed(int sum) {
		System.out.println("Payed[" + countOfProduct + "]:" + sum);
	}

	public void setMediator(Mediator mediator) {
		this.mediator = mediator;
	}
}
