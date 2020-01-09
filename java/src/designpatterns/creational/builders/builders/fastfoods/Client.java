package builders.fastfoods;

/**
 * <h1>Builder</h1> Tách rời việc xây dựng (khởi tạo) của một đối tượng phức tạp
 * khỏi phần biểu diễn của nó sao cho cùng 1 tiến trình xây dựng (khởi tạo) có
 * thể tạo ra các biểu diễn khác nhau.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class Client {

	public static void main(String[] args) {
		Order order = new FastFoodOrderBuilder().orderType(OrderType.ON_SITE)
				.orderBread(BreadType.OMELETTE).orderSauce(SauceType.SOY_SAUCE)
				.build();
		System.out.println(order);
	}
}