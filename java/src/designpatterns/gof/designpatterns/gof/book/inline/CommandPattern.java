package designpatterns.gof.book.inline;

import java.util.List;

import com.google.common.collect.Lists;

import designpatterns.gof.book.inline.DesignPatternContants.Pattern;
import designpatterns.gof.book.inline.RandomUtils.IdPattern;

/**
 * <h1>Command</h1> Đóng gói một yêu cầu request như một đối tượng, bằng cách đó
 * cho phép bạn tham số hóa các client với các request khác nhau, các queue và
 * log request, và hỗ trợ các hoạt động (operation) có thể “undo”.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com

 *      /vuquangtin/designpattern</a>
 *
 */

@DesignPattern(value = Pattern.Command, description = "命令")
public class CommandPattern implements DesignPatternClient {

	private class Application {
		private List<Menu> menus = Lists.newArrayList();

		private List<Document> documents = Lists.newArrayList();

		public void add(Menu menu) {
			menus.add(menu);
		}

		public void add(Document document) {
			documents.add(document);
		}

	}

	private class Menu {
		private List<MenuItem> menuItems = Lists.newArrayList();

		public void add(MenuItem menuItem) {
			menuItems.add(menuItem);
		}
	}

	/** 接受命令调用的类(Invoker) */
	private class MenuItem {
		/** 命令对象 */
		private Command command;

		public void click() {
			command.execute();
		}

		public void setCommand(Command command) {
			this.command = command;
		}
	}

	/** 命令的接收者(Receiver): 文档 */
	private class Document {
		private String fileName;

		public Document(String fileName) {
			this.fileName = fileName;
		}

		public void open() {
			System.out.println("open");
		}

		public void close() {
			System.out.println("close " + fileName);
		}

		public void cut() {
			System.out.println("cut");
		}

		public void copy() {
			System.out.println("copy");
		}

		public void paste() {
			System.out.println("paste");
		}

	}

	/** 命令抽象：封装请求 */
	private abstract class Command {
		public abstract void execute();
	}

	/** 具体命令：粘贴文档 */
	private class PasteCommand extends Command {
		/** 请求的接收者 */
		private Document document;

		public PasteCommand(Document document) {
			this.document = document;
		}

		@Override
		public void execute() {
			// 调用领域相关对象方法
			document.paste();
		}
	}

	/** 具体命令：打开文档 */
	private class OpenCommand extends Command {

		/** 请求的接收者 */
		private Application application;

		public OpenCommand(Application application) {
			this.application = application;
		}

		@Override
		public void execute() {
			String fileName = RandomUtils.nextId(IdPattern.UpperCase) + ".txt";

			Document document = new Document(fileName);
			application.add(document);

			document.open();
		}
	}

	private class CenterDocumentCommand extends Command {
		@Override
		public void execute() {
			System.out.println("CenterDocument");
		}
	}

	private class NormalSizeCommand extends Command {
		@Override
		public void execute() {
			System.out.println("NormalSize");
		}
	}

	/** 宏命令：聚合了多个命令 */
	private class MarcoCommand extends Command {
		/** 聚合的命令 */
		private List<Command> commands = Lists.newArrayList();

		@Override
		public void execute() {
			// 依次调用聚合的命令
			for (Command command : commands) {
				command.execute();
			}
		}

		public void add(Command command) {
			commands.add(command);
		}

	}

	@Override
	public void usage() {
		// 应用的布局
		Application application = new Application();
		Menu menu = new Menu();
		MenuItem pasteMenuItem = new MenuItem();
		MenuItem openMenuItem = new MenuItem();
		menu.add(pasteMenuItem);
		menu.add(openMenuItem);
		application.add(menu);

		// 添加处理命令
		Document document = new Document(
				RandomUtils.nextId(IdPattern.UpperCase) + ".txt");
		application.add(document);
		Command command = new PasteCommand(document);
		pasteMenuItem.setCommand(command);
		Command openCommand = new OpenCommand(application);
		openMenuItem.setCommand(openCommand);

		// 调用命令
		pasteMenuItem.click();
		System.out.println();
		openMenuItem.click();
		System.out.println();

		// 使用复合命令
		MarcoCommand marcoCommand = new MarcoCommand();
		marcoCommand.add(new CenterDocumentCommand());
		marcoCommand.add(new NormalSizeCommand());
		MenuItem marcoMenuItem = new MenuItem();
		marcoMenuItem.setCommand(marcoCommand);
		marcoMenuItem.click();

		System.out.println();
		document.cut();
		document.copy();
		document.close();
	}

	public static void main(String[] args) {
		new CommandPattern().usage();
	}

}