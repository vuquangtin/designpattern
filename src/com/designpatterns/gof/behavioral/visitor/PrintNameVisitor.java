package com.designpatterns.gof.behavioral.visitor;

public class PrintNameVisitor extends Visitor {

  public String visit(Circle figure) {
    return figure.getName();
  }

  public String visit(Square figure) {
    return figure.getName();
  }
}