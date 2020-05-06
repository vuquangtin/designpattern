package designpatterns.gof.structural.facade.inline;

/**
 * <h1>Facade</h1> Cung cấp một interface thống nhất cho một tập các interface
 * trong một hệ thống con (subsystem). Façade định nghĩa một interface mức cao
 * làm cho hệ thống con dễ dàng sử dụng hơn.
 * 
 * <br/>
 * facade encapsulates a complex subsystem behind a simple interface. It hides
 * much of the complexity and makes the subsystem easy to use. Also, if we need
 * to use the complex subsystem directly, we still can do that; we aren't forced
 * to use the facade all the time.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/designpattern">https://github.com
 *      /vuquangtin/designpattern</a>
 *
 */
public class FacadePattern {
	public static void main(String[] args) {
		FacadePatternShapeMaker facadePatternShapeMaker = new FacadePatternShapeMaker();
		facadePatternShapeMaker.drawCircle();
		facadePatternShapeMaker.drawSquare();
	}

}

class FacadePatternShapeMaker {
	private FacadePatternCircle circle;
	private FacadePatternSquare square;

	FacadePatternShapeMaker() {
		this.circle = new FacadePatternCircle();
		this.square = new FacadePatternSquare();
	}

	public void drawCircle() {
		this.circle.draw();
	}

	public void drawSquare() {
		this.square.draw();
	}
}

interface FacadePatternShape {
	public void draw();
}

class FacadePatternCircle implements FacadePatternShape {

	@Override
	public void draw() {
		System.out.println("Drawing Circle.");
	}

}

class FacadePatternSquare implements FacadePatternShape {

	@Override
	public void draw() {
		System.out.println("Drawing Square.");
	}

}