package interpreters.totype;
/**
 * <h1>Interpreter</h1> Định nghĩa 1 biểu diễn ngữ pháp của 1 ngôn ngữ cụ thể,
 * cùng với 1 thông dịch viên sử dụng biểu diễn này để diễn dịch các câu trong
 * ngôn ngữ.<br/>
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com

 *      /vuquangtin/designpattern</a>
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