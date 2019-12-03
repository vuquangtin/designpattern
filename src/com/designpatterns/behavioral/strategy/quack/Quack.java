package com.designpatterns.behavioral.strategy.quack;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class Quack implements QuackBehavior {
	FlyBehavior flyBehavior;
	QuackBehavior quackBehavior;
	public void quack() {
		System.out.println("Quack");
	}
	public void setFlyBehavior (FlyBehavior fb) {
	    flyBehavior = fb;
	}
	public void setQuackBehavior (QuackBehavior qb) {
	    quackBehavior = qb;
	}
}
