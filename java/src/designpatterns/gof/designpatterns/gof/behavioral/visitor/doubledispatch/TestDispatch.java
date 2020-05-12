package designpatterns.gof.behavioral.visitor.doubledispatch;

/***
 * <h1>
 * Explanation:</h1>
 * 
 * What happens when figure.printOn( printer ) is called at runtime?<br/>
 * This depends on the types of the objects referenced by the figure and printer
 * variables at that time. Let's assume that at the moment, figure points to an
 * instance of class Circle, and printer to an InkjetPrinter. <br/>
 * So, the implementation of printOn( printer ) being called will be that of the
 * circle instance, defined in the Circle class (first dispatch). This method
 * just contains one line: printer.printCircle( this ), which delegates the work
 * to the printer object. As this object is of the class InkjetPrinter, the
 * printCircle( circle ) method of the InkjetPrinter class will be executed
 * (second dispatch), which is just what we wanted.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com

 *      /vuquangtin/designpattern</a>
 * @see https://wiki.c2.com/?DoubleDispatchExample
 *
 */
public class TestDispatch {

	public static void main(String[] args) {
		Figure[] figures = new Figure[] { new Circle(), new Rectangle() };
		Printer[] printers = new Printer[] { new PostscriptPrinter(),
				new InkjetPrinter() };

		new Client().printAllEverywhere(figures, printers);
	}

}

class Circle implements Figure {
	@Override
	public void printOn(Printer printer) {
		printer.printCircle(this); // <-- the "trick" !
	}
}

class Client {

	/**
	 * Prints all figures on each of the printers.
	 */
	void printAllEverywhere(Figure[] figures, Printer[] printers) {
		for (int i = 0; i < figures.length; i++) {
			Figure figure = figures[i];
			for (int j = 0; j < printers.length; j++) {
				Printer printer = printers[j];

				figure.printOn(printer);
				// must work for any printer or figure !
			}
		}
	}

}

interface Figure {

	void printOn(Printer printer);
}

class InkjetPrinter implements Printer {

	@Override
	public void printCircle(Circle circle) {
		// ... rasterizing logic for inkjet printing of circles here ...
		System.out.println("Inkjet printer prints a cirlce.");
	}

	@Override
	public void printRectangle(Rectangle rectangle) {
		// ... rasterizing logic for inkjet printing of rectangles here ...
		System.out.println("Inkjet printer prints a rectangle.");
	}
}

class PostscriptPrinter implements Printer {

	@Override
	public void printCircle(Circle circle) {
		// ... postscript preprocessing logic for circles here ...
		System.out.println("PostScript printer prints a cirlce.");
	}

	@Override
	public void printRectangle(Rectangle rectangle) {
		// ... postscript preprocessing logic for rectangles here ...
		System.out.println("PostScript printer prints a rectangle.");
	}
}

class Rectangle implements Figure {
	@Override
	public void printOn(Printer printer) {
		printer.printRectangle(this);
	}
}

interface Printer {

	void printCircle(Circle circle);

	void printRectangle(Rectangle rectangle);
}
