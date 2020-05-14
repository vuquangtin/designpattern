package designpatterns.lambdas.behavioral.commands;

import java.util.ArrayList;
import java.util.Arrays;
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
public class CommandLambda {

	public static void log(String message) {
		System.out.println("Logging: " + message);
	}

	public static void save(String message) {
		System.out.println("Saving: " + message);
	}

	public static void send(String message) {
		System.out.println("Sending: " + message);
	}

	public static void execute(List<Runnable> tasks) {
		tasks.forEach(Runnable::run);
	}

	public static void execute(Runnable... tasks) {
		Arrays.stream(tasks).forEach(Runnable::run);
	}

	public static void main(String[] args) {
		List<Runnable> tasks = new ArrayList<>();
		tasks.add(() -> log("Hi"));
		tasks.add(() -> save("Cheers"));
		tasks.add(() -> send("Bye"));

		execute(tasks);

		// or

		execute(() -> log("What up?"), () -> save("Cheers"),
				() -> send("Later"));
	}
}