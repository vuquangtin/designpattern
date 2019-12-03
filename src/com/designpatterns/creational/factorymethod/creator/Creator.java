package com.designpatterns.creational.factorymethod.creator;
/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public abstract class Creator {
    public abstract Product factoryMethod();
    public final Product create() {
        Product product = factoryMethod();
        return product;
    }
}