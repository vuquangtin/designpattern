package designpatterns.gof.behavioral.visitor.demo;

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
public class MyAccessVisitor extends CartPartVisitor {
	@Override
	public void visit(Wheel part) {
		System.out.println("[DBG] Accessing the name property: " + part.getName());
	}

	@Override
	public void visit(Engine part) {
		System.out.println("[DBG] Accessing the name property: " + part.getName());
	}

	@Override
	public void visit(Body part) {
		System.out.println("[DBG] Accessing the name property: " + part.getName());
	}

	public void visit(Brake part) {
		System.out.println("[DBG] Accessing the name property: " + part.getName());
	}
}