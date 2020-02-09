package com.app.game.fruitninjar.view;

import javax.swing.JPanel;

// ViewPanel extends JPanel which contain 
// viewFrame and add panel to frame
/**
 * <h1>Desktop-Fruit-Ninja-App</h1>This is Desktop Fruit Ninjar App using Java programming language. 
 *Used MVC architecture pattern, singleton, strategy and factory design pattern.
 *Stored user data in Amazon SimpleDB and showed user information by update HTML file stored in Amazon S3
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
@SuppressWarnings("serial")
public class ViewPanel extends JPanel{
	protected ViewFrame gmf;
	public ViewPanel(){
	    gmf = new ViewFrame();
		gmf.getContentPane().add(this);
	}
	
}