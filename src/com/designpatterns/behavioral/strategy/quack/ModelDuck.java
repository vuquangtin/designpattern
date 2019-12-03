package com.designpatterns.behavioral.strategy.quack;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class ModelDuck extends Duck {
	public ModelDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new Quack();
    }

	public void display() {
		System.out.println("I'm a model duck");
	}
}