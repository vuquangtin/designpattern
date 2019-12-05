package totype;
/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class IntToHexExpression implements Expression {

	private int integer;

	public IntToHexExpression(int integer) {
		this.integer = integer;
	}

	@Override
	public String interpret(InterpreterContext interpreterContext) {
		return interpreterContext.getHexadecimalFormat(integer);
	}

}