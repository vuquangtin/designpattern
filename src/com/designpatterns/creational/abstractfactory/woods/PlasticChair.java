package com.designpatterns.creational.abstractfactory.woods;
/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */

public class PlasticChair implements Chair {
   @Override
   public void create() {
       System.out.println("Create plastic chair");
   }
}