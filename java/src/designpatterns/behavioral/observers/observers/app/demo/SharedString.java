package observers.app.demo;

import java.util.Observable;

/**
 * <h1>Observer</h1> Định nghĩa một sự phụ thuộc 1-nhiều giữa các đối tượng để
 * khi một đối tượng thay đổi trạng thái, tất cả phụ thuộc của nó được thông báo
 * và cập nhật một cách tự động.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com

 *      /vuquangtin/designpattern</a>
 *
 */
public class SharedString extends Observable {
	private String theString;

	public SharedString() {
		super();
	}
	
	public String getTheString() {
		return theString;
	}

	public void setTheString(String theString) {
		this.theString = theString;
		
		// fire notifications to any registered Observers
		setChanged();
		notifyObservers();
	}
}