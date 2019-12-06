package iterators.gof2;

import java.util.ArrayList;
import java.util.List;

/**
 * Design Patterns
 * 
 * @see http://www.itsenka.com/contents/development/designpattern/visitor.html
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class GOF {
	public static void main(String[] args) {
		Visitor viA = new ConcreteVisitorA();
		Visitor viB = new ConcreteVisitorB();
		Acceptor acA = new ConcreteAcceptorA();
		Acceptor acB = new ConcreteAcceptorB();
		acA.accept(viA);
		acB.accept(viA);
		acA.accept(viB);
		acB.accept(viB);
		Visitor item;
		List<Visitor> list = new ArrayList<Visitor>();
		for (int i = 0; i < 100; i++) {
			if (i % 2 == 0) {
				item = new ConcreteVisitorA();
			} else {
				item = new ConcreteVisitorB();
			}
			list.add(item);
		}
		int i = 0;
		for (Visitor visitor : list) {

			if (i % 2 == 0) {
				acA.accept(visitor);
			} else {
				acB.accept(visitor);
			}
			i++;
		}
	}
}

abstract class Visitor {
	public abstract void visit(ConcreteAcceptorA acceptorA);

	public abstract void visit(ConcreteAcceptorB acceptorB);
}

class ConcreteVisitorA extends Visitor {
	private String name = "ConcreteVisitorA";

	public void visit(ConcreteAcceptorA acceptorA) {
		System.out.println(name + " が " + acceptorA.getName() + " を訪問しました。");
	}

	public void visit(ConcreteAcceptorB acceptorB) {
		System.out.println(name + " が " + acceptorB.getName() + " を訪問しました。");
	}
}

class ConcreteVisitorB extends Visitor {
	private String name = "ConcreteVisitorB";

	public void visit(ConcreteAcceptorA acceptorA) {
		System.out.println(name + " が " + acceptorA.getName() + " に参りました。");
	}

	public void visit(ConcreteAcceptorB acceptorB) {
		System.out.println(name + " が " + acceptorB.getName() + " に参りました。");
	}
}

abstract class Acceptor {
	public abstract void accept(Visitor visitor);
}

class ConcreteAcceptorA extends Acceptor {
	private String name = "ConcreteAcceptorA";

	public String getName() {
		return name;
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}

class ConcreteAcceptorB extends Acceptor {
	private String name = "ConcreteAcceptorB";

	public String getName() {
		return name;
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}