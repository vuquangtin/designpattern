package com.designpatterns.gof.structural.proxy;

abstract class File {

  protected boolean isProtected = true;

  public abstract String read();

  public void setProtection(boolean isProtected) {
    this.isProtected = isProtected;
  }
}