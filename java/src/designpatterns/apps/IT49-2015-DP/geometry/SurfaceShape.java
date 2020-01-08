package geometry;

import java.awt.Color;
import java.awt.Graphics;

public abstract class SurfaceShape extends Shape {
	
	private Color innerColor = Color.WHITE;
	
	public abstract double area();
	public abstract double perimeter();
	public abstract void fill(Graphics g);

	public Color getInnerColor() {
		return innerColor;
	}

	public void setInnerColor(Color innerColor) {
		this.innerColor = innerColor;
	}

	
	
}
