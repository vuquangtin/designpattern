package designpatterns.lambdas.behavioral.observers;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

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
public class ObserverGof {

	interface Listener {
		void onEvent(Object event);
	}

	public static class Observable {
		private final Map<Object, Listener> listeners = new ConcurrentHashMap<>();

		public void register(Object key, Listener listener) {
			listeners.put(key, listener);
		}

		public void unregister(Object key) {
			listeners.remove(key);
		}

		public void sendEvent(Object event) {
			for (Listener listener : listeners.values()) {
				listener.onEvent(event);
			}
		}
	}

	public static class Observer1 {
		Observer1(Observable observable) {
			observable.register(this, new Listener() {
				@Override
				public void onEvent(Object event) {
					System.out.println(event);
				}
			});
		}
	}

	public static class Observer2 implements Listener {
		Observer2(Observable observable) {
			observable.register(this, this);
		}

		@Override
		public void onEvent(Object event) {
			System.out.println(event);
		}
	}

	public static void main(String[] args) {
		Observable observable = new Observable();
		new Observer1(observable);
		new Observer2(observable);

		observable.sendEvent("Hello World!");
	}
}