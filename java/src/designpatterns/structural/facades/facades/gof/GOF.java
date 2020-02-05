package facades.gof;

/**
 * <h1>Facade</h1> Cung cấp một interface thống nhất cho một tập các interface
 * trong một hệ thống con (subsystem). Façade định nghĩa một interface mức cao
 * làm cho hệ thống con dễ dàng sử dụng hơn.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class GOF {
	public static void main(String[] args) {
		FacadeGOF facade = new FacadeGOF();
		facade.facadeMethod();
	}
}

class FacadeGOF {
	public void facadeMethod() {
		(new ClassA()).methodA();
		(new ClassB()).methodB();
		(new ClassC()).methodC();
		(new ClassD()).methodD();
	}
}

class ClassA {
	public void methodA() {
		System.out.println("ClassA-mA()");
	}
}

class ClassB {
	public void methodB() {
		System.out.println("ClassB-mB()");
	}
}

class ClassC {
	public void methodC() {
		System.out.println("ClassC-mC()");
	}
}

class ClassD {
	public void methodD() {
		System.out.println("ClassD-mD()");
	}
}