package observers.gof1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

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
abstract class Subject {
	private List<Observer> observers = new ArrayList<Observer>(); // 複数のオブザーバの保持が可能
	private Random random = new Random();

	public void addObserver(Observer observer) {
		observers.add(observer);
	}

	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}

	public void notifyObservers() {
		Iterator<Observer> it = observers.iterator();
		while (it.hasNext()) {
			it.next().update(this);
		}
	}

	public int getRandomNumber() {
		return random.nextInt(100);
	}

	public abstract int getStatus();

	public abstract String getName();

	public abstract void run();
}

/**
 * <h1>Observer</h1> Định nghĩa một sự phụ thuộc 1-nhiều giữa các đối tượng để
 * khi một đối tượng thay đổi trạng thái, tất cả phụ thuộc của nó được thông báo
 * và cập nhật một cách tự động.
 * 
 * @see http://www.itsenka.com/contents/development/designpattern/observer.html
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class GOF {
	public static void main(String[] args) {
		Observer ob = new ConcreteObserver();
		Subject sb1 = new ConcreteSubjectA();
		Subject sb2 = new ConcreteSubjectB();
		sb1.addObserver(ob);
		sb2.addObserver(ob);
		for (int i = 0; i < 50; i++) {
			sb1.run();
			sb2.run();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("■■　END　■■");
	}
}

class ConcreteSubjectA extends Subject {
	private String subjectName = "ConcreteSubjectA";
	private int status = 0;

	public int getStatus() {
		return status;
	}

	public String getName() {
		return subjectName;
	}

	public void run() {
		int randomNumber = 0;
		randomNumber = getRandomNumber();
		if (status < randomNumber) {
			System.out.println(subjectName + "の状態が " + status + " -> "
					+ randomNumber + " に変わります。");
			status = randomNumber;
			notifyObservers();
		}
	}
}

class ConcreteSubjectB extends Subject {
	private String subjectName = "ConcreteSubjectB";
	private int status = 100;

	public int getStatus() {
		return status;
	}

	public String getName() {
		return subjectName;
	}

	public void run() {
		int randomNumber = 0;
		randomNumber = getRandomNumber();
		if (status > randomNumber) {
			System.out.println(subjectName + "の状態が " + status + " -> "
					+ randomNumber + " に変わります。");
			status = randomNumber;
			notifyObservers();
		}
	}
}

abstract class Observer {
	public abstract void update(Subject subject);
}

class ConcreteObserver extends Observer {
	private String observerName = "ConcreteObserverA";

	public void update(Subject subject) {
		System.out.println("観察者:" + observerName
				+ System.getProperty("line.separator") + "通知者:"
				+ subject.getName() + System.getProperty("line.separator")
				+ "状態　:" + subject.getStatus());
	}
}