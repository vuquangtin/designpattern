package designpatterns.gof.behavioral.mediator.demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
public class ConcreteMediator implements Mediator {

	private List<Colleague> colleagues;

	public ConcreteMediator() {
		colleagues = new ArrayList<Colleague>();
	}

	public void addColleague(Colleague colleague) {
		colleagues.add(colleague);
	}

	public void notifyColleague(Colleague colleague, String message) {

		for (Iterator iterator = colleagues.iterator(); iterator.hasNext();) {
			Colleague receiverColleague = (Colleague) iterator.next();

			if (colleague != receiverColleague) {
				receiverColleague.receive(message);
			}
		}
	}
}