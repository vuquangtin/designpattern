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
public class ShapeFactory extends AbstractFactory{

    private static ShapeFactory shapFactory;

    private ShapeFactory() {
    }

    public static ShapeFactory getInstance() {
        if (shapFactory == null) {
            synchronized (ShapeFactory.class) {
                if (shapFactory == null) {
                    shapFactory = new ShapeFactory();
                }
            }
        }
        return shapFactory;
    }

    @Override
    public Color getColor(String color) {
        return null;
    }

    public Shape getShape(String shape) {
        try {
            Class<?> clazz = Class.forName(shape);
            return (Shape) clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}