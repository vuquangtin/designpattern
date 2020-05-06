package designpatterns.gof.behavioral.command.demo;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <h1>Command</h1> Đóng gói một yêu cầu request như một đối tượng, bằng cách đó
 * cho phép bạn tham số hóa các client với các request khác nhau, các queue và
 * log request, và hỗ trợ các hoạt động (operation) có thể “undo”.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
// Client
public class StockOrderCommandDemo {
	public static void main(String[] args) {
		StockTrade stock = new StockTrade();
		BuyStockOrder bsc = new BuyStockOrder(stock);
		SellStockOrder ssc = new SellStockOrder(stock);
		Agent agent = new Agent();

		agent.placeOrder(bsc); // Buy Shares
		agent.placeOrder(ssc); // Sell Shares
	}
}

interface Order {
	public abstract void execute();
}

// Receiver class.
class StockTrade {
	public void buy() {
		System.out.println("You want to buy stocks");
	}

	public void sell() {
		System.out.println("You want to sell stocks ");
	}
}

// Invoker.
class Agent {
	private Deque ordersQueue = new LinkedList();

	public Agent() {
	}

	void placeOrder(Order order) {
		ordersQueue.addLast(order);
		order.execute();
	}
}

// ConcreteCommand Class.
class BuyStockOrder implements Order {
	private StockTrade stock;

	public BuyStockOrder(StockTrade st) {
		stock = st;
	}

	public void execute() {
		stock.buy();
	}
}

// ConcreteCommand Class.
class SellStockOrder implements Order {
	private StockTrade stock;

	public SellStockOrder(StockTrade st) {
		stock = st;
	}

	public void execute() {
		stock.sell();
	}
}