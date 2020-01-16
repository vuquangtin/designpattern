package observers.datastores;

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
public class ObserverDemo {
	public static void main(String[] args) {
		ScreenOne screenOne = new ScreenOne();
		ScreenTwo screenTwo = new ScreenTwo();
		ScreenThree screenThree = new ScreenThree();

		DataStore dataStore = new DataStore();

		dataStore.addObserver(screenOne); // add screenOne in list Observer.
		dataStore.addObserver(screenTwo); // add screenTwo in list Observer.
		dataStore.addObserver(screenThree); // add screenThree in list Observer.

		dataStore.setData("Sieu Dao Chich Code"); // make data change.

		dataStore.notifyObservers(dataStore);// send update to all Observer with
												// Data.

	}
}