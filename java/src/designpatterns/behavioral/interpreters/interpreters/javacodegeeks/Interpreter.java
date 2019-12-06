package interpreters.javacodegeeks;

public class Interpreter {

	public static void main(String[] args) {
		String selectionString = "SELECT b FROM foo WHERE a=1";
		Integer[] values = new QueryExpression().interpret(selectionString)
				.load(Integer[].class);
		System.out.println(values);
	}

}
