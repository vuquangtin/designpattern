package liskov_substitution_principle;


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

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int func(Stack p) {
		p.push(5);
		p.push(6);
		p.push(7);
		int a = p.pop();
		int b = p.pop();
		if (a == 7 && b == 6)
			return a * b;
		throw new IllegalArgumentException();
	}
	
}
