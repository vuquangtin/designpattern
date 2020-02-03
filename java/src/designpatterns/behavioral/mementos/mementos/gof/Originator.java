package mementos.gof;

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
public class Originator {

	private String state;

	public void setState(String state) {
		this.state = state;
	}

	public Memento saveToMemento() {
		return new Memento(state);
	}

	public void restoreFromMemento(Memento memento) {
		state = memento.getSavedState();
	}

	public String toString() {
		return state;
	}
}