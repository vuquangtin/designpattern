package designpatterns.gof.behavioral.mediator.demo;

/**
 * <h1>Mediator</h1> Định nghĩa 1 đối tượng đóng gói cách 1 tập hợp các đối
 * tượng tương tác. Mediator thúc đẩy sự khớp nối lỏng lẻo bằng cách ngăn không
 * cho các đối tượng đề cập đến nhau 1 cách rõ ràng và nó cho phép bạn thay đổi
 * sự tương tác của chúng 1 cách độc lập.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/designpattern">https://github.com
 * 
 *      /vuquangtin/designpattern</a>
 *
 */

public abstract class Colleague {

	protected Mediator mediator;

	private String receivedMessage;

	public Colleague(Mediator mediator) {
		this.mediator = mediator;
	}

	abstract void notifyColleague(String message);

	abstract void receive(String message);

	protected String getReceivedMessage() {
		return this.receivedMessage;
	}

	protected void setReceivedMessage(String receivedMessage) {
		this.receivedMessage = receivedMessage;
	}
}