package observers.datastores;

import java.util.Observable;

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
public class DataStore extends Observable {
	private String data;

	public String getData() {
		return this.data;
	}

	public void setData(String newData) {
		this.data = newData;

		// setChanged() method called from Observable class.
		// apply change data. if you have not call this method, all action will
		// not effect.
		setChanged();
	}
}