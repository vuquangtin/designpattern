package mediators.waiters;

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
public abstract class Waiter {
	public String country;

	// private Mediator mediator;

	Waiter(String country) {
		this.country = country;
	}

	public abstract void say();

	// public void setMediator(Mediator mediator) {
	// this.mediator = mediator;
	// }
}

class ChineseWaiter extends Waiter {

	public ChineseWaiter() {
		super("chinese");
	}

	@Override
	public void say() {
		System.out.println("世界，你好");
	}

}

class EnglishWaiter extends Waiter {

	public EnglishWaiter() {
		super("english");
	}

	@Override
	public void say() {
		System.out.println("hello world!");
	}

}

class GermanWaiter extends Waiter {

	public GermanWaiter() {
		super("german");
	}

	@Override
	public void say() {
		System.out.println("Hallo Welt");
	}

}