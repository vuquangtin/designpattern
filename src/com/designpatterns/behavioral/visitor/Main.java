package com.designpatterns.behavioral.visitor;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class Main {
	public static void main(String[] args) {
//		Human warrior = new Warrior();
//		Human wizard = new Wizard();
//
//		Monster monster = new CuteDogie();
//
//		warrior.hit(monster);
//		wizard.hit(monster);
		Human warrior = new Warrior();
		Human wizard = new Wizard();

		Monster dogie = new CuteDogie();
		Monster dracula = new Dracula();

		warrior.hit(dogie);
		wizard.hit(dogie);

		warrior.hit(dracula);
		wizard.hit(dracula);
	}
}

