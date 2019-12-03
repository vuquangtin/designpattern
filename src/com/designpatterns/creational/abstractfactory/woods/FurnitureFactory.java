package com.designpatterns.creational.abstractfactory.woods;
/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */

public class FurnitureFactory {

   private FurnitureFactory() {

   }

   // Returns a concrete factory object that is an instance of the
   // concrete factory class appropriate for the given architecture.
   public static FurnitureAbstractFactory getFactory(MaterialType materialType) {
       switch (materialType) {
       case FLASTIC:
           return new FlasticFactory();
       case WOOD:
           return new WoodFactory();
       default:
           throw new UnsupportedOperationException("This furniture is unsupported ");
       }
   }
}