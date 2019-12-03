package com.designpatterns.creational.abstractfactory.products;
/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class ConcreteProductB2 extends AbstractProduct2 {
    public ConcreteProductB2(String name) {
        super(name);
    }
    public void run() {
        System.out.println(name + " 完成(B2-run)！");
    }
}