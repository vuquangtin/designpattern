package interpreters.expression1;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
class ThousandExpresssion extends Expression {
	public String one() {
		return "M";
	}

	public String four() {
		return " ";
	}

	public String five() {
		return " ";
	}

	public String nine() {
		return " ";
	}

	public int multiplier() {
		return 1000;
	}
}