package observers.app.model;

import java.text.DecimalFormat;
import java.util.*;

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
public class Stock implements ObservableInterface {

	private DecimalFormat df = new DecimalFormat("0.00");
	private ArrayList<ObserverInterface> observers;
	private double price;
	private String name;

	public Stock(String name) {
		observers = new ArrayList<>();
		Random rand = new Random();
		this.name = name;
		this.set(rand.nextDouble() * 50 + 20.0);
	}

	public Stock(String name, Double price) {
		observers = new ArrayList<>();
		this.name = name;
		this.set(price);
	}

	private void notify_observers() {
		for (ObserverInterface o : observers) {
			o.notify_update();
		}
	}

	@Override
	public void unsubscribe(ObserverInterface o) {
		observers.remove(o);
	}

	@Override
	public void subscribe(ObserverInterface o) {
		if (!observers.contains(o))
			observers.add(o);
	}

	@Override
	public Object get() {
		return df.format(this.price);
	}

	public String getName() {
		return this.name;
	}

	public String toString() {
		return this.name + " ($" + df.format(this.price) + ")";
	}

	public void close() {
		for (ObserverInterface o : observers) {
			o.free();
		}
	}

	@Override
	protected void finalize() throws Throwable {
		try {
			this.close();
		} finally {
			super.finalize();
		}
	}

	@Override
	public void set(Object p) {
		this.price = (Double) p;
		if (this.price < 0)
			this.price = 0.0;
		this.notify_observers();
	}
}
