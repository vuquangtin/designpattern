package observers.tests;

import java.util.ArrayList;
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
 * @see http://www.programmergirl.com/observer-design-pattern-java/
 *
 */
public abstract class Subject {

	private List<Observer> observers = new ArrayList<>();

	public void register(Observer observer) {
		this.observers.add(observer);
	}

	public void unregister(Observer observer) {
		if (this.observers.contains(observer)) {
			this.observers.remove(observer);
		}
	}

	
	public void notifyAllObserver() {
		for (Observer o : observers) {
			o.update();
		}
	}

	abstract Post getRecentPost() ;

	public void publish(Post compositeDesignPattern) {
		// TODO Auto-generated method stub
		
	}
}