package com.designpatterns.gof.structural.object_adapter;

class AdapterRectangle implements Figure {

  private Rectangle rectangle = new Rectangle();

  public String draw() {
    return rectangle.drawRectangle();
  }
}
