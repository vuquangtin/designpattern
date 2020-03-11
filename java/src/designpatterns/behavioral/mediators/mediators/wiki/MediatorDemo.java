package mediators.wiki;

import java.util.HashMap;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;

/**
 * <h2>Design Patterns</h2>
 * <h3>Mediator</h3> <i>Định nghĩa 1 đối tượng đóng gói cách 1 tập hợp các đối
 * tượng tương tác. Mediator thúc đẩy sự khớp nối lỏng lẻo bằng cách ngăn không
 * cho các đối tượng đề cập đến nhau 1 cách rõ ràng và nó cho phép bạn thay đổi
 * sự tương tác của chúng 1 cách độc lập.</i>
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/designpattern">https://github.com
 *      /vuquangtin/designpattern</a>
 *
 */
class Storage<T> {
	T value;

	T getValue() {
		return value;
	}

	void setValue(Mediator<T> mediator, String storageName, T value) {
		this.value = value;
		mediator.notifyObservers(storageName);
	}
}

class Mediator<T> {
	private final HashMap<String, Storage<T>> storageMap = new HashMap<>();
	private final CopyOnWriteArrayList<Consumer<String>> observers = new CopyOnWriteArrayList<>();

	public void setValue(String storageName, T value) {
		Storage storage = storageMap.computeIfAbsent(storageName, name -> new Storage<>());
		storage.setValue(this, storageName, value);
	}

	public Optional<T> getValue(String storageName) {
		return Optional.ofNullable(storageMap.get(storageName)).map(Storage::getValue);
	}

	public void addObserver(String storageName, Runnable observer) {
		observers.add(eventName -> {
			if (eventName.equals(storageName)) {
				observer.run();
			}
		});
	}

	void notifyObservers(String eventName) {
		observers.forEach(observer -> observer.accept(eventName));
	}
}

public class MediatorDemo {
	public static void main(String[] args) {
		Mediator<Integer> mediator = new Mediator<>();
		mediator.setValue("bob", 20);
		mediator.setValue("alice", 24);
		mediator.getValue("alice").ifPresent(age -> System.out.println("age for alice: " + age));

		mediator.addObserver("bob", () -> {
			System.out.println("new age for bob: " + mediator.getValue("bob").orElseThrow(RuntimeException::new));
		});
		mediator.setValue("bob", 21);
	}
}