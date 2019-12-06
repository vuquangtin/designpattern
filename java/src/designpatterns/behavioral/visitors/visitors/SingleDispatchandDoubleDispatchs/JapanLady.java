package visitors.SingleDispatchandDoubleDispatchs;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class JapanLady implements Lady {

	public void sayAishiteImasu() {
		System.out.println("aishite imasu");
	}

	@Override
	public void sayLove() {
		sayAishiteImasu();
	}
}