package com.designpatterns.creational.abstractfactory.products;
/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public abstract class AbstractProduct3 {
    protected String name;
    public AbstractProduct3(String name) {
        this.name = name;
    }
    public abstract void action();
}