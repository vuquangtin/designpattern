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
public abstract class AbstractProduct3 {
    protected String name;
    public AbstractProduct3(String name) {
        this.name = name;
    }
    public abstract void action();
}