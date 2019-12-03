package com.designpatterns.gof.behavioral.chain_of_responsibility;

/**
 * Design Patterns
 * 
 * @see http://www.itsenka.com/contents/development/designpattern/chain_of_responsibility.html
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class GOF {
	public static void main(String[] args) {
		Handler hand1 = new ConcreteHandlerA("A", 1, 10);
		Handler hand2 = new ConcreteHandlerA("B", 11, 20);
		Handler hand3 = new ConcreteHandlerA("C", 21, 30);
		Handler hand11 = new ConcreteHandlerB("D");
		hand1.setNext(hand2).setNext(hand3).setNext(hand11); // 責任のチェーンを構築
		hand1.request(31);
	}
}

abstract class Handler {
	protected String name;
	protected Handler next;

	public Handler(String name) {
		this.name = name;
	}

	public Handler setNext(Handler handler) {
		this.next = handler;
		return handler;
	}

	public abstract void request(int req);
}

class ConcreteHandlerA extends Handler {
	private int rangeS;
	private int rangeE;

	public ConcreteHandlerA(String name, int rangeS, int rangeE) {
		super(name);
		this.rangeS = rangeS;
		this.rangeE = rangeE;
	}

	public void request(int req) {
		if (req >= rangeS && req <= rangeE) {
			System.out.println(name + "：私が成敗してくれるわ!");
		} else if (next != null) {
			System.out.println(name + "：私では無理じゃ!次の者出合えー");
			next.request(req);
		} else {
			System.out.println(name + "：次の者がおりませぬー");
		}
	}
}

class ConcreteHandlerB extends Handler {
	public ConcreteHandlerB(String name) {
		super(name);
	}

	public void request(int req) {
		if (req % 2 == 0) {
			System.out.println(name + "：ようこそ!偶数は私のテリトリーです。");
		} else if (next != null) {
			System.out.println(name + "：無念!偶数以外は・・・!次の方お願いします。");
			next.request(req);
		} else {
			System.out.println(name + "：無念!偶数以外は・・・!次もいないー");
		}
	}
}