package delegation_and_inheritance;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class Tester {
	// To the outside world it looks like Printer actually prints.
	public static void main(String[] args) {
		Printer printer = new Printer();
		printer.print();
	}
}