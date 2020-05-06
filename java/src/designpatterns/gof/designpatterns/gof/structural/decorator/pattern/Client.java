package designpatterns.gof.structural.decorator.pattern;

/**
 * <h1>Decorator</h1> Gán bổ sung các “trách nhiệm” (responsibility) cho một đối
 * tượng một cách linh hoạt. Các decorator cung cấp một sự lựa chọn linh động
 * cho lớp con để mở rộng tính năng.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/designpattern">https://github.com
 *      /vuquangtin/designpattern</a>
 *
 */
public class Client {
	public static void main(String[] args) {
		Component component = new ConcreteComponent();
		component.operation();
		System.out.println();

		ConcreteDecoratorA decoratorA = new ConcreteDecoratorA(component);
		decoratorA.setAddedState("new");
		decoratorA.operation();
		System.out.println();

		ConcreteDecoratorB decoratorB = new ConcreteDecoratorB(decoratorA);
		decoratorB.operation();
	}
}