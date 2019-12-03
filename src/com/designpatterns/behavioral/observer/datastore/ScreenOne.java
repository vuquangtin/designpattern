package com.designpatterns.behavioral.observer.datastore;

import java.util.Observer;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class ScreenOne implements Observer {
	private static final String TAG = ScreenOne.class.getSimpleName();

	@Override
	public void update(java.util.Observable o, Object arg) {
		System.out.println(TAG + "Observable: " + o + ", Object: " + arg);
		if (arg instanceof DataStore) {
			DataStore dataStore = (DataStore) arg;
			System.out.println(dataStore.getData());
		}
	}

}