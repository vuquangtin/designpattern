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
public class MediatorClient {
	public static void main(String[] args) {
		ConcreteMediator concreteMediator = new ConcreteMediator();

		// 让两个具体同事类认识中介者对象
		ConcreteColleague1 concreteColleague1 = new ConcreteColleague1(
				concreteMediator);
		ConcreteColleague2 concreteColleague2 = new ConcreteColleague2(
				concreteMediator);

		// 让中介者认识各个具体同事类对象
		concreteMediator.setC1(concreteColleague1);
		concreteMediator.setC2(concreteColleague2);

		// 具体同事类对象的消息发送都是通过中介者对象转发
		concreteColleague1.sendMsg("吃过饭了没有？");
		concreteColleague2.sendMsg("没有呢，你打算请客？");

	}

}