package com.designpatterns.creational.abstractfactory.products;
/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class ConcreteFactoryA extends AbstractFactory {
    public static final int id = 1;
    public AbstractProduct1 createProduct1() {
        return new ConcreteProductA1("工場A - 製品1");
    }
    public AbstractProduct2 createProduct2() {
        return new ConcreteProductA2("工場A - 製品2");
    }
    public AbstractProduct3 createProduct3() {
        return new ConcreteProductA3("工場A - 製品3");
    }
}