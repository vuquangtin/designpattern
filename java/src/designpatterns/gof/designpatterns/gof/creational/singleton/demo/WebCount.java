package designpatterns.gof.creational.singleton.demo;

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
public class WebCount {
	private int count;

	private static class Holder {
		private static WebCount webCount = new WebCount();
	}

	private WebCount() {
	}

	public static WebCount getInstance() {
		return Holder.webCount;
	}

	public void interview() {
		count++;
	}

	public int getCount() {
		return count;
	}
}