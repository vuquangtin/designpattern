package mementos.gof;

class Originator {

  private String state;

  public void setState(String state) {
    this.state = state;
  }

  public Memento saveToMemento() {
    return new Memento(state);
  }

  public void restoreFromMemento(Memento memento) {
    state = memento.getSavedState();
  }

  public String toString() {
    return state;
  }
}