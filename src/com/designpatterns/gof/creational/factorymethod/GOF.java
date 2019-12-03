package com.designpatterns.gof.creational.factorymethod;

/**
 * Design Patterns
 * 
 * @see http
 *      ://www.itsenka.com/contents/development/designpattern/factory_method.
 *      html
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
// public class Client {
public class GOF {
	public static void main(String[] args) {
		Creator creator = new ConcreteCreator();
		Product product = creator.factoryMethod();
		product.method1();
		product.method2();
	}
}

abstract class Creator {
	public abstract Product factoryMethod();

	public final Product create() {
		Product product = factoryMethod();
		return product;
	}
}

abstract class Product {
	public abstract void method1();

	public abstract void method2();
}

class ConcreteCreator extends Creator {
	public Product factoryMethod() {
		return new ConcreteProduct();
	}
}


class ConcreteProduct extends Product {
	public void method1() {
		System.out.println("method1");
	}

	public void method2() {
		System.out.println("method2");
	}
}