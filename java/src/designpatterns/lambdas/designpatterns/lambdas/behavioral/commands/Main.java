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
public class Main {
	public static void main(String[] args) {

		Editor editor = new Editor() {
			@Override
			public void save() {
				System.out.println("save");
			}

			@Override
			public void open() {
				System.out.println("open");
			}

			@Override
			public void close() {
				System.out.println("close");
			}
		};

		Macro macro = new Macro();
		macro.record(editor::open);
		macro.record(editor::save);
		macro.record(editor::close);
		macro.record(new Open(editor));
		macro.record(new Save(editor));
		macro.record(new Close(editor));
		macro.run();
	}
}

interface Action {
	public void perform();
}

class Close implements Action {
	private final Editor editor;

	public Close(Editor editor) {
		this.editor = editor;
	}

	@Override
	public void perform() {
		editor.close();
	}

}

interface Editor {
	public void save();

	public void open();

	public void close();
}

class Macro {
	private final List<Action> actions;

	public Macro() {
		actions = new ArrayList<>();
	}

	public void record(Action action) {
		actions.add(action);
	}

	public void run() {
		actions.forEach(Action::perform);
	}
}

class Open implements Action {
	private final Editor editor;

	public Open(Editor editor) {
		this.editor = editor;
	}

	@Override
	public void perform() {
		editor.open();
	}

}

class Save implements Action {
	private final Editor editor;

	public Save(Editor editor) {
		this.editor = editor;
	}

	@Override
	public void perform() {
		editor.save();
	}

}