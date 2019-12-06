package factorymethods.creators;
/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public abstract class Creator {
    public abstract Product factoryMethod();
    public final Product create() {
        Product product = factoryMethod();
        return product;
    }
}