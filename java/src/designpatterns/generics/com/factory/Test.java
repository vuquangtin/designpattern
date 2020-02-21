package com.factory;

import java.util.Date;

interface Handler<T> {

	void handle(T obj);
}

class StringHandler implements Handler<String> {

	@Override
	public void handle(String str) {
		System.out.println(str);
	}
}

class DateHandler implements Handler<Date> {

	@Override
	public void handle(Date date) {
		System.out.println(date);
	}
}

class HandlerFactory {

	enum ValidHandler {

		String {
			@Override
			Handler<String> make() {
				return new StringHandler();
			}
		},
		Date {
			@Override
			Handler<Date> make() {
				return new DateHandler();
			}
		};

		abstract <T> Handler<T> make();
	}

	public <T> Handler<T> getHandler(Class<T> clazz) {
		if (clazz == String.class) {
			return ValidHandler.String.make();
		}
		if (clazz == Date.class) {
			return ValidHandler.Date.make();
		}
		return null;
	}
}

class HandlerFactory2 {
	public <T> Handler<T> getHandler(Class<T> clazz) {
		if (clazz.equals(String.class))
			return (Handler<T>) new StringHandler();
		if (clazz.equals(Date.class))
			return (Handler<T>) new DateHandler();

		return null;
	}
}

public class Test {
	public static void main(String[] args) {
		HandlerFactory factory = new HandlerFactory();
		Handler<String> stringHandler = factory.getHandler(String.class);
		stringHandler.handle("handler");
		Handler<Date> dateHandler = factory.getHandler(Date.class);
		dateHandler.handle(new Date());
		
		HandlerFactory2 factory2 = new HandlerFactory2();
		Handler<String> stringHandler2 = factory2.getHandler(String.class);
		stringHandler2.handle("handler");
		Handler<Date> dateHandler2 = factory2.getHandler(Date.class);
		dateHandler2.handle(new Date());
	}

}
