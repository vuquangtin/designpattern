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

public class SynchronizedSingleton {
	// Client
	public static void main(String[] args) {
		SynchronizedSingleton instance = SynchronizedSingleton.getInstance();
		SynchronizedSingleton instance2 = SynchronizedSingleton.getInstance();

		System.out.println("不信？你看看，是不是同一个如花 " + (instance == instance2));

		instance.result();
	}

	private static SynchronizedSingleton singleton;

	private SynchronizedSingleton() {
	}

	private static synchronized SynchronizedSingleton getInstance() {
		System.out.println("staring to new girfriend ...");

		if (singleton == null) {
			singleton = new SynchronizedSingleton();
			System.out.println("new girfriend success ...");
		} else {
			System.out.println("女朋友只有一个，你还想new个新的？！ 只能给你同一个女朋友");
		}

		return singleton;
	}

	public void result() {
		System.out.println("你的单例女朋友：如花 出来了");
	}

}