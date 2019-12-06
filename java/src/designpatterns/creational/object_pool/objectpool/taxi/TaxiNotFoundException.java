package objectpool.taxi;
/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class TaxiNotFoundException extends RuntimeException {
	 
    private static final long serialVersionUID = -6670953536653728443L;
 
    public TaxiNotFoundException(String message) {
        System.out.println(message);
    }
}