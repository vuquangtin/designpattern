package waiters;

import java.util.ArrayList;

/**
 * <h2>Design Patterns</h2> <h3>Mediator</h3> <i>Định nghĩa 1 đối tượng đóng gói
 * cách 1 tập hợp các đối tượng tương tác. Mediator thúc đẩy sự khớp nối lỏng
 * lẻo bằng cách ngăn không cho các đối tượng đề cập đến nhau 1 cách rõ ràng và
 * nó cho phép bạn thay đổi sự tương tác của chúng 1 cách độc lập.</i>
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
class Mediator {
	ArrayList<Waiter> waiters = new ArrayList<>();
	ArrayList<Visitor> persons = new ArrayList<>();

	public void sayHello(String country) {
		for (int i = 0; i < waiters.size(); i++) {
			if (country.equals(waiters.get(i).country))
				waiters.get(i).say();
		}
	}

	public void addWaiter(Waiter waiter) {
		int lens = waiters.size();
		waiters.add(lens, waiter);
	}

	public void addVisitor(Visitor person) {
		int lens = persons.size();
		persons.add(lens, person);
	}

}

class Visitor {

	private Mediator mediator;
	private String contury;

	public Visitor(String contury) {
		this.contury = contury;
	}

	public void setMediator(Mediator mediator) {
		this.mediator = mediator;
	}

	public void comeIn() {
		mediator.sayHello(this.contury);
	}
}

public class Main {
	public static void main(String[] args) {
		// 中介者
		Mediator mediator = new Mediator();

		// 三个服务人员
		Waiter chinese = new ChineseWaiter();
		Waiter english = new EnglishWaiter();
		Waiter german = new GermanWaiter();

		// 两个参观者
		Visitor germanVisitor = new Visitor("german");
		Visitor chineseVisitor = new Visitor("chinese");
		Visitor englishVisitor = new Visitor("english");

		// 绑定
		// chinese.setMediator(mediator);
		// english.setMediator(mediator);
		// german.setMediator(mediator);
		germanVisitor.setMediator(mediator);
		chineseVisitor.setMediator(mediator);
		englishVisitor.setMediator(mediator);
		mediator.addVisitor(germanVisitor);
		mediator.addVisitor(chineseVisitor);
		mediator.addVisitor(englishVisitor);
		mediator.addWaiter(chinese);
		mediator.addWaiter(english);
		mediator.addWaiter(german);

		// 一个中国游览者进入
		chineseVisitor.comeIn();
		germanVisitor.comeIn();
		englishVisitor.comeIn();
	}
}