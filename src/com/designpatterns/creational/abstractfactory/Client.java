package com.designpatterns.creational.abstractfactory;

import org.apache.log4j.Logger;

import com.designpattern.utilities.Log4jUtils;

public class Client {
	static Logger logger = Logger.getLogger(Client.class.getName());

	public static void main(String[] args) {
		logger = Log4jUtils.initLog4j();
		AbstractFactory mFactory1 = new Factory1();
		AbstractFactory mFactory2 = new Factory2();
		mFactory1.createAbstractProductA().method();
		mFactory1.createAbstractProductB().method();
		mFactory2.createAbstractProductB().method();
		mFactory2.createAbstractProductA().method();
	}
}
