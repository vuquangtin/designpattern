package com.db.app.paint.view.gui;

import java.awt.Color;
import java.awt.Graphics;

import com.db.app.paint.model.interfaces.IShape;
import com.db.app.paint.models.ShapeShadingType;

public class Polygon implements IShape{
	
	private Graphics g;

	
	private int x;
	private int y;
	private int x2;
	private int y2;
	private ShapeShadingType sst;
	private Color contextColor;
	private Color secColor;
	public Polygon(Graphics g, int x, int y, int x2, int y2, ShapeShadingType shapeShadingType,
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
		int qx = 0, rx= 0, qy= 0, ry= 0;
		int px = Math.min(x, x2);
		int py = 0;
		if(px == x){
			py = y;
			qx = x2;
			qy = y;
			rx = Math.max(x, x2);
			ry = y2;
		}
		else if(px == x2){
			py = y;
			qx = x;
			qy = y2;
			rx = x2;
			ry = y2;
		}
		
		int [] arrayX = {qx,px,rx};
		int [] arrayY = {qy,py,ry};
		if(sst.name().equals("FILLED_IN")){
			g.setColor(contextColor);
			g.fillPolygon(arrayX, arrayY, 3);
		}
		else if(sst.name().equals("OUTLINE")){
			g.setColor(contextColor);
			g.drawPolygon(arrayX, arrayY, 3);
		}
		else{
			g.setColor(contextColor);
			g.fillPolygon(arrayX, arrayY, 3);
			g.setColor(secColor);
			g.drawPolygon(arrayX, arrayY, 3);
		}
		
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
	@Override
	public Graphics getG() {
		return g;
	}

	@Override
	public void setG(Graphics g) {
		this.g= g;
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

}
