package designpatterns.gof.behavioral.memento.demo;

/**
 * <h1>Memento</h1> Không vi phạm tính đóng gói, nó nắm bắt và hiệu chỉnh trạng
 * thái bên trong của đối tượng để đối tượng có thể được khôi phục về trạng thái
 * này sau đó.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/designpattern">https://github.com
 * 
 *      /vuquangtin/designpattern</a>
 *
 */
public class Client {
	public static void main(String[] args) {
		// init state of the Originator
		Originator originator = new Originator();
		originator.setState(1);
		// 1
		System.out.println(originator.getState());

		// Caretaker stores current state of the Originator
		Caretaker caretaker = new Caretaker();
		caretaker.setMemento(originator.createMemento());

		// change a Originator's state
		originator.setState(2);
		// 2
		System.out.println(originator.getState());

		// undo Originator's initial state
		originator.setMemento(caretaker.getMemento());
		// 1
		System.out.println(originator.getState());
	}
}

/**
 * 
 * Memento stores internal state of the Originator object, protects against
 * access by objects other than the Originator.
 *
 */
class Memento {

	private int state;

	public Memento(int state) {
		this.state = state;
	}

	public int getState() {
		return state;
	}
}

/**
 * 
 * Originator creates a Memento containing a snapshot of its current internal
 * state. Originator use Memento to restore its internal state.
 * 
 */
class Originator {

	private int state;

	public void setMemento(Memento memento) {
		this.state = memento.getState();
	}

	public Memento createMemento() {
		return new Memento(this.state);
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

}

/**
 * 
 * Caretaker responsible for the Memento's safekeeping.
 *
 */
class Caretaker {

	private Memento memento;

	public Memento getMemento() {
		return memento;
	}

	public void setMemento(Memento memento) {
		this.memento = memento;
	}
}