package com.designpatterns.creational.abstractfactory.windows;
/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class LinuxWidgetFactory implements AbstractWidgetFactory {

	@Override
	public Window createWindow() {
		LinuxOSWindow window = new LinuxOSWindow();
		return window;
	}

}
