package com.designpatterns.gof.structural.decorator;

class SimpleCoffee extends Coffee {

  public double getCost() {
    return 1;
  }

  public String getIngredients() {
    return "SimpleCoffee";
  }
}