package designpatterns.gof.behavioral.interpreter.inline;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Assert;
import org.junit.Test;

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
public class InterpreterTest {

	@Test
	public void test() {
		Arithmetic arithmetic = new Arithmetic();
		Assert.assertEquals(9.0D, arithmetic.arithmetic("2 / 1 + 3 * 4 - 5"), 0.0001);
		Assert.assertEquals(0.6D, arithmetic.arithmetic("1 + 2 - 3 * 4 / 5"), 0.0001);
		Assert.assertEquals(0.6D, arithmetic.arithmetic("1 + 2 - (1 + 2) * (2 * 2) / 5"), 0.0001);
		Assert.assertEquals(17.0D, arithmetic.arithmetic("1 + (1 + 2 * (20 / 4 - 2) - 2) * 3 + 1"), 0.0001);
	}

}

class Arithmetic {

	private static Pattern plusPattern = Pattern.compile("([^\\+]+)\\+(.+)");
	private static Pattern minusPattern = Pattern.compile("([^\\-]+)\\-(.+)");
	private static Pattern mulPattern = Pattern.compile("([^\\*]+)\\*(.+)");
	private static Pattern subPattern = Pattern.compile("([^/]+)/(.+)");
	private static Pattern bracketPattern = Pattern.compile("(.+)\\(([^\\(\\)]+)\\)(.+)");

	public double arithmetic(String expression) {
		if (expression == null) {
			throw new IllegalArgumentException();
		}
		expression = expression.replaceAll("\\s", "");
		return interpreter(expression).interpreter();
	}

	public Expression interpreter(String expression) {
		Matcher matcher = null;
		if ((matcher = bracketPattern.matcher(expression)).find()) {
			return interpreter(matcher.group(1) + interpreter(matcher.group(2)).interpreter() + matcher.group(3));
		} else if ((matcher = plusPattern.matcher(expression)).find()) {
			return new PlusExpression(interpreter(matcher.group(1)), interpreter(matcher.group(2)));
		} else if ((matcher = minusPattern.matcher(expression)).find()) {
			return new MinusExpression(interpreter(matcher.group(1)), interpreter(matcher.group(2)));
		} else if ((matcher = mulPattern.matcher(expression)).find()) {
			return new MulExpression(interpreter(matcher.group(1)), interpreter(matcher.group(2)));
		} else if ((matcher = subPattern.matcher(expression)).find()) {
			return new SubExpression(interpreter(matcher.group(1)), interpreter(matcher.group(2)));
		}
		return new ValueExpression(NumberUtils.toDouble(expression, 0.0));
	}

}

abstract class DoubleExpression implements Expression {

	protected Expression left;
	protected Expression right;

	public DoubleExpression(Expression left, Expression right) {
		this.left = left;
		this.right = right;
	}

}

interface Expression {

	public double interpreter();

}

class MinusExpression extends DoubleExpression {

	public MinusExpression(Expression left, Expression right) {
		super(left, right);
	}

	@Override
	public double interpreter() {
		return left.interpreter() - right.interpreter();
	}

}

class MulExpression extends DoubleExpression {

	public MulExpression(Expression left, Expression right) {
		super(left, right);
	}

	@Override
	public double interpreter() {
		return left.interpreter() * right.interpreter();
	}

}

class PlusExpression extends DoubleExpression {

	public PlusExpression(Expression left, Expression right) {
		super(left, right);
	}

	@Override
	public double interpreter() {
		return left.interpreter() + right.interpreter();
	}

}

class SubExpression extends DoubleExpression {

	public SubExpression(Expression left, Expression right) {
		super(left, right);
	}

	@Override
	public double interpreter() {
		return left.interpreter() / right.interpreter();
	}

}

class ValueExpression implements Expression {

	private double value;

	public ValueExpression(double value) {
		this.value = value;
	}

	@Override
	public double interpreter() {
		return value;
	}

}