package designpatterns.gof.behavioral.visitor.sad_dispatch;

/***
 * <h1>Method Overloading</h1>
 * 
 * In the following example, our Shape class is redefined to have two overloaded
 * Draw methods: one with a parameter of type Surface and one with a parameter
 * of type EtchASketch:
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class MethodOverloading {
	static class Surface {
	}

	static class EtchASketch extends Surface {
	}

	public static class Shape {
		public Shape() {

		}

		public void Draw(Surface surface) {
			Console.WriteLine("A shape is drawn on the surface with ink.");
		}

		public void Draw(EtchASketch etchASketch) {
			Console.WriteLine("The knobs are moved in attempt to draw the shape.");
		}

		public void Draw(SurfaceBinding surface) {
			Console.WriteLine("A shape is drawn on the surface with ink.");
		}

		public void Draw(EtchASketchBinding etchASketch) {
			Console.WriteLine("The knobs are moved in attempt to draw the shape.");
		}
	}

	public static void main(String[] args) {
		main1();
		main2();
		main3();
	}

	public static void main1() {
		Shape shape = new Shape();
		shape.Draw(new Surface());
		shape.Draw(new EtchASketch());

		Console.ReadLine();
	}

	public static void main2() {
		Shape shape = new Shape();
		Surface surface = new Surface();
		Surface etchASketch = new EtchASketch();

		shape.Draw(surface);
		shape.Draw(etchASketch);

		Console.ReadLine();
	}

	public static void main3() {
		Shape shape = new Shape();
		SurfaceBinding surface = new SurfaceBinding();
		SurfaceBinding etchASketch = new EtchASketchBinding();

		surface.Draw(shape);
		etchASketch.Draw(shape);

		Console.ReadLine();
	}

	/***
	 * <h1>Polymorphic Static Binding</h1>
	 * 
	 * Polymorphic static binding is a technique where static method invocations
	 * are determined at run-time through the use of polymorphism. This can be
	 * demonstrated in our example by adding a new Draw(Shape shape) method to
	 * the Surface and EtchASketch types which call shape.Draw() with a
	 * reference to the current object:
	 * 
	 * 
	 *
	 */
	static class SurfaceBinding {
		public void Draw(Shape shape) {
			shape.Draw(this);
		}
	}

	static class EtchASketchBinding extends SurfaceBinding {
		public void Draw(Shape shape) {
			shape.Draw(this);
		}
	}
}