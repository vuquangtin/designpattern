package open_closed2;

import java.util.ArrayList;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class Main {
	public void draw(ArrayList<Shape> shapeList) {
		Line line;
		Rectangle rectangle;

		for (Shape shape : shapeList)
			switch (shape.getType()) {
			case LINE:
				line = (Line) shape;
				line.drawLine();
				break;
			case RECTANGLE:
				rectangle = (Rectangle) shape;
				rectangle.drawRectangle();
				break;
			}
	}
}
