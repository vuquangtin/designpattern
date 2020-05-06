package designpatterns.gof.behavioral.interpreter.demo2;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.StringTokenizer;

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
public class Parser {
	private String expression;
	private String token;
	private List result;
	private String interpreted;

	public Parser(String e, String t) {
		expression = e;
		token = t;
	}

	public void myParser() {
		StringTokenizer holder = new StringTokenizer(expression, token);
		String[] toBeMatched = new String[holder.countTokens()];
		int idx = 0;
		while (holder.hasMoreTokens()) {
			String item = holder.nextToken();
			int start = item.indexOf(",");
			if (start == 0) {
				item = item.substring(2);
			}
			toBeMatched[idx] = item;
			idx++;
		}
		result = Arrays.asList(toBeMatched);
	}

	public List getParseResult() {
		return result;
	}

	public void interpret() {
		StringBuffer buffer = new StringBuffer();
		ListIterator list = result.listIterator();
		while (list.hasNext()) {
			String token = (String) list.next();
			if (token.equals("SFO")) {
				token = "San Francisco";
			} else if (token.equals("CA")) {
				token = "Canada";
			}
			// ...
			buffer.append(" " + token);
		}
		interpreted = buffer.toString();
	}

	public String getInterpretedResult() {
		return interpreted;
	}

	public static void main(String[] args) {
		String source = "dest='SFO',origin='CA',day='MON'";
		String delimiter = "=,'";
		Parser parser = new Parser(source, delimiter);
		parser.myParser();
		parser.interpret();
		String result = parser.getInterpretedResult();
		System.out.println(result);
	}
}