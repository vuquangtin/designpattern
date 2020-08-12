package com.db.app.paint.model.interfaces;

import java.awt.Color;
import java.awt.Graphics;

import com.db.app.paint.models.ShapeShadingType;

public interface IShape {
	public void draw(Graphics g); 
	public int getX();
	public int getY();
	public int getX2();
	public int getY2();
	public void setX(int x);
	public void setY(int y);
	public void setX2(int x2);
	public void setY2(int y2);
	public Graphics getG();
	public void setG(Graphics g);
	public ShapeShadingType getSst();
	public void setSst(ShapeShadingType sst);
	public Color getContextColor();
	public void setContextColor(Color contextColor);
	public Color getSecColor();
	public void setSecColor(Color secColor);
}
