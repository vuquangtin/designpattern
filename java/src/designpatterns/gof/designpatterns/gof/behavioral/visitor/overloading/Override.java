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
public class Override {

	public static void main(String[] args) {
		Object o = new AY();
		AY a1 = new AY();
		AY a2 = new AX();
		AX ax = new AX();

		System.out.print(a1.method(o)+" ");
		System.out.print(a2.method(a1)+" ");
		System.out.print(a2.method(o)+" ");
		System.out.print(a2.method(ax));
	}
}

class AY {

	public int method(Object o) {
		return 1;
	}

	public int method(AY a) {
		return 2;
	}
}

class AX extends AY {

	public int method(AY a) {
		return 3;
	}

	public int method(AX ax) {
		return 4;
	}
}