package designpatterns.gof.behavioral.visitor.sad_dispatch;

import java.util.Arrays;
import java.util.List;

/**
 * <h1>Double Dispatch</h1>
 * 
 * The following example contains a hierarchy of Surface types and a hierarchy
 * of Shape types. Each Shape type contains an overloaded virtual Draw() method
 * which contains the logic for how the shape is to be drawn on a particular
 * surface. The example console application uses the polymorphic static binding
 * technique to ensure the proper overload is called for each surface type:
 * 
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class DoubleDispatch {
	static class Surface {
		public void Draw(Shape shape) {
			shape.Draw(this);
		}
	}

	static class EtchASketch extends Surface {
		public void Draw(Shape shape) {
			shape.Draw(this);
		}
	}

	static class Shape {
		public void Draw(Surface surface) {
			Console.WriteLine("A shape is drawn on the surface with ink.");
		}

		public void Draw(EtchASketch etchASketch) {
			Console.WriteLine("The knobs are moved in attempt to draw the shape.");
		}
	}

	static class Polygon extends Shape {
		public void Draw(Surface surface) {
			Console.WriteLine("A polygon is drawn on the surface with ink.");
		}

		public void Draw(EtchASketch etchASketch) {
			Console.WriteLine("The knobs are moved in attempt to draw the polygon.");
		}
	}

	static class Quadrilateral extends Polygon {
		public void Draw(Surface surface) {
			Console.WriteLine("A quadrilateral is drawn on the surface with ink.");
		}

		public void Draw(EtchASketch etchASketch) {
			Console.WriteLine("The knobs are moved in attempt to draw the quadrilateral.");
		}
	}

	static class Parallelogram extends Quadrilateral {
		public void Draw(Surface surface) {
			Console.WriteLine("A parallelogram is drawn on the surface with ink.");
		}

		public void Draw(EtchASketch etchASketch) {
			Console.WriteLine("The knobs are moved in attempt to draw the parallelogram.");
		}
	}

	static class Rectangle extends Parallelogram {
		public void Draw(Surface surface) {
			Console.WriteLine("A rectangle is drawn on the surface with ink.");
		}

		public void Draw(EtchASketch etchASketch) {
			Console.WriteLine("The knobs are moved in attempt to draw the rectangle.");
		}
	}

	public static void main(String[] args) {
		Surface surface = new Surface();
		Surface etchASketch = new EtchASketch();

		List<Shape> shapes = Arrays.asList(

		new Shape(), new Polygon(), new Quadrilateral(), new Parallelogram(),
				new Rectangle());

		for (Shape shape : shapes) {
			surface.Draw(shape);
			etchASketch.Draw(shape);
		}

		Console.ReadLine();
	}
}
