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
public class Interpreter {
	public InterpreterContext interpreterContext;

	public Interpreter(InterpreterContext interpreterContext) {
		this.interpreterContext = new InterpreterContext();
	}

	public String interpret(String text) {
		Expression expression = null;

		String stringInteger = text.substring(0, text.indexOf(" "));

		int integer = Integer.parseInt(stringInteger);

		// Create rules for expressions
		if (text.contains("Hexadecimal")) {
			expression = new IntToHexExpression(integer);
		} else if (text.contains("Binary")) {
			expression = new IntToBinaryExpression(integer);
		} else
			return text;

		return expression.interpret(interpreterContext);
	}
}