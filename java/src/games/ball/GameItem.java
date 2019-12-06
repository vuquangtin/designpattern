package ball;

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
public abstract class GameItem {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(GameItem.class);

	/**
	 * Template method, do some common logic before draw
	 */
	public void draw() {
		LOGGER.info("draw");
		doDraw();
	}

	public abstract void doDraw();

	public abstract void click();
}