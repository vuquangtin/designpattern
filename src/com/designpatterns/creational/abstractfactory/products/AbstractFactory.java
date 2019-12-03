package com.designpatterns.creational.abstractfactory.products;
/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public abstract class AbstractFactory {
    public static AbstractFactory createFactory(int factoryId){
        switch(factoryId){
            case ConcreteFactoryA.id:
                return new ConcreteFactoryA();
            case ConcreteFactoryB.id:
                return new ConcreteFactoryB();
            default:
                return null;
        }
    }
    public abstract AbstractProduct1 createProduct1();
    public abstract AbstractProduct2 createProduct2();
    public abstract AbstractProduct3 createProduct3();
}