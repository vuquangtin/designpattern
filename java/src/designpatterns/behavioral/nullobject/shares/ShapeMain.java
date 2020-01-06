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
public class ShapeMain {

	public static void main(String[] args) {

		String[] shapeTypes = new String[] { "Circle", null, "Triangle",
				"Pentagon", "Rectangle", "Trapezoid" };

		for (String shapeType : shapeTypes) {

			Shape shape = ShapeFactory.createShape(shapeType);

			// no null-check required since shape factory always creates shape
			// objects

			System.out.println("Shape area: " + shape.area());

			System.out.println("Shape Perimeter: " + shape.perimeter());

			shape.draw();

			System.out.println();

		}

	}

}
