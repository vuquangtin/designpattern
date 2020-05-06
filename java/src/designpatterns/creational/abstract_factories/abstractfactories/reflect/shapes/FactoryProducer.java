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
public class FactoryProducer {
    private static AbstractFactory abstractFactory = null;

    public static AbstractFactory getFactory(String factory) {
        if (factory == null) {
            throw new RuntimeException("param can't be null");
        }
        if (factory.equalsIgnoreCase(AbstractFactory.SHAPEFACTORY)) {
            abstractFactory = ShapeFactory.getInstance();
        } else if (factory.equalsIgnoreCase(AbstractFactory.COLORFACTORY)) {
            abstractFactory = ColorFactory.getInstance();
        }
        return abstractFactory;
    }

}