package designpatterns.gof.behavioral.interpreter.apps;

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
public class Id implements ArithmeticExpression {

	private char ch;

	/**
	 * // jason walters, alexander urbanyak
	 * 
	 * @param ch
	 *            - must be a valid identifier
	 * @throws IllegalArgumentException
	 *             if ch is not a valid identifier
	 */
	public Id(char ch) {
		if (!LexicalAnalyzer.isValidIdentifier(ch))
			throw new IllegalArgumentException("character is not a valid identifier");
		this.ch = ch;
	}

	@Override
	public int evaluate() {
		return Memory.fetch(ch);
	}

	public char getChar() {
		return ch;
	}

}