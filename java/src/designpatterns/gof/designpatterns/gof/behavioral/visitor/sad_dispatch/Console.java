package designpatterns.gof.behavioral.visitor.sad_dispatch;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class Console {
	public static void WriteLine(String txt) {
		System.out.println(txt);
	}

	public static void WriteLine() {
		System.out.println();
	}

	public static void ReadLine() {
		System.out.println();
	}
}
