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
public class Car {
	Wheel wheel = new Wheel("Wheel Part");
	Body body = new Body("Body Part");
	Engine engine = new Engine("Engine Part");
	Brake brake = new Brake("Brake Part");

	public void accept(CartPartVisitor visitor) {
		wheel.accept(visitor);
		engine.accept(visitor);
		body.accept(visitor);
		brake.accept(visitor);
	}
}