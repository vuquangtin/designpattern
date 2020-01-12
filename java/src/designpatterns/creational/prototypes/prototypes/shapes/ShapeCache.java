package prototypes.shapes;

import java.util.Hashtable;
/**
 * <h1>Prototype</h1> Xác định các kiểu của các object (đối tượng) muốn tạo ra
 * bằng cách sử dụng một prototype (khuôn mẫu,nguyên mẫu), và tạo ra những
 * object (đối tượng) mới bằng cách sao chép prototype này.
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/designpattern">https://github.com
 *      /vuquangtin/designpattern</a>
 *
 */
public class ShapeCache {

  private static Hashtable<String, Shape> shapeMap = new Hashtable<String, Shape>();

  public static Shape getShape(String shapeId) {
    Shape cachedShape = shapeMap.get(shapeId);
    return (Shape) cachedShape.clone();
  }

  // for each shape run database query and create shape
  // shapeMap.put(shapeKey, shape);
  // for example, we are adding three shapes

  public static void loadCache() {
    Circle circle = new Circle();
    circle.setId(ShapeType.CIRCLE.getId());
    shapeMap.put(circle.getId(), circle);

    Square square = new Square();
    square.setId(ShapeType.SQUARE.getId());
    shapeMap.put(square.getId(), square);

    Rectangle rectangle = new Rectangle();
    rectangle.setId(ShapeType.RECTANGLE.getId());
    shapeMap.put(rectangle.getId(), rectangle);
  }
}
