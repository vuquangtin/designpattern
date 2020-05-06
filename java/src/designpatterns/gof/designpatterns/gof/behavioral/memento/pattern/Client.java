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
public class Client {
	public static void main(String[] args) {
		Originator originator = new Originator("new");
		System.out.println(originator.getState());

		Memento memento = originator.createMemento();
		Caretaker caretaker = new Caretaker();
		caretaker.setMemento(memento);

		originator.setState("old");
		System.out.println(originator.getState());

		originator.setMemento(caretaker.getMemento());
		System.out.println(originator.getState());
	}
}