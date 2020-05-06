package designpatterns.gof.structural.bridge.inline;

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
public class Main {

	public static void main(String[] args) {
		ConcreteImplementor concreteImplementor = new ConcreteImplementor();
		RefinedAbstraction refinedAbstraction = new RefinedAbstraction(concreteImplementor);
		refinedAbstraction.action();
	}

}

abstract class Abstraction {

	protected Implementor implementor;

	public Abstraction(Implementor implementor) {
		this.implementor = implementor;
	}

	abstract void action();
}

class RefinedAbstraction extends Abstraction {

	public RefinedAbstraction(Implementor implementor) {
		super(implementor);
	}

	@Override
	void action() {
		implementor.operation();
	}
}

interface Implementor {
	void operation();
}

class ConcreteImplementor implements Implementor {

	public void operation() {
		System.out.println("Within concrete implementor.");
	}

}
