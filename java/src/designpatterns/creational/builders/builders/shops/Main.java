package builders.shops;

import java.util.Calendar;

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
public class Main {
	public static void main(String[] args) {
		UserBuilder user = new UserBuilder.Builder().setId(1)
				.setEmail("hieupham@gmail.com").setName("Hieu Pham")
				.setBirthday(Calendar.getInstance().getTime()).setHeight(176)
				.setWeight(60).build();
		System.out.println(user.getId());
	}
}
