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
public class IfStatement implements Statement {
	// jason walters, alexander urbanyak
	private BooleanExpression expr;
	private Block blk1, blk2;

	public IfStatement(BooleanExpression expr, Block blk1, Block blk2) {
		if (expr == null)
			throw new IllegalArgumentException("null boolean expression argument");
		if (blk1 == null || blk2 == null)
			throw new IllegalArgumentException("null block argument");

		this.expr = expr;
		this.blk1 = blk1;
		this.blk2 = blk2;
	}

	@Override
	public void execute() {
		if (expr.evaluate())
			blk1.execute();
		else
			blk2.execute();
	}
}