package designpatterns.lambdas.behavioral.observers;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

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
public class ObserverPatternTest {

	@Test
	public void test1() {

		Feed f = new Feed();
		f.registerObserver(new NYTimes());
		f.registerObserver(new Guardian());
		f.registerObserver(new LeMonde());
		f.notifyObservers("firstTestMsg");
	}

	@Test
	public void test2() {

		Feed f = new Feed();
		f.registerObserver((String tweet) -> {
			System.out.println("NYTimes tweet = " + tweet);
		});

		f.registerObserver((String tweet) -> {
			System.out.println("LeMonde tweet = " + tweet);
		});
		f.registerObserver((String tweet) -> {
			System.out.println("Guardian tweet = " + tweet);
		});

		// f.registerObserver(new Guardian());
		// f.registerObserver(new LeMonde());
		f.notifyObservers("firstTestMsg");
	}

	interface Subject {
		void registerObserver(Observer p);

		void notifyObservers(String tweet);
	}

	class Feed implements Subject {

		private final List<Observer> observers = new ArrayList<>();

		@Override
		public void registerObserver(Observer p) {
			observers.add(p);
		}

		@Override
		public void notifyObservers(String tweet) {
			observers.forEach(o -> o.notify(tweet));
		}
	}

	@FunctionalInterface
	public interface Observer {
		void notify(String tweet);
	}

	class NYTimes implements Observer {

		@Override
		public void notify(String tweet) {
			System.out.println("NYTimes tweet = " + tweet);
		}
	}

	class Guardian implements Observer {

		@Override
		public void notify(String tweet) {
			System.out.println("Guardian tweet = " + tweet);
		}
	}

	class LeMonde implements Observer {

		@Override
		public void notify(String tweet) {
			System.out.println("LeMonde tweet = " + tweet);
		}
	}
}