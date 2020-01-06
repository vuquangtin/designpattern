package commands.gof1;

import java.util.Iterator;
import java.util.Stack;

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
public class Client {
	public static void main(String[] args) {
		Command[] commandsA = new Command[5];
		Command[] commandsB = new Command[5];
		Receiver receiver = new ConcreteReceiver();
		Invoker invoker = new Invoker();
		for (int i = 0; i < commandsA.length; i++) {
			commandsA[i] = new ConcreteCommandA(i);
			commandsA[i].setReceiver(receiver);
			invoker.addCommnad(commandsA[i]);
		}
		for (int i = 0; i < commandsB.length; i++) {
			commandsB[i] = new ConcreteCommandB(i);
			commandsB[i].setReceiver(receiver);
			invoker.addCommnad(commandsB[i]);
		}
		invoker.execute();
		invoker.undoCommnad();
		invoker.execute();
	}
}

abstract class Command {
	public void setReceiver(Receiver receiver) {
	}

	public abstract void execute();
}

class ConcreteCommandA extends Command {
	private int id;
	protected Receiver receiver;
	private final String name = "A";

	public ConcreteCommandA(int id) {
		this.id = id;
	}

	public void setReceiver(Receiver receiver) {
		this.receiver = receiver;
	}

	public void execute() {
		receiver.action(name + ":" + id);
	}
}

class ConcreteCommandB extends Command {
	private int id;
	protected Receiver receiver;
	private final String name = "B";

	public ConcreteCommandB(int id) {
		this.id = id;
	}

	public void setReceiver(Receiver receiver) {
		this.receiver = receiver;
	}

	public void execute() {
		receiver.action(name + ":" + id);
	}
}

interface Receiver {
	public abstract void action(String msg);
}

class ConcreteReceiver implements Receiver {
	public void action(String msg) {
		System.out.println(msg);
	}
}

class Invoker {
	private Stack<Command> commands = new Stack<Command>();

	public void addCommnad(Command command) {
		commands.push(command);
	}

	public void undoCommnad() {
		Command command = (Command) commands.pop();
		System.out.println();
		System.out.println("undo - 削除された命令 ↓");
		command.execute();
		System.out.println("undo - 削除された命令 ↑");
		System.out.println();
	}

	public void execute() {
		Iterator<Command> it = commands.iterator();
		while (it.hasNext()) {
			it.next().execute();
		}
	}
}