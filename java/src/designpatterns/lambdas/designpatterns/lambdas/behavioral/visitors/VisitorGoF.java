package designpatterns.lambdas.behavioral.visitors;

import java.util.Arrays;
import java.util.List;

/**
 * <h1>Visitor</h1>Diễn tả 1 hoạt động (thao tác, thuật toán) được thực hiện
 * trên các phần tử của 1 cấu trúc đối tượng. Visitor cho phép bạn định nghĩa 1
 * phép toán mới mà không thay đổi các lớp của các phần tử mà nó thao tác
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class VisitorGoF {
	interface Element {
		<T> T accept(Visitor<T> visitor);
	}

	public static class Square implements Element {
		final double side;

		public Square(double side) {
			this.side = side;
		}

		@Override
		public <T> T accept(Visitor<T> visitor) {
			return visitor.visit(this);
		}
	}

	public static class Circle implements Element {
		final double radius;

		public Circle(double radius) {
			this.radius = radius;
		}

		@Override
		public <T> T accept(Visitor<T> visitor) {
			return visitor.visit(this);
		}
	}

	public static class Rectangle implements Element {
		final double weidht;
		final double height;

		public Rectangle(double weidht, double height) {
			this.weidht = weidht;
			this.height = height;
		}

		@Override
		public <T> T accept(Visitor<T> visitor) {
			return visitor.visit(this);
		}
	}

	interface Visitor<T> {
		T visit(Square element);

		T visit(Circle element);

		T visit(Rectangle element);
	}

	public static class AreaVisitor implements Visitor<Double> {
		public Double visit(Square element) {
			return element.side * element.side;
		}

		public Double visit(Circle element) {
			return Math.PI * element.radius * element.radius;
		}

		public Double visit(Rectangle element) {
			return element.height * element.weidht;
		}
	}

	public static class PerimeterVisitor implements Visitor<Double> {
		public Double visit(Square element) {
			return 4 * element.side;
		}

		public Double visit(Circle element) {
			return 2 * Math.PI * element.radius;
		}

		public Double visit(Rectangle element) {
			return (2 * element.height + 2 * element.weidht);
		}
	}

	public static void main(String[] args) {
		List<Element> figures = Arrays.asList(new Circle(4), new Square(5),
				new Rectangle(6, 7));

		double totalArea = 0.0;
		Visitor<Double> areaVisitor = new AreaVisitor();
		for (Element figure : figures) {
			totalArea += figure.accept(areaVisitor);
		}
		System.out.println("Total area = " + totalArea);

		double totalPerimeter = 0.0;
		Visitor<Double> perimeterVisitor = new PerimeterVisitor();
		for (Element figure : figures) {
			totalPerimeter += figure.accept(perimeterVisitor);
		}
		System.out.println("Total perimeter = " + totalPerimeter);
	}
}