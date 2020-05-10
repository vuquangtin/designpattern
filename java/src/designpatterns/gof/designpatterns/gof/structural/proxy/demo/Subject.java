package designpatterns.gof.structural.proxy.demo;

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
public abstract class Subject {
	public abstract void doAction();
}

class ProxySubject extends Subject {

	private Subject realSubject;

	public ProxySubject(Subject realSubject) {
		this.realSubject = realSubject;
	}

	@Override
	public void doAction() {
		System.out.println("doAction() before");
		realSubject.doAction();
		System.out.println("doAction() after");
	}
}
