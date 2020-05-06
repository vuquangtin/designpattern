package designpatterns.gof.behavioral.interpreter.demo;

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
public abstract class SignExpression implements Expression {
	protected Expression leftExpression;
	protected Expression rightExpression;
	protected String expressionFormat;

	public SignExpression(Expression leftExpression, Expression rightExpression) {
		this.leftExpression = leftExpression;
		this.rightExpression = rightExpression;
	}

	@Override
	public String getExpression(CalcContext context) {
		return String.format(expressionFormat, leftExpression.interpret(context), rightExpression.interpret(context),
				interpret(context));
	}
}