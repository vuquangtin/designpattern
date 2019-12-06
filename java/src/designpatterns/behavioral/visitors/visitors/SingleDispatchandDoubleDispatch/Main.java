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
public class Main {
	public static void main(final String[] args) {
	    Lady lady = new AmericanLady();
	    lady.accept(new SayLoveVisitor());
	}
}
