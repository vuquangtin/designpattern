package com.designpatterns.behavioral.observer.datastore;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class ObserverDemo {
	public static void main(String[] args) {
		ScreenOne screenOne = new ScreenOne();
		ScreenTwo screenTwo = new ScreenTwo();
		ScreenThree screenThree = new ScreenThree();

		DataStore dataStore = new DataStore();

		dataStore.addObserver(screenOne); // add screenOne in list Observer.
		dataStore.addObserver(screenTwo); // add screenTwo in list Observer.
		dataStore.addObserver(screenThree); // add screenThree in list Observer.

		dataStore.setData("Sieu Dao Chich Code"); // make data change.

		dataStore.notifyObservers(dataStore);// send update to all Observer with
												// Data.

	}
}