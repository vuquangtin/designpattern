package builders.pizza;

import java.util.ArrayList;

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
public class PizzaMargheritaBuilder extends PizzaBuilder {

	public PizzaMargheritaBuilder() {
		this.name = "margherita";
		this.ingredients = new ArrayList<String>() {
			private static final long serialVersionUID = 1L;

			{
				add("pomodoro");
				add("mozzarella");
			}
		};
	}
}