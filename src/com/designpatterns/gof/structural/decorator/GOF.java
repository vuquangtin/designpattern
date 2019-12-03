package com.designpatterns.gof.structural.decorator;

/**
 * Design Patterns
 * 
 * @see http://www.itsenka.com/contents/development/designpattern/decorator.html
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
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