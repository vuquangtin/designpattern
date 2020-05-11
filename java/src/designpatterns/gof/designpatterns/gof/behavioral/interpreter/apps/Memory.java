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
public class Memory {

	private static int[] mem = new int[52];

	/**
	 * @param ch
	 *            - must be a valid identifier
	 * @return value of ch
	 * @throws IllegalArgumentException
	 *             if ch is not a valid identifier
	 */
	public static int fetch(char ch) {
		return mem[getIndex(ch)];
	}

	/**
	 * @param ch
	 *            - must be a valid identifier
	 * @param value
	 * @throws IllegalArgumentException
	 *             if ch is not a valid identifier
	 */
	public static void store(char ch, int value) {
		mem[getIndex(ch)] = value;
	}

	private static int getIndex(char ch) {
		if (!LexicalAnalyzer.isValidIdentifier(ch))
			throw new IllegalArgumentException(ch + " is not a valid identifier");
		if (ch - 'A' < 26)
			return ch - 'A';
		else
			return (ch - 'a') + 26;
	}

	public static void displayMemory() {
		for (int i = 0; i < 26; i++)
			System.out.println((char) ('A' + i) + ": " + mem[i]);
		for (int i = 0; i < 26; i++)
			System.out.println((char) ('a' + i) + ": " + mem[i + 26]);
	}
}