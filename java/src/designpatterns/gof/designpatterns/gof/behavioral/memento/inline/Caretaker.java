package designpatterns.gof.behavioral.memento.inline;

import java.util.Stack;

/**
 * <h1>Memento</h1> Không vi phạm tính đóng gói, nó nắm bắt và hiệu chỉnh trạng
 * thái bên trong của đối tượng để đối tượng có thể được khôi phục về trạng thái
 * này sau đó.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com

 *      /vuquangtin/designpattern</a>
 *
 */
class Originator {
	private String state;

	// The class could also contain additional data that is not part of the
	// state saved in the memento.
	public void set(String state) {
		System.out.println("Originator: Setting state to " + state);
		this.state = state;
	}

	public IMemento saveToMemento() {
		System.out.println("Originator: Saving to Memento.");
		return new Memento(state);
	}

	public void restoreFromMemento(IMemento memento) {
		state = ((Memento) memento).getSavedState();
		System.out.println("Originator: State after restoring from Memento: "
				+ state);
	}

	// private INNER CLASS
	private static class Memento implements IMemento {
		private final String state;

		private Memento(String stateToSave) {
			state = stateToSave;
		}

		private String getSavedState() {
			return state;
		}
	}
}

public class Caretaker {
	public static void main(String[] args) {
		Stack<IMemento> savedStates = new Stack<IMemento>();

		Originator originator = new Originator();
		originator.set("State 22");
		originator.set("State 23");
		savedStates.push(originator.saveToMemento());
		originator.set("State 33");
		originator.set("State 41");
		// We can request multiple mementos, and choose which one to roll back
		// to.
		savedStates.push(originator.saveToMemento());
		originator.set("State 43");
		originator.set("State 46");

		originator.restoreFromMemento(savedStates.pop());
	}
}

interface IMemento {

}