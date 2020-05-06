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
public class AssignmentStatement implements Statement {

	private ArithmeticExpression expr;

	private Id var;

	/**
	 * @param var
	 *            - cannot be null
	 * @param expr
	 *            - cannot be null
	 * @throws IllegalArgumentException
	 *             if either argument is null
	 */
	public AssignmentStatement(Id var, ArithmeticExpression expr) {
		if (var == null)
			throw new IllegalArgumentException("null Id argument");
		if (expr == null)
			throw new IllegalArgumentException("null ArithmeticExpression argument");
		this.expr = expr;
		this.var = var;
	}

	public void execute() {
		Memory.store(var.getChar(), expr.evaluate());
	}

}