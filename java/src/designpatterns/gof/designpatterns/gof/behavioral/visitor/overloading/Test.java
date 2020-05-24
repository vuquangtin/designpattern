package designpatterns.gof.behavioral.visitor.overloading;

/**
 * <h1>Java inheritance and method overloading</h1> And the output is "3".<br/>
 * 
 * Can someone explain in more detail the theoretical concept behind this
 * result. <br/>
 * I know that class A is abstract and that's why it cannot be instantiated but
 * I'd like to understand the whole mechanism of this result.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/designpattern">https://github.com
 * 
 *      /vuquangtin/designpattern</a>
 * @see https://stackoverflow.com/questions/32549118/java-inheritance-and-method
 *      -overloading
 *
 */
public class Test {
	public static void main(String[] args) {
		C x = new C();
		System.out.println(x.fun());
		// =3 boi vi DOAN CODE
		// return ((A) this).met((A) this);
		// o TRong Lop C do do met((A) this) duoc lop B da OVERRIDING tu lop A
		// nen khi ep kieu thanh A cung khong thay doi phuong thuc da dc
		// OVERRIDING ma no THAM CHIEU trong HEAP
	}
}

abstract class A {
	int met(A a) {
		return 0;
	}

	int met(B b) {
		return 1;
	}

	int met(C c) {
		return 2;
	}
}

class B extends A {
	int met(A a) {
		return 3;
	}

	int met(B b) {
		return 4;
	}

	int met(C c) {
		return 5;
	}
}

class C extends B {
	int fun() {
		return ((A) this).met((A) this);
	}
}
