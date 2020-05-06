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
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com

 *      /vuquangtin/designpattern</a>
 *
 */
public class VisitorSimpleDemo {

	public static void main(String[] args) {
		// Setup structure
		ObjectStructureDemo o = new ObjectStructureDemo();
		o.attach(new ConcreteElementADemo());
		o.attach(new ConcreteElementBDemo());

		// Create visitor objects
		ConcreteVisitor1 v1 = new ConcreteVisitor1();
		ConcreteVisitor2 v2 = new ConcreteVisitor2();

		// Structure accepting visitors
		o.accept(v1);
		o.accept(v2);

		// Wait for user

	}

}

abstract class VisitorDemo {
	public abstract void visitConcreteElementA(
			ConcreteElementADemo concreteElementA);

	public abstract void visitConcreteElementB(
			ConcreteElementBDemo concreteElementB);

}

// i card generator
class ConcreteVisitor1 extends VisitorDemo

{
	@Override
	public void visitConcreteElementA(ConcreteElementADemo concreteElementA) {
		System.out.println(concreteElementA.getClass().getName()
				+ " visited by " + this.getClass().getName());
	}

	@Override
	public void visitConcreteElementB(ConcreteElementBDemo concreteElementB) {
		System.out.println(concreteElementB.getClass().getName()
				+ " visited by " + this.getClass().getName());

	}

}

// / A 'ConcreteVisitor' class (Printing greeting cards)
class ConcreteVisitor2 extends VisitorDemo

{
	@Override
	public void visitConcreteElementA(ConcreteElementADemo concreteElementA) {
		System.out.println(concreteElementA.getClass().getName()
				+ " visited by " + this.getClass().getName());
	}

	@Override
	public void visitConcreteElementB(ConcreteElementBDemo concreteElementB) {
		System.out.println(concreteElementB.getClass().getName()
				+ " visited by " + this.getClass().getName());

	}

}

abstract class ElementDemo {
	public abstract void accept(VisitorDemo visitor);
}

// / A 'ConcreteElement' class
class ConcreteElementADemo extends ElementDemo {
	@Override
	public void accept(VisitorDemo visitor) {
		visitor.visitConcreteElementA(this);

	}

	public void OperationA() {

	}

}

// / A 'ConcreteElement' class
class ConcreteElementBDemo extends ElementDemo

{
	@Override
	public void accept(VisitorDemo visitor) {
		visitor.visitConcreteElementB(this);
	}

	public void OperationB() {

	}

}

// / The 'ObjectStructure' class

class ObjectStructureDemo {

	private List<ElementDemo> _elements = new ArrayList<ElementDemo>();

	public void attach(ElementDemo element) {
		_elements.add(element);
	}

	public void detach(ElementDemo element) {
		_elements.remove(element);

	}

	public void accept(VisitorDemo visitor) {
		for (ElementDemo element : _elements) {
			element.accept(visitor);
		}
	}

}