package totype;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
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