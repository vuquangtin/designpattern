package com.oop.features;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class Dog extends Animal {

	public Dog(String name) {
		super(name);
	}

	@Override
	public void sayHello() {
		System.out.println("Hello, I'm " + super.getName());
	}

}