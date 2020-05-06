package designpatterns.gof.behavioral.interpreter.demo;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
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
public class ClientTest {

	private CalcContext context;

	@Before
	public void setUp() throws Exception {
		context = new CalcContext();
	}

	@Test
	public void should_return_integer_expression_correct() {
		Expression expression = new IntegerExpression();
		context.assign(expression, 1);
		int result = expression.interpret(context);
		assertThat(result, is(1));
		assertThat(expression.getExpression(context), is("1"));
	}

	@Test
	public void should_return_add_expression_result_correct() {
		Expression leftExpression = new IntegerExpression();
		Expression rightExpression = new IntegerExpression();

		context.assign(leftExpression, 1);
		context.assign(rightExpression, 2);

		Expression expression = new AddExpression(leftExpression, rightExpression);
		int result = expression.interpret(context);
		assertThat(result, is(3));
		assertThat(expression.getExpression(context), is("1+2=3"));
	}

	@Test
	public void should_return_sub_expression_result_correct() {
		Expression leftExpression = new IntegerExpression();
		Expression rightExpression = new IntegerExpression();

		context.assign(leftExpression, 4);
		context.assign(rightExpression, 2);

		Expression expression = new SubExpression(leftExpression, rightExpression);
		int result = expression.interpret(context);
		assertThat(result, is(2));
		assertThat(expression.getExpression(context), is("4-2=2"));
	}

	@Test
	public void should_return_composite_expression_result_correct() {
		Expression expression1 = new IntegerExpression();
		Expression expression2 = new IntegerExpression();
		context.assign(expression1, 2);
		context.assign(expression2, 3);

		Expression expression3 = new AddExpression(expression1, expression2);

		Expression expression4 = new IntegerExpression();
		Expression expression5 = new IntegerExpression();
		context.assign(expression4, 6);
		context.assign(expression5, 3);

		Expression expression6 = new SubExpression(expression4, expression5);

		Expression expression7 = new AddExpression(expression3, expression6);
		int result = expression7.interpret(context);
		assertThat(result, is(8));
		assertThat(expression7.getExpression(context), is("5+3=8"));
	}

}