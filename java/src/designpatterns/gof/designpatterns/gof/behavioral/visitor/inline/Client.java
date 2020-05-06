package designpatterns.gof.behavioral.visitor.inline;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>Visitor</h1>Diễn tả 1 hoạt động (thao tác, thuật toán) được thực hiện
 * trên các phần tử của 1 cấu trúc đối tượng. Visitor cho phép bạn định nghĩa 1
 * phép toán mới mà không thay đổi các lớp của các phần tử mà nó thao tác
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/designpattern">https://github.com
 *      /vuquangtin/designpattern</a>
 *
 */
public class Client {
	public static void main(String[] args) {
		ObjectStructure structure = new ObjectStructure();
		structure.add(new ConcreteElementA());
		structure.add(new ConcreteElementB());

		Visitor visitorA = new ConcreteVisitorA();
		Visitor visitorB = new ConcreteVisitorB();

		structure.accept(visitorA);
		structure.accept(visitorB);
	}
}

interface Visitor {
	void visit(ConcreteElementA concreteElementA);

	void visit(ConcreteElementB concreteElementB);
}

class ConcreteVisitorA implements Visitor {
	@Override
	public void visit(ConcreteElementA concreteElementA) {
		System.out.println("ConcreteVistorA visit elementA");
	}

	@Override
	public void visit(ConcreteElementB concreteElementB) {
		System.out.println("ConcreteVistorA visit elementB");

	}
}

class ConcreteVisitorB implements Visitor {
	@Override
	public void visit(ConcreteElementA concreteElementA) {
		System.out.println("ConcreteVisitorB visit elementA");
	}

	@Override
	public void visit(ConcreteElementB concreteElementB) {
		System.out.println("ConcreteVisitorB visit elementB");

	}
}

interface Element {
	void accepte(Visitor visitor);
}

class ConcreteElementA implements Element {
	@Override
	public void accepte(Visitor visitor) {
		visitor.visit(this);
	}
}

class ConcreteElementB implements Element {

	@Override
	public void accepte(Visitor visitor) {
		visitor.visit(this);
	}
}

class ObjectStructure {
	private List<Element> elements = new ArrayList<>();

	public void add(Element element) {
		elements.add(element);
	}

	public void remove(Element element) {
		elements.remove(element);
	}

	public void accept(Visitor visitor) {
		elements.stream().forEach(e -> e.accepte(visitor));
	}
}