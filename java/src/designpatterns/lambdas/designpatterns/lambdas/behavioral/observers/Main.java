package designpatterns.lambdas.behavioral.observers;

import java.util.ArrayList;
import java.util.List;

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
interface LandingObserver {
	public void observeLanding(String name);
}

public class Main {
	public static void main(String[] args) {
		Moon moon = new Moon();

		moon.startSpying(name -> {
			if (name.contains("Apollo")) {
				System.out.println(name + " > We made it!");
			}
		});

		moon.startSpying(name -> {
			if (name.contains("Apollo")) {
				System.out.println(name
						+ " > They're distracted, lets invade earth!");
			}
		});
		moon.land("An asteroid"); // not call
		moon.land("Apollo 11"); // called
	}
}

class Moon {
	private final List<LandingObserver> observers = new ArrayList<>();

	public void land(String name) {
		// for (LandingObserver observer : observers) {
		// observer.observeLanding(name);
		// }
		observers.stream().forEach(observer -> {
			observer.observeLanding(name);
		});
	}

	public void startSpying(LandingObserver observer) {
		observers.add(observer);
	}
}