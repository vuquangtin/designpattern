package interpreters.expression1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class Program {
	public static void main(String[] args) {
		String str, select = "C";
		ArrayList<Expression> parse = new ArrayList<Expression>();
		Scanner sc = new Scanner(System.in);

		while (select != "K" && select != "k") {

			System.out.println("Nhap vao so La Ma : ");
			str = sc.nextLine();
			str = str.toUpperCase();
			Context context = new Context(str);

			parse.add(new ThousandExpresssion());
			parse.add(new HundredExpresssion());
			parse.add(new TenExpresssion());
			parse.add(new OneExpresssion());
			for (Expression exp : parse) {
				exp.interpreter(context);
			}

			System.out.println(""+str+" = "+ context.output);

			System.out.println("Ban co muon tiep tuc ? (C/K)");
			select = sc.nextLine();
		}
		sc.close();
	}
}
