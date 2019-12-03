package com.designpatterns.gof.behavioral.mediator;

abstract class Partner {

  protected Mediator mediator;

  public Partner(Mediator mediator) {
    this.mediator = mediator;
  }
}