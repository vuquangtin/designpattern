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
public class CommandPatternDemo {

	public static void main(String[] args) {

		Stock abcStock = new Stock();

		BuyStock buyStockOrder = new BuyStock(abcStock);

		SellStock sellStockOrder = new SellStock(abcStock);

		Broker broker = new Broker();

		broker.takeOrder(buyStockOrder);

		broker.takeOrder(sellStockOrder);

		broker.placeOrders();

	}

}