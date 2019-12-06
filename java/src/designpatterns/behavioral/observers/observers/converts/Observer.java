package observers.converts;

public abstract class Observer {
  protected Subject subject;

  public abstract void update();
}
