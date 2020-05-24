package designpatterns.gof.behavioral.visitor.overloading;

/**
 * <h1>Multiple Dispatch</h1> is overloaded
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/designpattern">https://github.com
 * 
 *      /vuquangtin/designpattern</a>
 *
 */
public class MultipleDispatch {
	static class Account {
		public void calculateinterest() {
			System.out.println("Intrest is 11.5%");
		}

		public void calculateinterest(int prePayment) {
			System.out.println("Intrest is 11.5% with prePayment");
		}

		public void calculateinterest(int prePayment, boolean floatingIntrest) {
			System.out.println("Intrest is 11.5% with floatingIntrest");
		}
	}

	/***
	 * Now in the above example we have a Account class where the functions are
	 * overloaded.Now when the code gets executed then the methods are chosen
	 * based on the parameters passed.
	 */
	public static void main(String[] args) {
		Account objAcc = new Account();

		objAcc.calculateinterest();
		objAcc.calculateinterest(23);
		objAcc.calculateinterest(23, true);
	}

}
