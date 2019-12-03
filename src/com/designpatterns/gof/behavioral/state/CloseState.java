package com.designpatterns.gof.behavioral.state;

class CloseState extends State {

  public void request(Context context) {
    context.setState(new OpenState());
  }

  public String toString() {
    return "Close State";
  }
}