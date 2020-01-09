package builders.tests;

/**
 * <h1>Builder</h1> Tách rời việc xây dựng (khởi tạo) của một đối tượng phức tạp
 * khỏi phần biểu diễn của nó sao cho cùng 1 tiến trình xây dựng (khởi tạo) có
 * thể tạo ra các biểu diễn khác nhau.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class BuilderTest {

	public static void main(String[] args) {
		Car.Builder mBuilder = new Car.Builder().setColor("green")
				.setMoney(100).setName("lanbojini").setSeat();
		Car mCar = mBuilder.build();
		System.out.println(mCar.toString());

	}
}