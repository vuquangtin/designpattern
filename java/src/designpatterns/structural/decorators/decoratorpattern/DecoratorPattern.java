package decoratorpattern;

/**
 * <h1>Decorator</h1> Gán bổ sung các “trách nhiệm” (responsibility) cho một đối
 * tượng một cách linh hoạt. Các decorator cung cấp một sự lựa chọn linh động
 * cho lớp con để mở rộng tính năng
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class DecoratorPattern {

	public static void main(String[] args) {
		Computer computer = new Computer();
		computer = new Disk(computer);
		// vì disk là con của ComponentDecorator mà ComponentDecorator là con
		// của computer
		computer = new Monitor(computer);
		computer = new CD(computer);

		System.out.println("You'are getting a " + computer.description());
	}
}