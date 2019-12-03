package com.designpatterns.creational.abstractfactory.woods;
/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */

public class Client {

   public static void main(String[] args) {

       FurnitureAbstractFactory factory = FurnitureFactory.getFactory(MaterialType.FLASTIC);

       Chair chair = factory.createChair();
       chair.create(); // Create plastic chair

       Table table = factory.createTable();
       table.create(); // Create plastic table
   }
}