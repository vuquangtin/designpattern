package com.designpatterns.behavioral.visitor;
/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class Wizard implements Human {
    public void hit(Monster monster) {
        System.out.println("Avada Kedavra! ⚡");
        monster.damaged(10);
    }
}
