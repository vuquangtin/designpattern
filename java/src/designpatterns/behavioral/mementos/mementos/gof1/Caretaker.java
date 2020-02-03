package mementos.gof1;

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
	private int param1;
	private String param2;

	public Originator(int param1, String param2) {
		this.param1 = param1;
		this.param2 = param2;
	}

	public void calcAdd(int addNum) {
		param1 += addNum;
	}

	public void concat(String addStr) {
		param2 = param2 + addStr;
	}

	public Memento createMemento() {
		return new Memento(param1, param2);
	}

	public void setMemento(Memento memento) {
		this.param1 = memento.param1;
		this.param2 = memento.param2;
	}

	public String toString() {
		return "param1=>" + param1 + " / param2=>" + param2;
	}
}

class Memento {
	int param1;
	String param2;

	Memento(int param1, String param2) {
		this.param1 = param1;
		this.param2 = param2;
	}
}

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
public class Caretaker {
	static Stack<Memento> mementoList = new Stack<Memento>();

	public static void main(String[] args) {
		Originator originator = new Originator(0, "");
		for (int i = 0; i < 5; i++) {
			for (int j = i; j < i + 5; j++) {
				originator.calcAdd(j);
				originator.concat(Integer.toString(j));
			}
			mementoList.push(originator.createMemento());
		}
		originator.calcAdd(5);
		originator.concat(Integer.toString(5));
		System.out.println(originator);
		while (mementoList.size() != 0) {
			Memento memento = (Memento) mementoList.pop();
			originator.setMemento(memento);
			System.out.println(originator);
		}
	}
}