package abstractfactories.product;
/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
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