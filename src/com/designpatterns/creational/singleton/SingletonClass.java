package com.designpatterns.creational.singleton;

public class SingletonClass {
	private SingletonClass() {

	}

	private static class Single {
		private static final SingletonClass INSTANCE = new SingletonClass();
	}

	public static SingletonClass getInstance() {

		return Single.INSTANCE;
	}
}
