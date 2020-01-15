package flyweights.gof;

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
public class Order {

	private final int TABLE_NUMBER;
	private final CoffeeFlavour COFFEE_FLAVOUR;

	public Order(int tableNumber, CoffeeFlavour coffeeFlavour) {
		TABLE_NUMBER = tableNumber;
		COFFEE_FLAVOUR = coffeeFlavour;
	}

	public String toString() {
		return "Order at table: " + TABLE_NUMBER + ", coffee flavour: "
				+ COFFEE_FLAVOUR.getFlavourName();
	}
}