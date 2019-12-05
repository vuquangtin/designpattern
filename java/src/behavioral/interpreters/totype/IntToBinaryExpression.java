package totype;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class IntToBinaryExpression implements Expression {

	private int integer;

	public IntToBinaryExpression(int integer) {
		this.integer = integer;
	}

	@Override
	public String interpret(InterpreterContext interpreterContext) {
		return interpreterContext.getBinaryFormat(this.integer);
	}

}