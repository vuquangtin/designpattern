package designpatterns.gof.behavioral.chainresponsibility.inline;

/**
 * <h1>Chain of Responsability</h1> Tránh sự liên kết trực tiếp giữa đối tượng
 * gửi yêu cầu và đối tượng nhận yêu cầu, khi yêu cầu có thể dc sử lý bởi hơn 1
 * đối tượng. móc nối các đối tượng nhận yêu cầu thành 1 chuỗi và gửi yêu cầu
 * theo chuỗi đó cho đến khi có đối tượng xử lý nó.
 * 
 * @see http://www.itsenka.com/contents/development/designpattern/observer.html
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
abstract class Logger {

	public static int ERR = 3;
	public static int NOTICE = 5;
	public static int DEBUG = 7;
	protected int mask;

	// The next element in the chain of responsibility
	protected Logger next;

	public Logger setNext(Logger l) {
		next = l;
		return l;
	}

	public void message(String msg, int priority) {
		if (priority <= mask) {
			writeMessage(msg);
		}
		if (next != null) {
			next.message(msg, priority);
		}
	}

	abstract protected void writeMessage(String msg);

}

class StdoutLogger extends Logger {

	public StdoutLogger(int mask) {
		this.mask = mask;
	}

	protected void writeMessage(String msg) {
		System.out.println("Writing to stdout: " + msg);
	}

}

class EmailLogger extends Logger {

	public EmailLogger(int mask) {
		this.mask = mask;
	}

	protected void writeMessage(String msg) {
		System.out.println("Sending via email: " + msg);
	}

}

class StderrLogger extends Logger {

	public StderrLogger(int mask) {
		this.mask = mask;
	}

	protected void writeMessage(String msg) {
		System.err.println("Sending to stderr: " + msg);
	}

}

public class ChainOfResponsibilityExample {

	public static void main(String[] args) {
		// Build the chain of responsibility
		Logger l, l1;
		l1 = l = new StdoutLogger(Logger.DEBUG);
		l1 = l1.setNext(new EmailLogger(Logger.NOTICE));
		l1 = l1.setNext(new StderrLogger(Logger.ERR));

		// Handled by StdoutLogger
		l.message("Entering function y.", Logger.DEBUG);

		// Handled by StdoutLogger and EmailLogger
		l.message("Step1 completed.", Logger.NOTICE);

		// Handled by all three loggers
		l.message("An error has occurred.", Logger.ERR);
	}

}