package com.designpatterns.creational.singleton;

public class SingletonEhan {

	private SingletonEhan() {

	}

	private static SingletonEhan singletonEhan = new SingletonEhan();

	public static SingletonEhan getInstance() {

		return singletonEhan;
	}
}