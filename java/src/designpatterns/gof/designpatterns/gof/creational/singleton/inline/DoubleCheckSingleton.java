package designpatterns.gof.creational.singleton.inline;

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
public class DoubleCheckSingleton {

	// Client
	public static void main(String[] args) {
		DoubleCheckSingleton instance = DoubleCheckSingleton.getInstance();
		DoubleCheckSingleton instance2 = DoubleCheckSingleton.getInstance();

		System.out.println(instance == instance2);

	}

	/**
	 * volatile（java5）：可以保证多线程下的可见性;
	 * 读volatile：每当子线程某一语句要用到volatile变量时，都会从主线程重新拷贝一份，这样就保证子线程的会跟主线程的一致。
	 * 写volatile: 每当子线程某一语句要写volatile变量时，都会在读完后同步到主线程去，这样就保证主线程的变量及时更新。
	 */
	private volatile static DoubleCheckSingleton singleton;

	private DoubleCheckSingleton() {
	}

	private static DoubleCheckSingleton getInstance() {
		if (singleton == null) {
			synchronized (DoubleCheckSingleton.class) {
				if (singleton == null) {
					singleton = new DoubleCheckSingleton();
				}
			}
		}
		return singleton;
	}

}
