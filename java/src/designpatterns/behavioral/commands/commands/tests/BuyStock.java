package commands.tests;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class BuyStock implements Order {

	private Stock abcStock;

	public BuyStock(Stock abcStock) {

		this.abcStock = abcStock;

	}

	public void execute() {

		abcStock.buy();

	}

}
