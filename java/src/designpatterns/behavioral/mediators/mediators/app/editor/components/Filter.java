package mediators.app.editor.components;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JTextField;
import javax.swing.ListModel;

import mediators.app.editor.Mediator;
import mediators.app.editor.Note;

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
public class Filter extends JTextField implements NoteComponent {

	// Concrete components don't reference each other.
	// They have only one way of communicating: sending requests to the
	// mediator.

	private Mediator mediator;
	private ListModel listModel;

	public Filter() {
	}

	@Override
	public void setMediator(Mediator mediator) {
		this.mediator = mediator;
	}

	@Override
	protected void processComponentKeyEvent(KeyEvent keyEvent) {
		String start = getText();
		searchElements(start);
	}

	public void setList(ListModel listModel) {
		this.listModel = listModel;
	}

	private void searchElements(String s) {
		if (listModel == null) {
			return;
		}

		if (s.equals("")) {
			mediator.setElementsList(listModel);
			return;
		}

		ArrayList<Note> notes = new ArrayList<>();
		for (int i = 0; i < listModel.getSize(); i++) {
			notes.add((Note) listModel.getElementAt(i));
		}
		DefaultListModel<Note> listModel = new DefaultListModel<>();
		for (Note note : notes) {
			if (note.getName().contains(s)) {
				listModel.addElement(note);
			}
		}
		mediator.setElementsList(listModel);
	}

	@Override
	public String getName() {
		return "Filter";
	}
}