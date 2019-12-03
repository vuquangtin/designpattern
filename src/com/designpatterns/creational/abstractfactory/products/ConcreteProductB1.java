package com.designpatterns.creational.abstractfactory.products;
/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class ConcreteProductB1 extends AbstractProduct1 {
    public ConcreteProductB1(String name) {
        super(name);
    }
    public void execute() {
        System.out.println(name + " 完成(B1-execute)！");
    }
}