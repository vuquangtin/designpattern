package method_chaining;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public final class MethodChainingTest {
	public static void main(String[] args) {
		String name = new Storage().put("A").and("B").and(null).and("D").get(0)
				.getName();
		System.out.println("Name: " + name + "\n");

		System.exit(0);
	}

}