package mediators.app.editor.components;

import java.awt.event.ActionEvent;

import javax.swing.JButton;

import mediators.app.editor.Mediator;
import mediators.app.editor.Note;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
@SuppressWarnings("serial")
public class AddButton extends JButton implements NoteComponent {

	// Concrete components don't reference each other.
	// They have only one way of communicating: sending requests to the
	// mediator.

	/**
	 * 
	 */
	private Mediator mediator;

	public AddButton() {
		super("Add");
	}

	@Override
	public void setMediator(Mediator mediator) {
		this.mediator = mediator;
	}

	@Override
	protected void fireActionPerformed(ActionEvent actionEvent) {
		mediator.addNewNote(new Note());
	}

	@Override
	public String getName() {
		return "AddButton";
	}
}