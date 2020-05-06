package designpatterns.gof.structural.decorator.pattern;
/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class ConcreteDecoratorB extends Decorator {

    public ConcreteDecoratorB(Component component) {
        super(component);
    }

    public void addedBehavior() {
        System.out.println("add behave");
    }

    @Override
    public void operation() {
        super.operation();
        addedBehavior();
    }
}