package abstractfactories.product;
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
    public static AbstractFactory createFactory(int factoryId){
        switch(factoryId){
            case ConcreteFactoryA.id:
                return new ConcreteFactoryA();
            case ConcreteFactoryB.id:
                return new ConcreteFactoryB();
            default:
                return null;
        }
    }
    public abstract AbstractProduct1 createProduct1();
    public abstract AbstractProduct2 createProduct2();
    public abstract AbstractProduct3 createProduct3();
}