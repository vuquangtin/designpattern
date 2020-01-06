package com.designpatterns.behavioral.nullobject.shares;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class ShapeFactory {

	public static Shape createShape(String shapeType) {

		Shape shape = null;

		if ("Circle".equalsIgnoreCase(shapeType)) {

			shape = new Circle();

		} else if ("Rectangle".equalsIgnoreCase(shapeType)) {

			shape = new Rectangle();

		} else if ("Triangle".equalsIgnoreCase(shapeType)) {

			shape = new Triangle();

		} else {

			shape = new NullShape();

		}

		return shape;

	}

}