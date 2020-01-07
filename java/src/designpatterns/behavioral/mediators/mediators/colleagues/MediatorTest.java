package mediators.colleagues;

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
public class MediatorTest {
	public static void main(String[] args) {
		MediatorImpl mediator = new MediatorImpl();

		Colleague vova = new Vova(mediator);
		Colleague stepa = new Stepa(mediator);
		Colleague pasha = new Pasha(mediator);

		mediator.addColleague(vova);
		mediator.addColleague(stepa);
		mediator.addColleague(pasha);

		vova.send("Hi Stepa! Hi Pasha!");
		System.out.println("------------");
		stepa.send("Hi all!");
		System.out.println("------------");
		pasha.send("I'm ready to talk.");
	}
}