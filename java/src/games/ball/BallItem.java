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
public class BallItem extends GameItem {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(BallItem.class);

	private boolean isSuspended;

	private BallThread twin;

	public void setTwin(BallThread twin) {
		this.twin = twin;
	}

	@Override
	public void doDraw() {

		LOGGER.info("doDraw");
	}

	public void move() {
		LOGGER.info("move");
	}

	@Override
	public void click() {

		isSuspended = !isSuspended;

		if (isSuspended) {
			twin.suspendMe();
		} else {
			twin.resumeMe();
		}
	}
}