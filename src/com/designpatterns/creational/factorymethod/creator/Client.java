package com.designpatterns.creational.factorymethod.creator;

/**
 * Design Patterns
 * 
 * @see http
 *      ://www.itsenka.com/contents/development/designpattern/factory_method.
 *      html
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class Client {
	public static void main(String[] args) {
		Creator creator = new ConcreteCreator();
		Product product = creator.factoryMethod();
		product.method1();
		product.method2();
	}
}