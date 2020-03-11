package commands.docs;

import java.util.Stack;

/**
 * <h1>Command</h1> Đóng gói một yêu cầu request như một đối tượng, bằng cách đó
 * cho phép bạn tham số hóa các client với các request khác nhau, các queue và
 * log request, và hỗ trợ các hoạt động (operation) có thể “undo”.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/designpattern">https://github.com
 *      /vuquangtin/designpattern</a>
 *
 */

public class Document {
	private Stack<String> lines = new Stack<>();

	public void write(String text) {
		lines.push(text);
	}

	public void eraseLast() {
		if (!lines.isEmpty()) {
			lines.pop();
		}
	}

	public void readDocument() {
		for (String line : lines) {
			System.out.println(line);
		}
	}
}