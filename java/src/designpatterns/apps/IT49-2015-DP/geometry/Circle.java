package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends SurfaceShape {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int radius;
	private Point center;

	public Circle() {

	}

	public Circle(int radius, Point center) {
		this.radius = radius;
		this.center = center;
	}

	public Circle(int radius, Point center, Color color) {

		this.radius = radius;
		this.center = center;
		setColor(color); // pozivamo metodu iz apstraktne klase oblik
	}

	public Circle(int radius, Point center, Color color, Color innerColor) {
		this(radius, center, color);
		setInnerColor(innerColor); // pozivamo metodu iz apstraktne klase povrsinski oblik
	}

	public void moveTo(int x, int y) {
		center.moveTo(x, y);
	}

	public void moveBy(int poX, int poY) {
		center.moveBy(poX, poY);
	}

	public String toString() {
		return "Circle:Center(" + center.getX()+","+center.getY() + ") Radius(" + radius + ") "+getColor()+" "+getInnerColor();
	}

	public double area() {
		return radius * radius * Math.PI;
	}

	public double perimeter() {
		return 2 * radius * Math.PI;
	}

	public boolean equals(Object obj) {
		if (obj instanceof Circle) {
			Circle c = (Circle) obj;
			if (center.equals(c.getCenter()) && radius == c.getRadius()) {
				return true;
			} else
				return false;
		}
		return false;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public Point getCenter() {
		return center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}

	public void draw(Graphics g) {
		fill(g);
		g.setColor(getColor());
		g.drawOval(center.getX() - radius, center.getY() - radius, 2 * radius, 2 * radius);

		if (isSelected())
			selected(g);
	}

	public void selected(Graphics g) {
		g.setColor(Color.BLACK);
		new Line(new Point(getCenter().getX() + radius, getCenter().getY()),
				new Point(getCenter().getX() - radius, getCenter().getY())).selected(g);
		new Line(new Point(getCenter().getX(), getCenter().getY() + radius),
				new Point(getCenter().getX(), getCenter().getY() - radius)).selected(g);

	}

	public int compareTo(Object o) {
		if (o instanceof Circle) {
			return (int) (this.radius - ((Circle) o).radius);

		} else
			return 0;
	}

	public void fill(Graphics g) {
		g.setColor(getInnerColor());
		g.fillOval(center.getX() - radius + 1, center.getY() - radius + 1, 2 * radius - 2, 2 * radius - 2);
	}

	public boolean contains(int x, int y) {
		if (new Point(x, y).distance(getCenter()) <= radius)
			return true;
		else
			return false;
	}

	@Override
	public Shape clone() {
		Circle c = new Circle();

		c.setCenter(new Point(this.getCenter().getX(), this.getCenter().getY()));

		c.setRadius(this.getRadius());
		c.setColor(this.getColor());
		c.setInnerColor(this.getInnerColor());

		return c;
	}
}
