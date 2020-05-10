package designpatterns.gof.structural.proxy.pattern;

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
public class Proxy implements Subject {

	private RealSubject realSubject;

	public Proxy(RealSubject realSubject) {
		this.realSubject = realSubject;
	}

	@Override
	public void request() {
		System.out.println("before");
		try {
			realSubject.request();
		} catch (Exception e) {
			System.out.println("ex:" + e.getMessage());
			throw e;
		} finally {
			System.out.println("after");
		}
	}

	@Override
	public void operation() {
		realSubject.operation();
	}
}