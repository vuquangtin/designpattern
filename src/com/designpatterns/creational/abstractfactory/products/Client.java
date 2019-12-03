package com.designpatterns.creational.abstractfactory.products;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Design Patterns
 * 
 * @see http://www.itsenka.com/contents/development/designpattern/abstract_factory
 *      .html
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class Client {
	public static void main(String[] args) {
		List<AbstractFactory> factorys = new ArrayList<AbstractFactory>();
		factorys.add(AbstractFactory.createFactory(ConcreteFactoryA.id));
		factorys.add(AbstractFactory.createFactory(ConcreteFactoryB.id));
		Iterator<AbstractFactory> it = factorys.iterator();
		while (it.hasNext()) {
			AbstractFactory factory = it.next();
			AbstractProduct1 product1 = factory.createProduct1();
			AbstractProduct2 product2 = factory.createProduct2();
			AbstractProduct3 product3 = factory.createProduct3();
			product1.execute();
			product2.run();
			product3.action();
		}
	}
}