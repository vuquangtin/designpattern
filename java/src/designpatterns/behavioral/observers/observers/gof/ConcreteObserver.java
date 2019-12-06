package observers.gof;

class ConcreteObserver extends Observer {

  public ConcreteObserver(Subject observed) {
    super(observed);
  }

  public void update() {
    observedState = observed.getState();
  }

  public String toString() {
    return observedState;
  }
}