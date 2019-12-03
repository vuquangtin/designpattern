package com.designpatterns.gof.behavioral.memento.gof;

import java.util.Stack;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
// public class GOF {
//
// }
class Originator {
	private int param1;
	private String param2;

	public Originator(int param1, String param2) {
		this.param1 = param1;
		this.param2 = param2;
	}

	public void calcAdd(int addNum) {
		param1 += addNum;
	}

	public void concat(String addStr) {
		param2 = param2 + addStr;
	}

	public Memento createMemento() {
		return new Memento(param1, param2);
	}

	public void setMemento(Memento memento) {
		this.param1 = memento.param1;
		this.param2 = memento.param2;
	}

	public String toString() {
		return "param1=>" + param1 + " / param2=>" + param2;
	}
}

class Memento {
	int param1;
	String param2;

	Memento(int param1, String param2) {
		this.param1 = param1;
		this.param2 = param2;
	}
}

public class Caretaker {
	static Stack<Memento> mementoList = new Stack<Memento>();

	public static void main(String[] args) {
		Originator originator = new Originator(0, "");
		for (int i = 0; i < 5; i++) {
			for (int j = i; j < i + 5; j++) {
				originator.calcAdd(j);
				originator.concat(Integer.toString(j));
			}
			mementoList.push(originator.createMemento());
		}
		originator.calcAdd(5);
		originator.concat(Integer.toString(5));
		System.out.println(originator);
		while (mementoList.size() != 0) {
			Memento memento = (Memento) mementoList.pop();
			originator.setMemento(memento);
			System.out.println(originator);
		}
	}
}