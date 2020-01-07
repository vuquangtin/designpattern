package mediators.shops;

/**
 * <h1>Mediator</h1> Định nghĩa 1 đối tượng đóng gói cách 1 tập hợp các đối
 * tượng tương tác. Mediator thúc đẩy sự khớp nối lỏng lẻo bằng cách ngăn không
 * cho các đối tượng đề cập đến nhau 1 cách rõ ràng và nó cho phép bạn thay đổi
 * sự tương tác của chúng 1 cách độc lập.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/designpattern">https://github.com
 *      /vuquangtin/designpattern</a>
 *
 */
public class Demo {
	public static void main(String[] args) {
		Mediator mediator = new MediatorImpl();
		Buyer buyerA = new BuyerImpl(mediator, 10);
		Buyer buyerB = new BuyerImpl(mediator, 2);
		Seller sellerA = new SellerImpl(mediator, 10);
		Seller sellerB = new SellerImpl(mediator, 30);
		buyerA.buy();
		buyerB.buy();
		sellerB.sell();
		// 会报错
		sellerA.sell();
	}

}