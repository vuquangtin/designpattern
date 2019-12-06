package adapters.numbers;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class CheckNumberAdaptee {

	public boolean checkNumber(String input) {
		String regex = "[0-9]+";
		return input.matches(regex);
	}
}