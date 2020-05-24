package designpatterns.gof.behavioral.visitor.overloading;

/**
 * <h1>Bridge</h1> Tách một abstraction khỏi implementation của nó để cả hai có
 * thể thay đổi độc lập nhau.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/designpattern">https://github.com
 * 
 *      /vuquangtin/designpattern</a>
 *
 */
public class CovariantReturnType {
	public static class A {
		A get() {
			return this;
		}

		void message() {
		}

		Object messageObject() {
			return null;
		}
		
	}

	public static class B1 extends A {
		B1 get() {
			return this;
		}

		void message() {
			System.out.println("welcome to covariant return type");
		}

		B1 messageObject() {
			return null;
		}

	}

	public static void main(String args[]) {
		new B1().get().message();
	}
}
