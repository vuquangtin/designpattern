package flyweights.gof;

import java.util.ArrayList;

/**
 * <h1>Flyweight</h1> Sử dụng việc chia sẻ để hỗ trợ số lượng lớn các đối tượng
 * fine-graied cỡ nhỏ 1 cách hiệu quả
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com

 *      /vuquangtin/designpattern</a>
 *
 */
public class CoffeeShop {

	private Menu menu = new Menu();
	private ArrayList<Order> orders = new ArrayList<Order>();

	public void getOrder(int tableNumber, String coffeeFlavour) {
		orders.add(new Order(tableNumber, menu.lookup(coffeeFlavour)));
	}

	public String toString() {
		String report = "";

		for (Order order : orders) {
			report += order.toString() + "\n";
		}

		return report;
	}
}