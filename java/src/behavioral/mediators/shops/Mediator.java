package shops;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public interface Mediator {
	void registerSeller(Seller seller);

	void registerBuyer(Buyer buyer);

	void sell(Seller seller);

	void buy(Buyer buyer);
}