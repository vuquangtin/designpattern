package com.designpatterns.behavioral.command;
/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class Stock {

    

	   private String name = "ABC";

	   private int quantity = 10;


	   public void buy(){

	      System.out.println("Stock [ Name: "+name+", Quantity: " + quantity +" ] bought");

	   }

	   public void sell(){

	      System.out.println("Stock [ Name: "+name+", Quantity: " + quantity +" ] sold");

	   }

	}