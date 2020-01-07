package mediators.app.editor.components;

import java.awt.event.KeyEvent;

import javax.swing.JTextArea;

import mediators.app.editor.Mediator;

/**
 * <h1>Mediator</h1> Định nghĩa 1 đối tượng đóng gói cách 1 tập hợp các đối
 * tượng tương tác. Mediator thúc đẩy sự khớp nối lỏng lẻo bằng cách ngăn không
 * cho các đối tượng đề cập đến nhau 1 cách rõ ràng và nó cho phép bạn thay đổi
 * sự tương tác của chúng 1 cách độc lập.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/designpattern">https://github.com
 *      /vuquangtin/designpattern</a>
 *
 */

@SuppressWarnings("serial")
public class TextBox extends JTextArea implements NoteComponent {

	// Concrete components don't reference each other.
	// They have only one way of communicating: sending requests to the
	// mediator.

	private Mediator mediator;

	@Override
	public void setMediator(Mediator mediator) {
		this.mediator = mediator;
	}

	@Override
	protected void processComponentKeyEvent(KeyEvent keyEvent) {
		mediator.markNote();
	}

	@Override
	public String getName() {
		return "TextBox";
	}
}