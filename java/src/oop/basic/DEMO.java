package basic;

import java.awt.Point;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class DEMO {

}

// Rectangle Class
class Rectangles {
	public void setWidth(double w) {
		itsWidth = w;
	}

	public void setHeight(double h) {
		itsHeight = h;
	}

	public double getHeight() {
		return itsHeight;
	}

	public double getWidth() {
		return itsWidth;
	}

	public Point getItsTopLeft() {
		return itsTopLeft;
	}

	public void setItsTopLeft(Point itsTopLeft) {
		this.itsTopLeft = itsTopLeft;
	}

	private Point itsTopLeft;
	private double itsWidth;
	private double itsHeight;
}