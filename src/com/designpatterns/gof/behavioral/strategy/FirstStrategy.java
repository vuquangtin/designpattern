package com.designpatterns.gof.behavioral.strategy;

class FirstStrategy extends Strategy {

  public String algorithm() {
    return doSomething() + " then " + doSomethingElse();
  }

  private String doSomething() {
    return "Do something";
  }

  private String doSomethingElse() {
    return "Do something else";
  }
}