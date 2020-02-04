package nullobject.shares;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class Circle implements Shape {

	// sides

	private final double radius;

	public Circle() {

		this(1.0d);

	}

	public Circle(double radius) {

		this.radius = radius;

	}

	@Override
	public double area() {

		// Area = π r^2

		return Math.PI * Math.pow(radius, 2);

	}

	@Override
	public double perimeter() {

		// Perimeter = 2πr

		return 2 * Math.PI * radius;

	}

	@Override
	public void draw() {

		System.out.println("Drawing Circle with area: " + area()
				+ " and perimeter: " + perimeter());

	}

	@Override
	public boolean isNull() {

		return false;

	}

}