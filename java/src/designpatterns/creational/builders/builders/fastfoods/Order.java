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
public class Order {
	 
    private OrderType orderType;
    private BreadType breadType;
    private SauceType sauceType;
    private VegetableType vegetableType;
 
    public Order(OrderType orderType, BreadType breadType, SauceType sauceType, VegetableType vegetableType) {
        super();
        this.orderType = orderType;
        this.breadType = breadType;
        this.sauceType = sauceType;
        this.vegetableType = vegetableType;
    }
 
    @Override
    public String toString() {
        return "Order [orderType=" + orderType + ", breadType=" + breadType + ", sauceType=" + sauceType
                + ", vegetableType=" + vegetableType + "]";
    }
 
    public OrderType getOrderType() {
        return orderType;
    }
 
    public BreadType getBreadType() {
        return breadType;
    }
 
    public SauceType getSauceType() {
        return sauceType;
    }
 
    public VegetableType getVegetableType() {
        return vegetableType;
    }
 
}
