package singletons.full;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.Random;

import javax.management.InstanceAlreadyExistsException;

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
public class FullSingleton implements Serializable {

	private static final long serialVersionUID = 1L;
	private static FullSingleton obj = null;
	private int val;

	private FullSingleton() throws InstanceAlreadyExistsException {
		if (obj != null) {
			System.out.println("\nObject already created....");
			throw new InstanceAlreadyExistsException();
		}

		System.out.println("Inside Constructor..");
		val = new Random().nextInt();
	}

	public static FullSingleton getInstance()
			throws InstanceAlreadyExistsException {
		if (obj == null) {
			synchronized (FullSingleton.class) {
				if (obj == null) {
					obj = new FullSingleton();
				}
			}
		}
		return obj;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	@Override
	protected FullSingleton clone() throws CloneNotSupportedException {
		// If user tries to clone the object then we are sending same class
		// object
		try {
			return FullSingleton.getInstance();
		} catch (InstanceAlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private Object readResolve() throws ObjectStreamException,
			InstanceAlreadyExistsException {
		// We are blocking deserilizing object and sending same class object
		return FullSingleton.getInstance();
	}
}
