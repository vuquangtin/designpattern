package com.designpatterns.gof.behavioral.visitor;

abstract class Visitor {

  public String visit(Figure figure) {
    return figure.getName();
  }

  abstract String visit(Square figure);

  abstract String visit(Circle figure);
}