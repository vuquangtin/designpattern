package designpatterns.gof.structural.proxy.inline;

/**
 * <h1>Proxy</h1> Cung cấp một đối tượng thay thế hoặc giữ chỗ placeholder cho
 * một đối tượng khác để truy xuất đến nó.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/designpattern">https://github.com
 *      /vuquangtin/designpattern</a>
 *
 */
interface Subject {
	void request();
}

class RealSubject implements Subject {

	@Override
	public void request() {
		System.out.println("RealSubject instance has been created");
	}
}

class Proxy implements Subject {

	private final Subject realSubject;

	public Proxy(Subject realSubject) {
		this.realSubject = realSubject;
	}

	@Override
	public void request() {
		realSubject.request();
	}
}

public class ProxyClient {
	public static void main(String[] args) {
		Proxy proxy = new Proxy(new RealSubject());
		proxy.request();
	}
}