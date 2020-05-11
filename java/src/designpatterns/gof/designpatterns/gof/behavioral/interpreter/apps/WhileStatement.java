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
public class WhileStatement implements Statement {
	private BooleanExpression expr;
	private Block blk;

	public WhileStatement(BooleanExpression expr, Block blk) {
		if (expr == null)
			throw new IllegalArgumentException("null boolean expression argument");
		if (blk == null)
			throw new IllegalArgumentException("null block argument");

		this.expr = expr;
		this.blk = blk;
	}

	@Override
	public void execute() {
		while (expr.evaluate())
			blk.execute();
	}

}