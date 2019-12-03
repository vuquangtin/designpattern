package com.designpatterns.gof.behavioral.memento;

class Memento {

  private final String STATE;

  public Memento(String state) {
    STATE = state;
  }

  public String getSavedState() {
    return STATE;
  }
}