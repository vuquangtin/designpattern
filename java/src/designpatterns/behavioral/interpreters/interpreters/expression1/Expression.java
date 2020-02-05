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
public abstract class Expression {
	public void interpreter(Context context) {
		if (context.input.length() == 0)
			return;
		if (context.input.startsWith(nine())) {
			context.output += 9 * multiplier();
			context.input = context.input.substring(2);
		}
		if (context.input.startsWith(four())) {
			context.output += 4 * multiplier();
			context.input = context.input.substring(2);
		}
		if (context.input.startsWith(one())) {
			context.output += 1 * multiplier();
			context.input = context.input.substring(1);
		}

		if (context.input.startsWith(five())) {
			context.output += 5 * multiplier();
			context.input = context.input.substring(1);
		}
	}

	abstract public String one();

	abstract public String four();

	abstract public String five();

	abstract public String nine();

	abstract public int multiplier();
}
