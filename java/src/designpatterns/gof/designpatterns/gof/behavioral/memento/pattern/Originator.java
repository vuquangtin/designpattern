package designpatterns.gof.behavioral.memento.pattern;

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
public class Originator {
	private String state;

	public Originator(String state) {
		this.state = state;
	}

	public void setMemento(Memento memento) {
		this.state = memento.getState();
	}

	public Memento createMemento() {
		return new Memento(state);
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}