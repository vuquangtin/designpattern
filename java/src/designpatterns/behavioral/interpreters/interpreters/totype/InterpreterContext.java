package interpreters.totype;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class InterpreterContext {

	public String getBinaryFormat(int integer) {
		return Integer.toBinaryString(integer);
	}

	public String getHexadecimalFormat(int integer) {
		return Integer.toHexString(integer);
	}
}