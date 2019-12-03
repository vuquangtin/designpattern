package com.designpatterns.behavioral.strategy.quack;
/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class MallardDuck extends Duck {
    public MallardDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }
    // other methods
    public void setFlyBehavior (FlyBehavior fb) {
        flyBehavior = fb;
    }
    public void setQuackBehavior (QuackBehavior qb) {
        quackBehavior = qb;
    }
	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}
}