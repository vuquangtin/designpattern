package adapters.gof.classes;

/**
 * <h1>Adapter</h1> Chuyển interface của một lớp thành interface khác mà các
 * client mong muốn. Adapter để cho các lớp làm việc với nhau dù có thể các
 * interface không tương thích.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class AdapterDemo {

	public static void main(String[] args) {
		AdapterRectangle shape = new AdapterRectangle();
		System.out.println(shape.draw());
		designPatternTest();
	}

	public static void designPatternTest() {
		Figure[] figures = new Figure[] { new Line(), new AdapterRectangle() };

		System.out.println(figures[0].draw() + "\tDraw: Line");
		System.out.println(figures[1].draw() + "\tDraw: Rectangle");
	}
}
