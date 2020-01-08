package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Square {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int width;

	public Rectangle() {

	}

	public Rectangle(Point upperLeft, int sideLength, int width) {
		super(upperLeft, sideLength);
		this.width = width;
	}

	public Rectangle(Point upperLeft, int sideLength, int width, Color color) {
		this(upperLeft, sideLength, width);
		setColor(color);
	}

	public Rectangle(Point upperLeft, int sideLength, int width, Color color, Color innerColor) {
		this(upperLeft, sideLength, width, color);
		setInnerColor(innerColor);
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public double area() {
		return sideLength * width;
	}

	public double perimeter() {
		return 2 * sideLength + 2 * width;
	}

	public String toString() {
		return "Rectangle:UpLeft(" + upperLeft.getX()+","+upperLeft.getY() + ") sideLength(" + sideLength + ")"+ " Width(" + width + ") "+getColor()+" "+getInnerColor();
	}

	public boolean equals(Object obj) {
		if (obj instanceof Rectangle) {
			Rectangle r = (Rectangle) obj;
			if (upperLeft.equals(r.upperLeft) && sideLength == r.sideLength && width == r.width)
				return true;
			else
				return false;

		}
		return false;
	}

	public void draw(Graphics g) {
		fill(g);
		g.setColor(getColor());
		g.drawRect(upperLeft.getX(), upperLeft.getY(), width, sideLength);
		if (isSelected())
			selected(g);
	}

	public Line diagonal() {
		Point downRight = new Point(upperLeft.getX() + width, upperLeft.getY() + sideLength);
		return new Line(upperLeft, downRight);
	}

	public void selected(Graphics g) {
		g.setColor(Color.black);
		new Line(getUpperLeft(), new Point(getUpperLeft().getX() + width, getUpperLeft().getY())).selected(g);
		new Line(getUpperLeft(), new Point(getUpperLeft().getX(), getUpperLeft().getY() + sideLength)).selected(g);
		new Line(new Point(getUpperLeft().getX(), getUpperLeft().getY() + sideLength), diagonal().getEndPoint()).selected(g);
		new Line(new Point(getUpperLeft().getX() + width, getUpperLeft().getY()), diagonal().getEndPoint()).selected(g);

	}

	public void fill(Graphics g) {
		g.setColor(getInnerColor());
		g.fillRect(upperLeft.getX() + 1, upperLeft.getY() + 1, width - 1, sideLength - 1);
	}

	public boolean contains(int x, int y) {
		if (this.getUpperLeft().getX() <= x && x <= (this.getUpperLeft().getX() + width)
				&& this.getUpperLeft().getY() <= y && y <= (this.getUpperLeft().getY() + sideLength))
			return true;
		else
			return false;
	}

	public Rectangle clone() {
		Rectangle r = new Rectangle();
		r.setUpperLeft(new Point(this.getUpperLeft().getX(), this.getUpperLeft().getY()));
		r.setSideLength(this.getSideLength());
		r.setWidth(this.getWidth());
		r.setColor(this.getColor());
		r.setInnerColor(this.getInnerColor());
		return r;
	}
}
