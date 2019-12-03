package com.designpatterns.gof.behavioral.iterator;

class ConcreteCompound extends Compound {

  private String word;

  public ConcreteCompound(String word) {
    this.word = word;
  }

  public Iterator getIterator() {
    return new ConcreteIterator(word);
  }
}