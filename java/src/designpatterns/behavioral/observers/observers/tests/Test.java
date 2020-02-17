package observers.tests;

/**
 * <h1>Observer</h1> Định nghĩa một sự phụ thuộc 1-nhiều giữa các đối tượng để
 * khi một đối tượng thay đổi trạng thái, tất cả phụ thuộc của nó được thông báo
 * và cập nhật một cách tự động.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/designpattern">https://github.com
 *      /vuquangtin/designpattern</a>
 * @see http://www.programmergirl.com/observer-design-pattern-java/
 *
 */
public class Test {
	public static void main(String[] args) {
		// in the main method
		Subject programmerGirlBlog = new Blog("ProgrammerGirl", "Shubhra");

		Observer james = new Subscriber("James");
		Observer selena = new Subscriber("Selena");

		james.subscribeTo(programmerGirlBlog);
		selena.subscribeTo(programmerGirlBlog);

		Post compositeDesignPattern = new Post("Composite Design Pattern");

		programmerGirlBlog.publish(compositeDesignPattern);
	}
}
