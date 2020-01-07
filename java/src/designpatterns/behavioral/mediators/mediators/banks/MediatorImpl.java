package mediators.banks;

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
public class MediatorImpl implements Mediator {
	private Shop shop;
	private Bank bank;

	public MediatorImpl(Shop shop, Bank bank) {
		this.shop = shop;
		this.bank = bank;
	}

	@Override
	public void informOfIncreasing(int sum) {
		shop.payed(sum);
	}

	@Override
	public void payment(int amount) {
		bank.addMoney(amount);
	}

	@Override
	public void pay(int amount) {
		shop.makePayment(amount);
	}
}