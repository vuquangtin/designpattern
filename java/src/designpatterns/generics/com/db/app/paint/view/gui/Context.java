package com.db.app.paint.view.gui;

import java.awt.Graphics;

import com.db.app.paint.model.interfaces.IShape;

public class Context {
	private IShape ishape;
	public Context(IShape ishape){
		this.ishape = ishape;
	}
	
	public void executeStrategy(Graphics g){
		ishape.draw(g);
	}
}
