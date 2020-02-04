package decorators.shapes;
/**
 * <h1>Decorator</h1> Gán bổ sung các “trách nhiệm” (responsibility) cho một đối
 * tượng một cách linh hoạt. Các decorator cung cấp một sự lựa chọn linh động
 * cho lớp con để mở rộng tính năng
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
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
