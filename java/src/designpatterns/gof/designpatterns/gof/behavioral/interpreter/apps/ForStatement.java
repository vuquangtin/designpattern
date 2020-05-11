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
public class ForStatement implements Statement {
	private Id var;
	private Iter it;
	private Block blk;

	public ForStatement(Id var, Iter it, Block blk) {
		if (var == null)
			throw new IllegalArgumentException("null Id argument");
		if (it == null) // jww
			throw new IllegalArgumentException("null iterator argument");
		if (blk == null)
			throw new IllegalArgumentException("null block argument");

		this.var = var;
		this.it = it;
		this.blk = blk;
	}

	@Override
	public void execute() {
		if (it.evaluate().get(0) < it.evaluate().get(1)) {
			Memory.store(var.getChar(), it.evaluate().get(0));
			while (Memory.fetch(var.getChar()) <= it.evaluate().get(1)) {
				blk.execute();
				int i = Memory.fetch(var.getChar());
				i++;
				Memory.store(var.getChar(), i);
			}
		} else {
			Memory.store(var.getChar(), it.evaluate().get(0));
			while (Memory.fetch(var.getChar()) >= it.evaluate().get(1)) {
				blk.execute();
				int i = Memory.fetch(var.getChar());
				i--;
				Memory.store(var.getChar(), i);
			}
		}
	}
}