package com.designpatterns.creational.abstractfactory.products;
/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class ConcreteProductA3 extends AbstractProduct3 {
    public ConcreteProductA3(String name) {
        super(name);
    }
    public void action() {
        System.out.println(name + " 完成(A3-action)！");
    }
}