package abstractfactories.af_and_singletons;
/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class DetailedStatement implements StatementType {
	@Override
	public String print() {
		System.out.println("Detailed Statement Created");
		return "detailedStmt";
	}
}
