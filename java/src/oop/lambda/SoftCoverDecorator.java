package lambda;
/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class SoftCoverDecorator extends BookDecorator {
	 
    SoftCoverDecorator(Book book) {
        super(book);
    }
     
    @Override
    public String describe() {  
        return (super.describe() + " with Soft Cover");
    }
}