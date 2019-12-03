package com.designpatterns.gof.structural.proxy;

/**
 * Design Patterns
 * 
 * @see http://www.itsenka.com/contents/development/designpattern/proxy.html
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class GOF {
	public static void main(String[] args) {
		Subject sub = new Proxy();
		sub.request1("AAA");
		sub.request2();
		sub.request3();
	}
}

// 1. Subject.java
abstract class Subject {
	protected String name;

	public abstract void request1(String name);

	public abstract void request2();

	public abstract void request3();
}

// /2. Proxy.java
class Proxy extends Subject {
	RealSubject realSubject;

	public void request1(String name) {
		System.out.println("代理：Proxy-r1()");
		super.name = name;
	}

	public void request2() {
		if (realSubject == null) {
			System.out.println("代理：Proxy-r2()");
		} else {
			realSubject.request2();
		}
	}

	public void request3() {
		System.out.println("代理：Proxy-r3()");
		if (realSubject == null) {
			realSubject = new RealSubject();
			realSubject.request1(name);
		}
		realSubject.request3();
	}
}

// 3. RealSubject.java
class RealSubject extends Subject {
	public void request1(String name) {
		System.out.println("本人：RealSubject-r1()");
		super.name = name;
	}

	public void request2() {
		System.out.println("本人：RealSubject-r2()");
	}

	public void request3() {
		System.out.println("本人：RealSubject[" + name + "]-r3()");
	}
}