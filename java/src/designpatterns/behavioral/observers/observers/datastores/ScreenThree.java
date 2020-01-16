package observers.datastores;

import java.util.Observer;

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
public class ScreenThree implements Observer {
	private static final String TAG = ScreenThree.class.getSimpleName();

	@Override
	public void update(java.util.Observable o, Object arg) {
		System.out.println(TAG + "Observable: " + o + ", Object: " + arg);
		if (arg instanceof DataStore) {
			DataStore dataStore = (DataStore) arg;
			System.out.println(dataStore.getData());
		}
	}

}