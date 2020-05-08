package designpatterns.gof.book.inline;

import designpatterns.gof.book.inline.DesignPatternContants.Pattern;

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
@DesignPattern(value = Pattern.Singleton, description = "单例")
public class SingletonPattern implements DesignPatternClient {

	private final static class Singleton {
		private static final Singleton INSTANCE = new Singleton();

		private Singleton() {
		}

		public static Singleton getInstance() {
			return INSTANCE;
		}

		public void doSomething() {
			System.out.println("正在做一些事情...");
		}

	}

	@Override
	public void usage() {
		Singleton singleton = Singleton.getInstance();

		singleton.doSomething();
	}

	public static void main(String[] args) {
		new SingletonPattern().usage();
	}

}