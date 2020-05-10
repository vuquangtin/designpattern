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
 * @see http://www.design-patterns-stories.com/patterns/Mediator/
 */
public class MediatorClient {

	public static void main(String[] args) {

		ConcreteMediator mediator = new ConcreteMediator();

		Colleague colleague1 = new ConcreteColleague1(mediator);
		Colleague colleague2 = new ConcreteColleague2(mediator);

		mediator.addColleague(colleague1);
		mediator.addColleague(colleague2);

		colleague1.notifyColleague("Hello from ConcreteColleague1");
		colleague2.notifyColleague("Hello from ConcreteColleague2");

		System.out.println("Hello from ConcreteColleague2==" + ((ConcreteColleague1) colleague1).getReceivedMessage());
		System.out.println("Hello from ConcreteColleague1==" + ((ConcreteColleague2) colleague2).getReceivedMessage());
	}
}