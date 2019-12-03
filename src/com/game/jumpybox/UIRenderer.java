package com.game.jumpybox;

import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class UIRenderer extends JPanel {
	private static final long serialVersionUID = 1L;

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		JumpyBox.jumpyBox.repaint(g);
	}
}
