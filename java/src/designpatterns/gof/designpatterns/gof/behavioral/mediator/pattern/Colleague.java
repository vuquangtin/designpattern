package designpatterns.gof.behavioral.mediator.pattern;

/**
 * <h1>Mediator</h1> Định nghĩa 1 đối tượng đóng gói cách 1 tập hợp các đối
 * tượng tương tác. Mediator thúc đẩy sự khớp nối lỏng lẻo bằng cách ngăn không
 * cho các đối tượng đề cập đến nhau 1 cách rõ ràng và nó cho phép bạn thay đổi
 * sự tương tác của chúng 1 cách độc lập.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com

 *      /vuquangtin/designpattern</a>
 *
 */
public abstract class Colleague {

	protected Mediator mediator;

	public Colleague(Mediator mediator) {
		this.mediator = mediator;
	}

	public abstract void sendMsg(String message);

	public abstract void notifyMsg(String message);

}

class ConcreteColleague1 extends Colleague {

	public ConcreteColleague1(Mediator mediator) {
		super(mediator);
	}

	@Override
	public void sendMsg(String message) {
		mediator.send(message, this);
	}

	@Override
	public void notifyMsg(String message) {
		System.out.println("同事1得到消息：" + message);
	}

}

class ConcreteColleague2 extends Colleague {

	public ConcreteColleague2(Mediator mediator) {
		super(mediator);
	}

	@Override
	public void sendMsg(String message) {
		mediator.send(message, this);
	}

	@Override
	public void notifyMsg(String message) {
		System.out.println("同事2得到消息：" + message);
	}

}