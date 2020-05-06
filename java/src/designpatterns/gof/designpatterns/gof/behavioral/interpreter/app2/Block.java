package designpatterns.gof.behavioral.interpreter.app2;

import java.util.ArrayList;
import java.util.List;

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

public class Block {
	private List<Statement> stmts;

	public Block() {

		stmts = new ArrayList<Statement>();
	}

	public void add(Statement stmt) {
		if (stmt == null)
			throw new IllegalArgumentException("null statement argument");
		stmts.add(stmt);
	}

	public void execute() {
		for (int i = 0; i < stmts.size(); i++)
			stmts.get(i).execute();
	}
}