package com.designpatterns.gof.behavioral.chain_of_responsibility;

public class ApplicationLog extends Chain {

  public ApplicationLog() {
    super.priority = Chain.ERR_APPLICATION;
  }

  public String writeMessage() {
    return "Application error logged";
  }
}