package com.designpatterns.gof.creational.factory_method;


class LimitedCreator extends Creator {

  public Product factoryMethod() {
    return new LimitedProduct();
  }
}