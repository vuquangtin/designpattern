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
public class SellerImpl implements Seller {
	private final Mediator mediator;
	private final int price;

	public SellerImpl(Mediator mediator, int price) {
		this.mediator = mediator;
		this.price = price;
		mediator.registerSeller(this);
	}

	@Override
	public void sell() {
		mediator.sell(this);
	}

	@Override
	public int getPrice() {
		return price;
	}
}
