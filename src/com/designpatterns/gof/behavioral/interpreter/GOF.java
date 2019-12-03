package com.designpatterns.gof.behavioral.interpreter;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class GOF {
	public static void main(String[] args) {
		String sourse = "<+> 10 <+> 1 4 8 5 1 <+> 1 7 </+> 1 </+> 10 1 </+>";
		Context context = new Context(sourse);
		AbstractExpression expression = new NonterminalExpression();
		System.out.println(expression.Interpret(context));
		System.out.println(expression.toString());
	}
}

abstract class AbstractExpression {
	public abstract int Interpret(Context context);
}

class TerminalExpression extends AbstractExpression {
	private String saveToken;

	public int Interpret(Context context) {
		String token = context.getToken();
		saveToken = token;
		context.nextToken();
		return Integer.parseInt(token);
	}

	public String toString() {
		return saveToken;
	}
}

class NonterminalExpression extends AbstractExpression {
	private int resultValue;
	private String startTagPlus = "<+>";
	private String endTagPlus = "</+>";
	private List<AbstractExpression> list = new ArrayList<AbstractExpression>();

	public int Interpret(Context context) {
		AbstractExpression childExpressions;
		context.nextToken();
		String token = "";
		while (!context.isEnd()) {
			token = context.getToken();
			if (startTagPlus.equals(token)) {
				childExpressions = new NonterminalExpression();
			} else if (endTagPlus.equals(token)) {
				context.nextToken();
				break;
			} else {
				childExpressions = new TerminalExpression();
			}
			resultValue += childExpressions.Interpret(context);
			list.add(childExpressions);
		}
		return resultValue;
	}

	public String toString() {
		return "+" + list.toString();
	}
}

class Context {
	private StringTokenizer tokens;
	private String currentToken;

	public Context(String source) {
		tokens = new StringTokenizer(source);
		nextToken();
	}

	public String getToken() {
		return currentToken;
	}

	public void nextToken() {
		String token = null;
		if (!isEnd()) {
			token = tokens.nextToken();
		}
		currentToken = token;
	}

	public boolean isEnd() {
		return !tokens.hasMoreElements();
	}
}