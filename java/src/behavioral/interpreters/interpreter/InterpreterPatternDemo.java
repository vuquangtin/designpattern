package interpreter;

/**
 * <h2>Design Patterns</h2> <h3>Interpreter</h3> <i>Định nghĩa 1 biểu diễn ngữ
 * pháp của 1 ngôn ngữ cụ thể, cùng với 1 thông dịch viên sử dụng biểu diễn này
 * để diễn dịch các câu trong ngôn ngữ.</i>
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class InterpreterPatternDemo {

	// Rule: Robert and John are male
	public static Expression getMaleExpression() {
		Expression robert = new TerminalExpression("Robert");
		Expression john = new TerminalExpression("John");
		return new OrExpression(robert, john);
	}

	// Rule: Julie is a married woman
	public static Expression getMarriedWomanExpression() {
		Expression julie = new TerminalExpression("Julie");
		Expression married = new TerminalExpression("Married");
		return new AndExpression(julie, married);
	}

	// Rule: Emma is a single woman
	public static Expression getSingleWomanExpression() {
		Expression emma = new TerminalExpression("Emma");
		Expression single = new TerminalExpression("Single");
		return new AndExpression(emma, single);
	}

	public static void main(String[] args) {
		Expression isMale = getMaleExpression();
		Expression isMarriedWoman = getMarriedWomanExpression();
		Expression isSingleWoman = getSingleWomanExpression();

		System.out.println("John is male? " + isMale.interpret("John"));
		System.out.println("Robert is male? " + isMale.interpret("Robert"));
		System.out.println("Lily is male? " + isMale.interpret("Lily"));
		System.out.println("Julie is a married woman? "
				+ isMarriedWoman.interpret("Married Julie"));
		System.out.println("Emma is a married woman? "
				+ isMarriedWoman.interpret("Single Emma"));
		System.out.println("Emma is a single woman? "
				+ isSingleWoman.interpret("Single Emma"));
		System.out.println("Emma is a single woman? "
				+ isSingleWoman.interpret("Emma Single"));
	}
}
