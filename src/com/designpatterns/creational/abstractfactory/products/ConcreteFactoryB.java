package com.designpatterns.creational.abstractfactory.products;
/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class ConcreteFactoryB extends AbstractFactory {
    public static final int id = 2;
    public AbstractProduct1 createProduct1() {
        return new ConcreteProductB1("工場B - 製品1");
    }
    public AbstractProduct2 createProduct2() {
        return new ConcreteProductB2("工場B - 製品2");
    }
    public AbstractProduct3 createProduct3() {
        return new ConcreteProductB3("工場B - 製品3");
    }
}
