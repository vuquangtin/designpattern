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
public class Wheel implements ICarElement {
	String name;
	String modelNumberWheel;
	String modelYearWheel;

	public Wheel(String n) {
		this.name = n;
	}

	public void accept(CartPartVisitor visitor) {
		visitor.visit(this);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModelNumberWheel() {
		return modelNumberWheel;
	}

	public void setModelNumberWheel(String modelNumberWheel) {
		this.modelNumberWheel = modelNumberWheel;
	}

	public String getModelYearWheel() {
		return modelYearWheel;
	}

	public void setModelYearWheel(String modelYearWheel) {
		this.modelYearWheel = modelYearWheel;
	}
}