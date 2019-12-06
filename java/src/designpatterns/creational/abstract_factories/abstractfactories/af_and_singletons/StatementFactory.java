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
public class StatementFactory extends Factory {
	private static StatementFactory uniqueInstance;

	private StatementFactory() {
	}

	public static StatementFactory getUniqueInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new StatementFactory();
			System.out.println("Creating a new StatementFactory instance");
		}
		return uniqueInstance;

	}

	public StatementType createStatements(String selection) {
		if (selection.equalsIgnoreCase("detailedStmt")) {
			return new DetailedStatement();
		} else if (selection.equalsIgnoreCase("miniStmt")) {
			return new MiniStatement();
		}
		throw new IllegalArgumentException("Selection doesnot exist");
	}
}