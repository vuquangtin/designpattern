package mediators.shops;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */


public class BuyerImpl implements Buyer {
	private final Mediator mediator;
	private final int price;

	public BuyerImpl(Mediator mediator, int price) {
		this.mediator = mediator;
		this.price = price;
		mediator.registerBuyer(this);
	}

	@Override
	public void buy() {
		mediator.buy(this);
	}

	@Override
	public int getPrice() {
		return price;
	}
}