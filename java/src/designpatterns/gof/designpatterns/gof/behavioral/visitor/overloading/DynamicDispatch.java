package designpatterns.gof.behavioral.visitor.overloading;

/**
 * <h1>Dynamic Dispatch</h1> Dynamic dispatch is the same thing which we do in
 * strategy pattern.The actual method which is called is known at the runtime.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/designpattern">https://github.com
 * 
 *      /vuquangtin/designpattern</a>
 *
 */
public class DynamicDispatch {
	static interface Account {
		public void calculateinterest();
	}

	static class SavingsAccount implements Account {

		public void calculateinterest() {
			System.out.println("Intrest is 8%");
		}
	}

	static class LoanAccount implements Account {

		public void calculateinterest() {
			System.out.println("Intrest is 11.5%");
		}
	}

	public static void main(String[] args) {
		Account objSavAcc = new SavingsAccount();
		Account objLoanAcc = new LoanAccount();

		objSavAcc.calculateinterest();
		objLoanAcc.calculateinterest();
	}
}
