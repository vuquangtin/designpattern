package com.designpatterns.others.lazyloading.valueholder;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class ValueHolder {
	private Object value;
	private ValueLoader loader;

	public ValueHolder(ValueLoader loader) {
		this.loader = loader;
	}

	public Object getValue() {
		if (value == null)
			value = loader.load();
		return value;
	}
}