package designpatterns.gof.behavioral.visitor.pattern;

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
		Element elementA = new ConcreteElementA();
		Element elementB = new ConcreteElementB();
		ObjectStructure objectStructure = new ObjectStructure();
		objectStructure.addElement(elementA);
		objectStructure.addElement(elementB);

		Visitor visitor1 = new ConcreteVisitor1();
		objectStructure.visit(visitor1);

		System.out.println();
		Visitor visitor2 = new ConcreteVisitor2();
		objectStructure.visit(visitor2);
	}
}