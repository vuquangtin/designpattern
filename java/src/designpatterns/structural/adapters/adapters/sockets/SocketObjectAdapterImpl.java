package adapters.sockets;

/**
 * <h1>Adapter</h1> Chuyển interface của một lớp thành interface khác mà các
 * client mong muốn. Adapter để cho các lớp làm việc với nhau dù có thể các
 * interface không tương thích.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class SocketObjectAdapterImpl implements SocketAdapter {

	// Using Composition for adapter pattern
	private Socket sock = new Socket();

	@Override
	public Volt get120Volt() {
		return sock.getVolt();
	}

	@Override
	public Volt get12Volt() {
		Volt v = sock.getVolt();
		return convertVolt(v, 10);
	}

	@Override
	public Volt get3Volt() {
		Volt v = sock.getVolt();
		return convertVolt(v, 40);
	}

	private Volt convertVolt(Volt v, int i) {
		return new Volt(v.getVolts() / i);
	}
}