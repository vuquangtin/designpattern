package designpatterns.gof.behavioral.interpreter.inline;

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
class Context {

}

abstract class AbstractExpression {
	public abstract void Interpret(Context context);
}

class TerminalExpression extends AbstractExpression {

	@Override
	public void Interpret(Context context) {
		// TODO Auto-generated method stub
		System.out.println("called by TerminalExpression");
	}

}

class NonterminalExpression extends AbstractExpression {

	@Override
	public void Interpret(Context context) {
		// TODO Auto-generated method stub
		System.out.println("called by NonterminalExpression");
	}

}

public class InterpreterGOF {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Context context = new Context();

		// Usually a tree
		ArrayList list1 = new ArrayList();

		// Populate 'abstract syntax tree'
		list1.add(new TerminalExpression());
		list1.add(new NonterminalExpression());
		list1.add(new TerminalExpression());
		list1.add(new TerminalExpression());

		for (int i = 0; i < list1.size(); i++) {
			((AbstractExpression) list1.get(i)).Interpret(context);
		}

	}

}