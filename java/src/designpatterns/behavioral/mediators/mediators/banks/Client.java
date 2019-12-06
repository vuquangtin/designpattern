package mediators.banks;

/**
 * <h2>Design Patterns</h2> <h3>Mediator</h3> <i>Định nghĩa 1 đối tượng đóng gói
 * cách 1 tập hợp các đối tượng tương tác. Mediator thúc đẩy sự khớp nối lỏng
 * lẻo bằng cách ngăn không cho các đối tượng đề cập đến nhau 1 cách rõ ràng và
 * nó cho phép bạn thay đổi sự tương tác của chúng 1 cách độc lập.</i>
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class Client {
	public static void main(String[] args) {
		Shop shop = new Shop();
		Bank bank = new Bank();
		Mediator mediator = new MediatorImpl(shop, bank);

		shop.setMediator(mediator);
		bank.setMediator(mediator);

		mediator.pay(300);
		mediator.pay(300);
		mediator.pay(300);
	}
}