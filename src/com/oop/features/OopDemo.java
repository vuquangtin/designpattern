package com.oop.features;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class OopDemo {

	public static void main(String[] args) {
		Cat cat = new Cat("Tom");
		Dog dog = new Dog("Milu");

		Zoo zoo = new Zoo();
		zoo.add(cat);
		zoo.add(dog);
		zoo.showListAnimal();
	}

}