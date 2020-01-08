package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Square extends SurfaceShape {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Point upperLeft;
	protected int sideLength;

	public Square() {

	}

	public Square(Point upperLeft, int sideLength) {
		this.upperLeft = upperLeft;
		this.sideLength = sideLength;
	}

	public Square(Point upperLeft, int sideLength, Color color) {
		this(upperLeft, sideLength);
		setColor(color);
	}

	public Square(Point upperLeft, int sideLength, Color color, Color innerColor) {
		this(upperLeft, sideLength, color);
		setInnerColor(innerColor);
	}

	public Point getUpperLeft() {
		return upperLeft;
	}

	public void setUpperLeft(Point upperLeft) {
		this.upperLeft = upperLeft;
	}

	public int getSideLength() {
		return sideLength;
	}

	public void setSideLength(int sideLength) {
		this.sideLength = sideLength;
	}

	public void moveTo(int x, int y) {
		upperLeft.moveTo(x, y);
	}

	public void moveBy(int poX, int poY) {
		upperLeft.moveBy(poX, poY);
	}

	public double area() {
		return sideLength * sideLength;
	}

	public double perimeter() {
		return 4 * sideLength;
	}

	public String toString() {
		return "Square:UpperLeft(" + upperLeft.getX()+","+upperLeft.getY() + ") sideLength(" + sideLength + ") "+getColor()+" "+getInnerColor();
	}

	public boolean equals(Object obj) {
		if (obj instanceof Square) {
			Square forwarded = (Square) obj;
			if (upperLeft.equals(forwarded.getUpperLeft()) && sideLength == forwarded.getSideLength()) {
				return true;
			} else
				return false;
		}
		return false;
	}

	public Line diagonal() {
		Point downRight = new Point(upperLeft.getX() + sideLength, upperLeft.getY() + sideLength);
		return new Line(upperLeft, downRight);
	}

	public Point middleOfDiagonal() {
		return diagonal().middleOfTheLine();
	}

	public void draw(Graphics g) {
		fill(g);
		g.setColor(getColor());
		g.drawRect(upperLeft.getX(), upperLeft.getY(), sideLength, sideLength);
		if (isSelected())
			selected(g);
	}

	public void selected(Graphics g) {
		g.setColor(Color.BLUE);
		new Line(getUpperLeft(), new Point(getUpperLeft().getX() + sideLength, getUpperLeft().getY())).selected(g);
		new Line(getUpperLeft(), new Point(getUpperLeft().getX(), getUpperLeft().getY() + sideLength)).selected(g);
		new Line(new Point(getUpperLeft().getX() + sideLength, getUpperLeft().getY()), diagonal().getEndPoint()).selected(g);
		new Line(new Point(getUpperLeft().getX(), getUpperLeft().getY() + sideLength), diagonal().getEndPoint()).selected(g);
	}

	public int compareTo(Object o) {
		if (o instanceof Square) {
			return (int) (-this.area() + ((Square) o).area());
		} else
			return 0;
	}

	public void fill(Graphics g) {
		g.setColor(getInnerColor());
		g.fillRect(upperLeft.getX() + 1, upperLeft.getY() + 1, sideLength - 1, sideLength - 1);
	}

	public boolean contains(int x, int y) {
		if (this.getUpperLeft().getX() <= x && x <= (this.getUpperLeft().getX() + sideLength)
				&& this.getUpperLeft().getY() <= y && y <= (this.getUpperLeft().getY() + sideLength))
			return true;
		else
			return false;
	}

	@Override
	public Shape clone() {
		Square s = new Square();
		s.setUpperLeft(new Point(this.getUpperLeft().getX(), this.getUpperLeft().getY()));
		s.setSideLength(this.getSideLength());
		return s;
	}

}
