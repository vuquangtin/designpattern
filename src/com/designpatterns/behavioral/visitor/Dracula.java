package com.designpatterns.behavioral.visitor;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class Dracula implements Monster {

	public void hitBy(Warrior warrior) {
		damaged(10);
	}

	public void hitBy(Wizard wizard) {
		damaged(80);
	}

	public void damaged(int hp) {
		System.out.println("Owie! I lost " + hp + "hp ᙙᙖ");
	}

}
