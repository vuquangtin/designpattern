package designpatterns.lambdas.behavioral.commands;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>Command</h1> Đóng gói một yêu cầu request như một đối tượng, bằng cách đó
 * cho phép bạn tham số hóa các client với các request khác nhau, các queue và
 * log request, và hỗ trợ các hoạt động (operation) có thể “undo”.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class CommandGof {
	interface Command {
		void run();
	}

	public static class Logger implements Command {
		public final String message;

		public Logger(String message) {
			this.message = message;
		}

		@Override
		public void run() {
			System.out.println("Logging: " + message);
		}
	}

	public static class FileSaver implements Command {
		public final String message;

		public FileSaver(String message) {
			this.message = message;
		}

		@Override
		public void run() {
			System.out.println("Saving: " + message);
		}
	}

	public static class Mailer implements Command {
		public final String message;

		public Mailer(String message) {
			this.message = message;
		}

		@Override
		public void run() {
			System.out.println("Sending: " + message);
		}
	}

	public static class Executor {
		public void execute(List<Command> tasks) {
			for (Command task : tasks) {
				task.run();
			}
		}
	}

	public static void main(String[] args) {
		List<Command> tasks = new ArrayList<>();
		tasks.add(new Logger("Hi"));
		tasks.add(new FileSaver("Cheers"));
		tasks.add(new Mailer("Bye"));

		new Executor().execute(tasks);
	}
}