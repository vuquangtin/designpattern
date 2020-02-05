package singletons.inits;

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
public class ThreadSafeSingletonWithDoubleCheckedLocking {
	private static volatile ThreadSafeSingletonWithDoubleCheckedLocking instance;

	private ThreadSafeSingletonWithDoubleCheckedLocking() {

	}

	public static ThreadSafeSingletonWithDoubleCheckedLocking getInstanceUsingDoubleLocking() {
		if (instance == null) {
			synchronized (ThreadSafeSingleton.class) {
				if (instance == null) {
					instance = new ThreadSafeSingletonWithDoubleCheckedLocking();
				}
			}
		}
		return instance;
	}
}