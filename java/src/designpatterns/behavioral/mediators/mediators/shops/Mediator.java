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
public interface Mediator {
	void registerSeller(Seller seller);

	void registerBuyer(Buyer buyer);

	void sell(Seller seller);

	void buy(Buyer buyer);
}