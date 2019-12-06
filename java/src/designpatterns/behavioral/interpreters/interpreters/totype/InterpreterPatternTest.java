package interpreters.totype;

/**
 * <h2>Design Patterns</h2> <h3>Interpreter</h3> <i>Định nghĩa 1 biểu diễn ngữ
 * pháp của 1 ngôn ngữ cụ thể, cùng với 1 thông dịch viên sử dụng biểu diễn này
 * để diễn dịch các câu trong ngôn ngữ.</i>
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class InterpreterPatternTest {

	public static void main(String args[]) {
		String firstText = "28 in Binary";
		String secondText = "28 in Hexadecimal";

		Interpreter interpreter = new Interpreter(new InterpreterContext());
		System.out.println(firstText + "= " + interpreter.interpret(firstText));
		System.out.println(secondText + "= "
				+ interpreter.interpret(secondText));

	}
}