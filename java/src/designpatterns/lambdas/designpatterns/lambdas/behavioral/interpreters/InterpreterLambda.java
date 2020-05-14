package designpatterns.lambdas.behavioral.interpreters;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.IntBinaryOperator;

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
public class InterpreterLambda {
	static Map<String, IntBinaryOperator> opMap = new HashMap<>();

	static {
		opMap.put("+", (a, b) -> a + b);
		opMap.put("*", (a, b) -> a * b);
		opMap.put("-", (a, b) -> a - b);
	}

	public static int evaluate(String expression) {
		Stack<Integer> stack = new Stack<>();
		for (String s : expression.split(" ")) {
			IntBinaryOperator op = opMap.get(s);
			if (op != null) {
				int right = stack.pop();
				int left = stack.pop();
				stack.push(op.applyAsInt(left, right));
			} else {
				stack.push(Integer.parseInt(s));
			}
		}
		return stack.pop();
	}

	public static void main(String[] args) {
		String expression = "7 3 - 2 1 + *";
		System.out.println(evaluate(expression));
	}

}