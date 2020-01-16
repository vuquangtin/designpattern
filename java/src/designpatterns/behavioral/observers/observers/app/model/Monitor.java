package observers.app.model;

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
public class Monitor implements ObserverInterface {
	private ObservableInterface ob;
	private Object value;
	private CallbackInterface callback;

	public Monitor(ObservableInterface o) {
		this.ob = o;
		this.value = this.ob.get();
		o.subscribe(this);
	}

	@Override
	public void notify_update() {
		this.value = ob.get();
		System.out.println("Observable has changed: " + ob + " value: "
				+ this.value);
		callback.update();
	}

	public String toString() {
		return "Monitor(" + ob.hashCode() + ")";
	}

	public Object get() {
		return value;
	}

	public String getName() {
		return ob.getName();
	}

	public void free() {
		ob = null;
	}

	public void close() {
		ob.unsubscribe(this);
	}

	public void setCallback(CallbackInterface c) {
		this.callback = c;
	}

	@Override
	protected void finalize() throws Throwable {
		try {
			this.close();
		} finally {
			super.finalize();
		}
	}
}
