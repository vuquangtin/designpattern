package designpatterns.gof.behavioral.interpreter.apps;

import java.util.ArrayList;

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
public class Iter {
	private ArithmeticExpression expr1;
	private ArithmeticExpression expr2;
	private ArrayList<Integer> it = new ArrayList<Integer>();;

	public Iter(ArithmeticExpression expr1, ArithmeticExpression expr2) {
		if (expr1 == null || expr2 == null)
			throw new IllegalArgumentException("null arithmetic expression argument");

		this.expr1 = expr1;
		this.expr2 = expr2;
	}

	public ArrayList<Integer> evaluate() {
		it.add(expr1.evaluate());
		it.add(expr2.evaluate());
		return it;
	}

}