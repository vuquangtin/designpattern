package abstractfactories.reflect.shapes;
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
public abstract class AbstractFactory {
    /**
     * 形状工厂类(包名+类名)
     */
    public static final String SHAPEFACTORY = ShapeFactory.class.getName();
    /**
     * 颜色工厂类(包名+类名)
     */
    public static final String COLORFACTORY = ColorFactory.class.getName();

    /**
     * 圆角矩形类名称(包名+类名)
     */
    public static final String RECTANGLE = Rectangle.class.getName();
    /**
     * 矩形类名称(包名+类名)
     */
    public static final String SQUARE = Square.class.getName();
    /**
     * 圆形类名称(包名+类名)
     */
    public static final String CIRCLE = Circle.class.getName();
    /**
     * 红色类名称(包名+类名)
     */
    public static final String RED = Red.class.getName();
    /**
     * 绿色类名称(包名+类名)
     */
    public static final String GREEN = Green.class.getName();
    /**
     * 蓝色类名称(包名+类名)
     */
    public static final String BLUE = Blue.class.getName();

    public abstract Color getColor(String color);

    public abstract Shape getShape(String shape);
}