package com.db.app.paint.view.gui;

import java.awt.Color;
import java.awt.Graphics;

import com.db.app.paint.model.interfaces.IShape;
import com.db.app.paint.models.ShapeShadingType;

public class Rectangle implements IShape{
	
	private Graphics g;
	private int x;
	private int y;
	private int x2;
	private int y2;
	private ShapeShadingType sst;
	private Color contextColor;
	private Color secColor;
	
	public Rectangle(Graphics g, int x, int y, int x2, int y2, ShapeShadingType shapeShadingType,
			Color contextColor, Color secColor){
		this.g = g;
		this.x =x;
		this.y = y;
		this.x2 =x2;
		this.y2 = y2;
		this.sst = shapeShadingType;
		this.contextColor = contextColor;
		this.secColor = secColor;
	}

	
	public void draw(Graphics g) {
		
		int px = Math.min(x, x2);
		int py = Math.min(y, y2);
		int pw = Math.abs(x - x2);
		int ph = Math.abs(y - y2);
		if(sst.name().equals("FILLED_IN")){
			g.setColor(contextColor);
			g.fillRect(px, py, pw, ph);
		}
		else if(sst.name().equals("OUTLINE")){
			g.setColor(contextColor);
			g.drawRect(px, py, pw, ph);
		}
		else{
			g.setColor(contextColor);
			g.fillRect(px,py,pw,ph);
			g.setColor(secColor);
			g.drawRect(px, py, pw, ph);
		}
	} 
	
	@Override
	public Graphics getG() {
		return g;
	}
	@Override
	public int getX() {
		return x;
	}
	@Override
	public int getY() {
		return y;
	}
	@Override
	public int getX2() {
		return x2;
	}
	@Override
	public int getY2() {
		return y2;
	}
	@Override
	public void setG(Graphics g) {
		this.g = g;
	}
	@Override
	public ShapeShadingType getSst() {
		return sst;
	}
	@Override
	public void setSst(ShapeShadingType sst) {
		this.sst = sst;
	}
	@Override
	public Color getContextColor() {
		return contextColor;
	}
	@Override
	public void setContextColor(Color contextColor) {
		this.contextColor = contextColor;
	}
	@Override
	public Color getSecColor() {
		return secColor;
	}
	@Override
	public void setSecColor(Color secColor) {
		this.secColor = secColor;
	}
	@Override
	public void setX(int x) {
		this.x = x;
	}
	@Override
	public void setY(int y) {
		this.y = y;
	}
	@Override
	public void setX2(int x2) {
		this.x2 = x2;
	}
	@Override
	public void setY2(int y2) {
		this.y2 = y2;
	}
}
