package designpatterns.gof.behavioral.mediator.inline;

import java.util.ArrayList;
import java.util.List;

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

public class MediatorDemo {
	// 客户端
	public static void main(String[] args) {
		Mediator md = new ConcreteMediator();
		Colleague c1, c2;
		c1 = new ConcreteColleagueA();
		c2 = new ConcreteColleagueB();
		md.register(c1);
		md.register(c2);
		c1.send();
		System.out.println("-------------");
		c2.send();
	}

	static abstract class Mediator {

		public abstract void register(Colleague colleague);

		public abstract void relay(Colleague colleague);
	}

	static class ConcreteMediator extends Mediator {

		private List<Colleague> colleagues = new ArrayList<>();

		@Override
		public void register(Colleague colleague) {
			colleagues.add(colleague);
			colleague.setMediator(this);
		}

		@Override
		public void relay(Colleague colleague) {
			for (Colleague obj : colleagues) {
				if (colleague.equals(obj)) {
					obj.receive();
				}
			}
		}
	}

	static abstract class Colleague {

		private Mediator mediator;

		public abstract void send();

		public abstract void receive();

		public Mediator getMediator() {
			return mediator;
		}

		public void setMediator(Mediator mediator) {
			this.mediator = mediator;
		}
	}

	static class ConcreteColleagueA extends Colleague {

		@Override
		public void send() {
			System.out.println("同事A 转交给中介处理");
			getMediator().relay(this);
		}

		@Override
		public void receive() {
			System.out.println("同事A 接收到信息");
		}
	}

	static class ConcreteColleagueB extends Colleague {

		@Override
		public void send() {
			System.out.println("同事B 转交给中介处理");
			getMediator().relay(this);
		}

		@Override
		public void receive() {
			System.out.println("同事B 接收到信息");
		}
	}
}