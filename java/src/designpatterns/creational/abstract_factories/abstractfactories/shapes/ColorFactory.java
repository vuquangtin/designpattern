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
public class ColorFactory extends AbstractFactory {

	public static final String RED = "red";
	public static final String BLUE = "blue";
	public static final String GREEN = "green";
	public static final String COLOR = "color";
	
	@Override
	Color getColor(String color) {

		if (color == null){
			return null;
		} else if ( color.equals(RED)){
			return new Red();
		} else if(color.equals(BLUE)){
			return new Blue();
		} else if( color.equals(GREEN)){
			return new Green();
		}
		return null;
	}

	@Override
	Shape getShape(String shape) {
		return null;
	}

}