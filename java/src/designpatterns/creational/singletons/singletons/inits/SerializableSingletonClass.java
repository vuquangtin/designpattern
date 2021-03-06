package singletons.inits;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

import org.apache.commons.lang3.Validate;

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
public class SerializableSingletonClass implements Serializable {
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private int value;
	@SuppressWarnings("unused")
	private String name;

	private SerializableSingletonClass(int value, String name) {
		if (value < 0)
			throw new IllegalArgumentException("Value may not be less than 0");
		this.value = value;
		this.name = Validate.notNull(name, "Name may not be null");
	}

	private static class SerializableSingletonHolder {
		public static final SerializableSingletonClass INSTANCE;
		static {
			INSTANCE = new SerializableSingletonClass(0, "default");
		}
	}

	private void readObject(ObjectInputStream stream)
			throws InvalidObjectException {
		throw new InvalidObjectException("proxy required");
	}

	private Object writeReplace() {
		return new SerializationProxy(this);
	}

	private static class SerializationProxy implements Serializable {
		private static final long serialVersionUID = 1L;

		public SerializationProxy(SerializableSingletonClass ignored) {
		} // Here is the question

		private Object readResolve() {
			return SerializableSingletonHolder.INSTANCE;
		}
	}
}