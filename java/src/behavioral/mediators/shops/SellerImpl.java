package shops;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class SellerImpl implements Seller {
	private final Mediator mediator;
	private final int price;

	public SellerImpl(Mediator mediator, int price) {
		this.mediator = mediator;
		this.price = price;
		mediator.registerSeller(this);
	}

	@Override
	public void sell() {
		mediator.sell(this);
	}

	@Override
	public int getPrice() {
		return price;
	}
}
