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

public class TaxiApp {

	public static final int NUM_OF_CLIENT = 8;

	public static void main(String[] args) {
		TaxiPool taxiPool = new TaxiPool();
		for (int i = 1; i <= NUM_OF_CLIENT; i++) {
			Runnable client = new ClientThread(taxiPool);
			Thread thread = new Thread(client);
			thread.start();
		}
	}
}