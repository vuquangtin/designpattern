package com.oop.features;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */

public abstract class Animal {

	private String name;

	public Animal(String name) {
		this.name = name;
	}

	public abstract void sayHello();

	public String getName() {
		return name;
	}

}