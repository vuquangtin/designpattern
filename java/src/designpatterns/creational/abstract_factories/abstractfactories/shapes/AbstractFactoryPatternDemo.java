package abstractfactories.shapes;

/**
 * <h1>Abstract Factory</h1> Cung cấp một interface để tạo ra 1 họ các object
 * (đối tượng) có liên quan hoặc phụ thuộc lẫn nhau mà không chỉ rõ các lớp cụ
 * thể của chúng (concrete classes)
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/designpattern">https://github.com
 * 
 *      /vuquangtin/designpattern</a>
 *
 */
public class AbstractFactoryPatternDemo {

	public static void main(String[] args) {

		AbstractFactory shapeFactory = FactoryProducer.getFactory(ShapeFactory.SHAPE);

		Shape s1 = shapeFactory.getShape(ShapeFactory.CIRCLE);
		s1.draw();

		Shape s2 = shapeFactory.getShape(ShapeFactory.RECTANGLE);
		s2.draw();

		Shape s3 = shapeFactory.getShape(ShapeFactory.SQUARE);
		s3.draw();
		
		
		AbstractFactory colorFactory = FactoryProducer.getFactory(ColorFactory.COLOR);

		Color c1 = colorFactory.getColor(ColorFactory.BLUE);
		c1.fill();

		Color c2 = colorFactory.getColor(ColorFactory.GREEN);
		c2.fill();

		Color c3 = colorFactory.getColor(ColorFactory.RED);
		c3.fill();

	}

}