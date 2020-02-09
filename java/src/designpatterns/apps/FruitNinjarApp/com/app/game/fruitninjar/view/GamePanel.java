package com.app.game.fruitninjar.view;

import java.awt.Dimension;
import java.awt.Image;

import com.app.game.fruitninjar.controller.MouseMovement;

// gamePanel is child class of ViewPanel, 
// it is used to draw fruits
// it contain a moustMotionListener
/**
 * <h1>Desktop-Fruit-Ninja-App</h1>This is Desktop Fruit Ninjar App using Java
 * programming language. Used MVC architecture pattern, singleton, strategy and
 * factory design pattern. Stored user data in Amazon SimpleDB and showed user
 * information by update HTML file stored in Amazon S3
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/designpattern">https://github.com
 *      /vuquangtin/designpattern</a>
 *
 */

@SuppressWarnings("serial")
public class GamePanel extends ViewPanel {
	public static final int WIDTH = 800;
	public static final int LENGTH = 800;
	private MouseMovement mouseMovement;

	public GamePanel(MouseMovement mouseMovement) {
		super();
		gmf.pack();
		// set the size of panel
		Dimension dim = new Dimension(WIDTH, LENGTH);
		gmf.setSize(dim);
		// set the title of panel
		gmf.setTitle("Fruit Ninja");
		// set the left corner position of panel
		gmf.setLocation(30, 30);
		gmf.setResizable(false);
		// add mouseMotionListener
		this.mouseMovement = mouseMovement;
		gmf.setVisible(true);
		this.addMouseMotionListener(mouseMovement);
		this.setFocusable(true);
	}

	// draw all fruits in view
	public void draw(Image buffImage) {
		this.getGraphics().drawImage(buffImage, 0, 0, WIDTH, LENGTH, null);
	}

	public MouseMovement getMouseMovement() {
		return mouseMovement;
	}

	public void setMouseMovement(MouseMovement mouseMovement) {
		this.mouseMovement = mouseMovement;
	}
}
