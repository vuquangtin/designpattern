package decorators.shapes;

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
public class DecoratorPatternDemo {
	public static void main(String[] args) {

		Shape circle = new Circle();

		Shape redCircle = new RedShapeDecorator(new Circle());

		Shape rectangle = new Rectangle();

		Shape redRectangle = new RedShapeDecorator(new Rectangle());

		System.out.println("Circle with normal border");
		circle.draw();

		System.out.println("\nCircle of red border");
		redCircle.draw();

		System.out.println("\nRectangle with normal border");
		rectangle.draw();

		System.out.println("\nRectangle of red border");
		redRectangle.draw();
	}
}
