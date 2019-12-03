package com.designpatterns.behavioral.nullobject.shares;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class NullShape implements Shape {

	// no sides

	@Override
	public double area() {

		return 0.0d;

	}

	@Override
	public double perimeter() {

		return 0.0d;

	}

	@Override
	public void draw() {

		System.out.println("Null object can't be draw");

	}

	@Override
	public boolean isNull() {

		return true;

	}

}
