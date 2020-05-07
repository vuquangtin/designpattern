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
public class ConcreteFactoryA extends AbstractFactory {
    public static final int id = 1;
    public AbstractProduct1 createProduct1() {
        return new ConcreteProductA1("工場A - 製品1");
    }
    public AbstractProduct2 createProduct2() {
        return new ConcreteProductA2("工場A - 製品2");
    }
    public AbstractProduct3 createProduct3() {
        return new ConcreteProductA3("工場A - 製品3");
    }
}