package com.designpatterns.creational.abstractfactory.windows;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
// ConcreteFactory2
public class MacOSXWidgetFactory implements AbstractWidgetFactory {
	// create a MacOSXWindow
	public Window createWindow() {
		MacOSXWindow window = new MacOSXWindow();
		return window;
	}
}
