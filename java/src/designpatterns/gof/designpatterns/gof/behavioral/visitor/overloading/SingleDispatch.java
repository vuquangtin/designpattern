package designpatterns.gof.behavioral.visitor.overloading;

/**
 * <h1>Single Dispatch</h1>
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/designpattern">https://github.com
 * 
 *      /vuquangtin/designpattern</a>
 *
 */
public class SingleDispatch {
	public void print() {
		System.out.println("Single Dispatch");
	}

	public static void main(String[] args) {
		SingleDispatch objSingleDis = new SingleDispatch();
		objSingleDis.print();
	}
}