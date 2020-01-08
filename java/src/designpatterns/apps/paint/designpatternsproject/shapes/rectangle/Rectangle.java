package designpatternsproject.shapes.rectangle;

import java.awt.Color;
import java.awt.Graphics;

import designpatternsproject.shapes.line.Line;
import designpatternsproject.shapes.point.Point;
import designpatternsproject.shapes.square.Square;

public class Rectangle extends Square {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7876647484668688482L;

	// Defining only width, sideLength(from Square) will be used for height
	private int width;

	public Rectangle(Point upperLeft, int height, int width) {
		super(upperLeft, height);
		this.width = width;
	}

	public Rectangle(Point upperLeft, int height, int width, Color outerColor) {
		this(upperLeft, height, width);
		setColor(outerColor);
	}

	public Rectangle(Point upperLeft, int height, int width, Color outerColor, Color innerColor) {
		this(upperLeft, height, width, outerColor);
		setInnerColor(innerColor);
	}

	@Override
	public Line diagonal() {
		return new Line(upperLeft, new Point(upperLeft.getX() + width, upperLeft.getY() + sideLength));
	}

	@Override
	public Point center() {
		return diagonal().lineCenter();
	}

	@Override
	public int surfaceArea() {
		return width * sideLength;
	}

	@Override
	public int volume() {
		return 2 * (width + sideLength);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Rectangle) {
			Rectangle castedObj = (Rectangle) obj;
			return upperLeft.equals(castedObj.getUpperLeft()) && width == castedObj.getWidth()
					&& sideLength == castedObj.getSideLength();
		}
		return false;
	}

	@Override
	public String toString() {
		return String.format(
				"Rectangle(UpperX=%d,UpperY=%d,height=%d,width=%d,outercolor=[%d-%d-%d],innercolor=[%d-%d-%d])",
				upperLeft.getX(), upperLeft.getY(), sideLength, width, getColor().getRed(), getColor().getGreen(),
				getColor().getBlue(), getInnerColor().getRed(), getInnerColor().getGreen(), getInnerColor().getBlue());
	}

	@Override
	public boolean contains(int x, int y) {
		return upperLeft.getX() <= x && x <= (upperLeft.getX() + width) && upperLeft.getY() <= y
				&& y <= (upperLeft.getY() + sideLength);
	}

	@Override
	public void selected(Graphics g) {
		g.setColor(Color.BLUE);
		new Line(upperLeft, new Point(upperLeft.getX() + width, upperLeft.getY())).selected(g);
		new Line(upperLeft, new Point(upperLeft.getX(), upperLeft.getY() + sideLength)).selected(g);
		new Line(new Point(upperLeft.getX() + width, upperLeft.getY()), diagonal().getPtEnd()).selected(g);
		new Line(new Point(upperLeft.getX(), upperLeft.getY() + sideLength), diagonal().getPtEnd()).selected(g);
	}

	@Override
	public void fill(Graphics g) {
		g.setColor(getInnerColor());
		g.fillRect(upperLeft.getX() + 1, upperLeft.getY() + 1, width - 1, sideLength - 1);
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.drawRect(upperLeft.getX(), upperLeft.getY(), width, sideLength);
		fill(g);
		if (isSelected())
			selected(g);
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
}
