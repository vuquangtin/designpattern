package observers.gof;

abstract class Observer {

  protected String observedState;
  protected Subject observed;

  public Observer(Subject observed) {
    this.observed = observed;
    this.observed.registerObserver(this);
  }

  public abstract void update();
}