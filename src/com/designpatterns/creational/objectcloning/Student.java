package com.designpatterns.creational.objectcloning;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class Student {
	int id;
	String name;

	Student() {

	}

	Student(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public void show() {
		System.out.println("Student [id=" + id + ", name=" + name + "]");
	}
}