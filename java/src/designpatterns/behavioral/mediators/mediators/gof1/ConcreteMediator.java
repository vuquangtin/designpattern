package mediators.gof1;

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
class ConcreteMediator implements Mediator {

	private FirstPartner first;
	private SecondPartner second;

	public void registerFirstPartner(FirstPartner partner) {
		first = partner;
	}

	public void registerSecondPartner(SecondPartner partner) {
		second = partner;
	}

	public String executeFirstPartner() {
		return first.execute();
	}

	public String executeSecondPartner() {
		return second.execute();
	}

	public FirstPartner getFirstPartner() {
		return first;
	}

	public SecondPartner getSecondPartner() {
		return second;
	}
}