package com.designpatterns.gof.structural.adapter.isa;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class Client {
	public static void main(String[] args) {
		Target target = new Adapter();
		target.targetMethod1();
		target.targetMethod2();
	}
}

interface Target {
	public abstract void targetMethod1();

	public abstract void targetMethod2();
}

class Adaptee {
	public void method1() {
		System.out.println("method1");
	}

	public void method2() {
		System.out.println("method2");
	}
}

class Adapter extends Adaptee implements Target {
	public void targetMethod1() {
		method1();
	}

	public void targetMethod2() {
		method2();
	}
}