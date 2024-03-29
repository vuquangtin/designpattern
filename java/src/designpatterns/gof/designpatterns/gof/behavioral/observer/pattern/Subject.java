package designpatterns.gof.behavioral.observer.pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>Observer</h1> Định nghĩa một sự phụ thuộc 1-nhiều giữa các đối tượng để
 * khi một đối tượng thay đổi trạng thái, tất cả phụ thuộc của nó được thông báo
 * và cập nhật một cách tự động.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public abstract class Subject {
	protected List<Observer> observers = new ArrayList<Observer>();

	protected abstract String getState();

	public void addObserver(Observer observer) {
		observers.add(observer);
	}

	void removeObserver(Observer observer) {
		observers.remove(observer);
	}

	void notifyObservers() {
		for (Observer observer : observers) {
			observer.update(this);
		}
	}
}