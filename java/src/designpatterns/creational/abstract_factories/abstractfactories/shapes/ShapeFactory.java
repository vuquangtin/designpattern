package abstractfactories.shapes;
/**
 * <h1>Abstract Factory</h1> Cung cấp một interface để tạo ra 1 họ các object
 * (đối tượng) có liên quan hoặc phụ thuộc lẫn nhau mà không chỉ rõ các lớp cụ
 * thể của chúng (concrete classes)
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com

 *      /vuquangtin/designpattern</a>
 *
 */
public class ShapeFactory extends AbstractFactory{
	
	public static final String CIRCLE = "circle";
	public static final String RECTANGLE = "rectangle";
	public static final String SQUARE = "square";
	public static final String SHAPE = "shape";
	
	@Override
	public Shape getShape(String shapeType){
		
		if(shapeType == null){
			return null;
		} else if( shapeType.equalsIgnoreCase( CIRCLE )){
			return new Circle();
		} else if( shapeType.equals(RECTANGLE)) {
			return new Rectangle();
		} else if( shapeType.equals( SQUARE)) {
			return new Square();
		} 
		return null;
	}

	@Override
	Color getColor(String color) {
		return null;
	}
	
	
}