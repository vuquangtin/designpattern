package com.designpatterns.creational.objectpool;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class OliphauntPool extends ObjectPool<Oliphaunt> {

	@Override
	protected Oliphaunt create() {
		return new Oliphaunt();
	}
}