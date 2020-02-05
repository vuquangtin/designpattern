package composites.shapes;

import java.awt.Color;
/**
 * <h1>Composite</h1> Các đối tượng cấu thành các cấu trúc cây để mô tả bán toàn
 * bộ hệ thống phần cấp. Composite để cho các client tác động các đối tượng
 * riêng biệt và các thành phần của đối tượng một cách thống nhất.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class Demo {
	public static void main(String[] args) {
		ImageEditor editor = new ImageEditor();

		editor.loadShapes(new Circle(10, 10, 10, Color.BLUE),

				new CompoundShape(new Circle(110, 110, 50, Color.RED), new Dot(160, 160, Color.RED)),

				new CompoundShape(new Rectangle(250, 250, 100, 100, Color.GREEN), new Dot(240, 240, Color.GREEN),
						new Dot(240, 360, Color.GREEN), new Dot(360, 360, Color.GREEN),
						new Dot(360, 240, Color.GREEN)));
	}
}