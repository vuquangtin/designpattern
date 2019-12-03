package com.designpatterns.others.lazyloading.lazyinitialization;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class Program {
	public static void main(String[] args) {
		Car.getCarByTypeName(CarType.BMW);
		Car.showAll();
		Car.getCarByTypeName(CarType.Audi);
		Car.showAll();
		Car.getCarByTypeName(CarType.BMW);
		Car.showAll();
	}
}