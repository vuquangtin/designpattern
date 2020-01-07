package in.javacodegeeks;

/**
 * <h1>Singleton</h1> Đảm bảo rằng một class (lớp) chỉ có duy nhất một instance
 * (thể hiện), và cung cấp một điểm chung, toàn cục để truy cập vào lớp đó.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class DoubleCheckedLockingMessenger {

	private static final Object lock = new Object();
	private static volatile DoubleCheckedLockingMessenger messenger;

	private DoubleCheckedLockingMessenger() {
	}

	public static DoubleCheckedLockingMessenger getInstance() {

		if (messenger == null) {
			synchronized (lock) {
				if (messenger == null) {
					messenger = new DoubleCheckedLockingMessenger();
				}
			}
		}

		return messenger;
	}

	public void send(String message) {

	}

}
