package mediators.gof1;

abstract class Partner {

  protected Mediator mediator;

  public Partner(Mediator mediator) {
    this.mediator = mediator;
  }
}