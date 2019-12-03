package com.designpatterns.creational.abstractfactory.products;
/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class ConcreteProductB3 extends AbstractProduct3 {
    public ConcreteProductB3(String name) {
        super(name);
    }
    public void action() {
        System.out.println(name + " 完成(B3-action)！");
    }
}