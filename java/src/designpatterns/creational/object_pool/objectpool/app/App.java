package objectpool.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class App {

	private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		OliphauntPool pool = new OliphauntPool();
		LOGGER.info(pool.toString());
		Oliphaunt oliphaunt = pool.checkOut();
		LOGGER.info("Checked out {}", oliphaunt);
		LOGGER.info(pool.toString());
	}
}