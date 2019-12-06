package adapters.gof.hasa;

/**
 * Design Patterns
 * 
 * @see http://www.itsenka.com/contents/development/designpattern/adapter.html
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class Client {
	public static void main(String[] args) {
		Target target = new Adapter();
		target.targetMethod1();
		target.targetMethod2();
	}
}

abstract class Target {
	public abstract void targetMethod1();

	public abstract void targetMethod2();
}

class Adaptee {
	public void method1() {
		System.out.println("method1");
	}

	public void method2() {
		System.out.println("method2");
	}
}

class Adapter extends Target {
	private Adaptee adaptee;

	public Adapter() {
		this.adaptee = new Adaptee();
	}

	public void targetMethod1() {
		adaptee.method1();
	}

	public void targetMethod2() {
		adaptee.method2();
	}
}