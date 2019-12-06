package facades.gof;

/**
 * Design Patterns
 * 
 * @see http://www.itsenka.com/contents/development/designpattern/facade.html
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