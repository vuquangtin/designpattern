package com.designpatterns.behavioral.nullobject.shares;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public interface Shape {

	double area();

	double perimeter();

	void draw();

	// nice to have method to indicate null object

	boolean isNull();

}