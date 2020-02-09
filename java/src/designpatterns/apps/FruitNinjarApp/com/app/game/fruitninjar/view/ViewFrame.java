package com.app.game.fruitninjar.view;

import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

// this class generate a basic JFrame for this game
// it contains a JPanel which later draw fruits on
// and define a basic Layout: BorderLayout
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
 */
@SuppressWarnings("serial")
public class ViewFrame extends JFrame {

	private JPanel contentPane;
	private BorderLayout borderLayout1 = new BorderLayout();

	// init the frame
	public ViewFrame() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		enableEvents(AWTEvent.WINDOW_EVENT_MASK);
		this.setUndecorated(true);
		try {
			initialize();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Component initialization
	private void initialize() throws Exception {
		contentPane = (JPanel) this.getContentPane();
		contentPane.setLayout(borderLayout1);
	}

	// check the closed window request
	protected void processWindowEvent(WindowEvent e) {
		super.processWindowEvent(e);
		if (e.getID() == WindowEvent.WINDOW_CLOSING) {
			System.exit(0);
		}
	}
}