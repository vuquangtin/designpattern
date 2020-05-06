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
public class FactoryPatternDemo {

	public static void main(String[] args) {

		ShapeFactory factory = new ShapeFactory();

		Shape s1 = factory.getShape(ShapeFactory.CIRCLE);
		s1.draw();

		Shape s2 = factory.getShape(ShapeFactory.RECTANGLE);
		s2.draw();

		Shape s3 = factory.getShape(ShapeFactory.SQUARE);
		s3.draw();

	}

}