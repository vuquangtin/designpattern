package visitors.SingleDispatchandDoubleDispatch;
/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class SayLoveVisitor implements Visitor {
    @Override
    public void visit(AmericanLady lady) {
        lady.sayILoveYou();
    }

    @Override
    public void visit(JapanLady lady) {
        lady.sayAishiteImasu();
    }
}