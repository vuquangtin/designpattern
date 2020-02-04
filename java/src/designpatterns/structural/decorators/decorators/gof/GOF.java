package decorators.gof;

/**
 * <h1>Decorator</h1> Gán bổ sung các “trách nhiệm” (responsibility) cho một đối
 * tượng một cách linh hoạt. Các decorator cung cấp một sự lựa chọn linh động
 * cho lớp con để mở rộng tính năng
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class GOF {
	public static void main(String[] args) {
		Component co = new ConcreteComponent();
		co.method1();
		System.out.print("\n\n");
		co.method2();
		System.out.print("\n");

		Component coA = new ConcreteDecoratorA(co);
		coA.method1();
		System.out.print("\n\n");
		coA.method2();
		System.out.print("\n");

		Component coB = new ConcreteDecoratorB(coA);
		coB.method1();
		System.out.print("\n\n");
		coB.method2();
	}
}

abstract class Component {
	public abstract void method1();

	public abstract void method2();
}

class ConcreteComponent extends Component {
	public void method1() {
		System.out.print("ConcComp-m1()");
	}

	public void method2() {
		System.out.println("ConcComp-m2()");
	}
}

abstract class Decorator extends Component {
	protected Component component;

	public Decorator(Component component) {
		this.component = component;
	}
}

class ConcreteDecoratorA extends Decorator {
	public ConcreteDecoratorA(Component component) {
		super(component);
	}

	public void method1() {
		System.out.print("ConcDecoA-m1() {");
		component.method1();
		System.out.print("}");
	}

	public void method2() {
		System.out.println("ConcDecoA-m2() {");
		component.method2();
		System.out.println("}");
	}
}

class ConcreteDecoratorB extends Decorator {
	public ConcreteDecoratorB(Component component) {
		super(component);
	}

	public void method1() {
		System.out.print("ConcDecoB-m1() {");
		component.method1();
		System.out.print("}");
	}

	public void method2() {
		System.out.println("ConcDecoB-m2() {");
		component.method2();
		System.out.println("}");
	}
}