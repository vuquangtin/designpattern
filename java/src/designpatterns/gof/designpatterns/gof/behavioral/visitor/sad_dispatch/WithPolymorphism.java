package designpatterns.gof.behavioral.visitor.sad_dispatch;

import java.util.Arrays;
import java.util.List;

/**
 * <h1>Polymorphism</h1>
 * 
 * In the following example, a hierarchy of shapes are defined with each of the
 * derived types overloading a base virtual Draw() method. Next, a console
 * application is used to define a list of each of the shapes and iterate over
 * each shape in the collection calling the Draw() method of each item in the
 * list:
 * 
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class WithPolymorphism {
	public static void main(String[] args) {
		List<Shape> shapes = Arrays.asList(new Shape(), new Polygon(),
				new Quadrilateral(), new Parallelogram(), new Rectangle());

		for (Shape shape : shapes) {
			shape.Draw();
		}
	}

	static class Shape {
		public void Draw() {
			System.out.println("A shape is drawn.");
		}
	}

	static class Polygon extends Shape {
		@Override
		public void Draw() {
			System.out.println("A polygon is drawn.");
		}
	}

	static class Quadrilateral extends Polygon {
		public void Draw() {
			System.out.println("A quadrilateral is drawn.");
		}
	}

	static class Parallelogram extends Quadrilateral {
		public void Draw() {
			System.out.println("A parallelogram is drawn.");
		}
	}

	static class Rectangle extends Parallelogram {
		public void Draw() {
			System.out.println("A rectangle is drawn.");
		}
	}

}
