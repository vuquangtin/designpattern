package interpreters.expression1;

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