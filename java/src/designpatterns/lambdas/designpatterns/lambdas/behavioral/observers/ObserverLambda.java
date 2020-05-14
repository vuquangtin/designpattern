package designpatterns.lambdas.behavioral.observers;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

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
public class ObserverLambda {
	public static class Observable {
		private final Map<Object, Consumer<Object>> listeners = new ConcurrentHashMap<>();

		public void register(Object key, Consumer<Object> listener) {
			listeners.put(key, listener);
		}

		public void unregister(Object key) {
			listeners.remove(key);
		}

		public void sendEvent(Object event) {
			listeners.values().forEach(listener -> listener.accept(event));
		}
	}

	public static void main(String[] args) {
		Observable observable = new Observable();
		observable.register("key1", System.out::println);
		observable.register("key2", System.out::println);

		observable.sendEvent("Hello World!");
	}
}