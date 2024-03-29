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
public class ConcreteProductB3 extends AbstractProduct3 {
    public ConcreteProductB3(String name) {
        super(name);
    }
    public void action() {
        System.out.println(name + " 完成(B3-action)！");
    }
}