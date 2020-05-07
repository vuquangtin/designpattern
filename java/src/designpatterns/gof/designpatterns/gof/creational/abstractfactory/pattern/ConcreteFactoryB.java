package designpatterns.gof.creational.abstractfactory.pattern;
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
public class ConcreteFactoryB extends AbstractFactory {
    public static final int id = 2;
    public AbstractProduct1 createProduct1() {
        return new ConcreteProductB1("工場B - 製品1");
    }
    public AbstractProduct2 createProduct2() {
        return new ConcreteProductB2("工場B - 製品2");
    }
    public AbstractProduct3 createProduct3() {
        return new ConcreteProductB3("工場B - 製品3");
    }
}
