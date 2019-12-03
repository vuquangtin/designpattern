package com.designpatterns.creational.abstractfactory.products;
/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class ConcreteProductA2 extends AbstractProduct2 {
    public ConcreteProductA2(String name) {
        super(name);
    }
    public void run() {
        System.out.println(name + " 完成(A2-run)！");
    }
}