package designpatterns.gof.behavioral.interpreter.app2;

/**
 * <h1>Interpreter</h1> Định nghĩa 1 biểu diễn ngữ pháp của 1 ngôn ngữ cụ thể,
 * cùng với 1 thông dịch viên sử dụng biểu diễn này để diễn dịch các câu trong
 * ngôn ngữ.<br/>
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/designpattern">https://github.com
 * 
 *      /vuquangtin/designpattern</a>
 *
 */
public class BinaryExpression implements ArithmeticExpression {

	private ArithmeticExpression expr1, expr2;

	private ArithmeticOperator op;

	/**
	 * @param expr1
	 *            - cannot be null
	 * @param expr2
	 *            - cannot be null
	 * @throws IllegalArgumentException
	 *             if either argument is null
	 */
	public BinaryExpression(ArithmeticOperator op, ArithmeticExpression expr1, ArithmeticExpression expr2) {
		if (op == null)
			throw new IllegalArgumentException("null arithmetic operator argument");
		if (expr1 == null || expr2 == null)
			throw new IllegalArgumentException("null expression argument");

		this.expr1 = expr1;
		this.expr2 = expr2;
		this.op = op;
	}

	@Override
	public int evaluate() {
		int value = 0;
		switch (op) {
		case ADD_OP:
			op = ArithmeticOperator.ADD_OP;
			value = expr1.evaluate() + expr2.evaluate();
			break;
		case SUB_OP:
			op = ArithmeticOperator.SUB_OP;
			value = expr1.evaluate() - expr2.evaluate();
			break;
		case MUL_OP:
			op = ArithmeticOperator.MUL_OP;
			value = expr1.evaluate() * expr2.evaluate();
			break;
		case DIV_OP:
			op = ArithmeticOperator.DIV_OP;
			value = expr1.evaluate() / expr2.evaluate();
			break;
		case MOD_OP:
			op = ArithmeticOperator.MOD_OP;
			value = expr1.evaluate() % expr2.evaluate();
			break;
		case EXP_OP:
			op = ArithmeticOperator.EXP_OP;
			value = (int) Math.pow(expr1.evaluate(), expr2.evaluate());
			break;
		case REV_DIV_OP:
			op = ArithmeticOperator.REV_DIV_OP;
			value = expr2.evaluate() / expr1.evaluate();
			break;
		}
		return value;
	}
}