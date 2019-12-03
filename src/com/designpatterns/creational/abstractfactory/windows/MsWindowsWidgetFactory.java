package com.designpatterns.creational.abstractfactory.windows;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */

// ConcreteFactory1
public class MsWindowsWidgetFactory implements AbstractWidgetFactory{
	// create an MSWindow
	public Window createWindow() {
		MSWindow window = new MSWindow();
		return window;
	}
}