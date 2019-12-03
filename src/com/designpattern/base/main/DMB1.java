package com.designpattern.base.main;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
// DMB1.javaclass
class SuperClass {
	void method() {
		System.out.println("Superclass method");
	}
}

class SubClass extends SuperClass {
	void method() {
		System.out.println("Subclass method");
	}
}

class DMB1 {
	public static void main(String[] args) {
		Superclass sc = new Superclass();
		sc.method();
		sc = new Subclass();
		sc.method();
	}
}
