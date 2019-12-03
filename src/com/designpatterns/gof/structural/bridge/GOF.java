package com.designpatterns.gof.structural.bridge;

/**
 * Design Patterns
 * 
 * @see http://www.itsenka.com/contents/development/designpattern/bridge.html
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
class Abstraction {
	private Implementor impl;

	public Abstraction(Implementor impl) {
		this.impl = impl;
	}

	public void abstractionMethod() {
		impl.implMethod();
	}
}

class RefinedAbstraction extends Abstraction {
	public RefinedAbstraction(Implementor impl) {
		super(impl);
	}

	public void refinedMethod() {
		System.out.println("追加機能");
	}
}

abstract class Implementor {
	public abstract void implMethod();
}

class ConcreteImplementor extends Implementor {
	public void implMethod() {
		System.out.println("実装機能");
	}
}

public class GOF {
	public static void main(String[] args) {
		Abstraction abstraction = new Abstraction(new ConcreteImplementor());
		RefinedAbstraction refinedAbstraction = new RefinedAbstraction(
				new ConcreteImplementor());
		abstraction.abstractionMethod();
		refinedAbstraction.abstractionMethod();
		refinedAbstraction.refinedMethod();
	}
}
