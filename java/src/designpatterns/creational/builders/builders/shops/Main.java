package builders.shops;

import java.util.Calendar;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class Main {
	public static void main(String[] args) {
		UserBuilder user = new UserBuilder.Builder().setId(1).setEmail("hieupham@gmail.com")
				.setName("Hieu Pham")
				.setBirthday(Calendar.getInstance().getTime()).setHeight(176)
				.setWeight(60).build();
		System.out.println(user.getId());
	}
}
