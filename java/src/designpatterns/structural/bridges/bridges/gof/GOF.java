package bridges.gof;

/**
 * <h1>Bridge</h1> Tách một abstraction khỏi implementation của nó để cả hai có
 * thể thay đổi độc lập nhau.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com

 *      /vuquangtin/designpattern</a>
 *
 */
class Abstraction {
	private Implementor impl;

	public Abstraction(Implementor impl) {
		this.impl = impl;
	}

	public void abstractionMethod() {
		impl.implMethod();
	}
}

class RefinedAbstraction extends Abstraction {
	public RefinedAbstraction(Implementor impl) {
		super(impl);
	}

	public void refinedMethod() {
		System.out.println("追加機能");
	}
}

abstract class Implementor {
	public abstract void implMethod();
}

class ConcreteImplementor extends Implementor {
	public void implMethod() {
		System.out.println("実装機能");
	}
}

/**
 * <h1>Bridge</h1> Tách một abstraction khỏi implementation của nó để cả hai có
 * thể thay đổi độc lập nhau.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com

 *      /vuquangtin/designpattern</a>
 *
 */
public class GOF {
	public static void main(String[] args) {
		Abstraction abstraction = new Abstraction(new ConcreteImplementor());
		RefinedAbstraction refinedAbstraction = new RefinedAbstraction(
				new ConcreteImplementor());
		abstraction.abstractionMethod();
		refinedAbstraction.abstractionMethod();
		refinedAbstraction.refinedMethod();
	}
}
