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
public abstract class Mediator {

	public abstract void send(String message, Colleague colleague);

}

class ConcreteMediator extends Mediator {
	// 需要了解所有的具体同事对象
	private ConcreteColleague1 c1;
	private ConcreteColleague2 c2;

	public ConcreteColleague1 getC1() {
		return c1;
	}

	public void setC1(ConcreteColleague1 c1) {
		this.c1 = c1;
	}

	public ConcreteColleague2 getC2() {
		return c2;
	}

	public void setC2(ConcreteColleague2 c2) {
		this.c2 = c2;
	}

	@Override
	public void send(String message, Colleague colleague) {
		// 重写发送信息的方法，根据对象做出选择判断，通知对象
		if (colleague == c1) {
			c2.notifyMsg(message);
		} else {
			c1.notifyMsg(message);
		}
	}

}