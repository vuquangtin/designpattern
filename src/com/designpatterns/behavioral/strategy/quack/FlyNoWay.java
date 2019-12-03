package com.designpatterns.behavioral.strategy.quack;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class FlyNoWay implements FlyBehavior {
	public void fly() {
        System.out.println("I can't fly");
    }
}