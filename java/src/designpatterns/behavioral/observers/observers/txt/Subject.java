package observers.txt;

import java.util.LinkedList;
import java.util.List;

/**
 * <h1>Observer</h1> Định nghĩa một sự phụ thuộc 1-nhiều giữa các đối tượng để
 * khi một đối tượng thay đổi trạng thái, tất cả phụ thuộc của nó được thông báo
 * và cập nhật một cách tự động.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/designpattern">https://github.com
 *      /vuquangtin/designpattern</a>
 *
 */
public class Subject {

	List<Observer> observers;
	private String state;

	public Subject(String state) {
		observers = new LinkedList<Observer>();
		setState(state);
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
		System.out.println("\nCurrent State: " + state + "\n");
		notifyObservers();
	}

	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}

	public void registerObserver(Observer... observers) {
		for (Observer o : observers)
			this.observers.add(o);
	}

	public void notifyObservers() {
		for (Observer o : observers)
			o.update();
	}

}