package decorators.shapes;

public abstract class ShapeDecorator implements Shape {
  protected Shape decoratedShape;

  public ShapeDecorator(Shape decoratedShape) {
    this.decoratedShape = decoratedShape;
  }

  // this is just indicator purpose
  @Override
  public void draw() {
    decoratedShape.draw();
  }
}
