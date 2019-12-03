package com.designpatterns.gof.structural.class_adapter;

class AdapterRectangle extends Rectangle implements Figure {

  public String draw() {
    return this.drawRectangle();
  }
}