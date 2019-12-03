package com.oop.features;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class Cat extends Animal {

	public Cat(String name) {
		super(name);
	}

	@Override
	public void sayHello() {
		System.out.println("Hi, I'm " + super.getName());
	}

}