package twin;

import java.awt.event.MouseEvent;

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
	Gameboard board;
	int posX, posY;
	GameItem next;

	public abstract void draw();

	public abstract void click(MouseEvent e);

	public abstract boolean intersects(GameItem other);

	public abstract void collideWith(GameItem other);

	public void check() {
		GameItem x;
		for (x = board.firstItem; x != null; x = x.next)
			if (intersects(x))
				collideWith(x);
	}

	public static BallItem newBall(int posX, int posY, int radius) {// method of
																	// GameBoard
		BallItem ballItem = new BallItem(posX, posY, radius);
		BallThread ballThread = new BallThread();
		ballItem.twin = ballThread;
		ballThread.twin = ballItem;
		return ballItem;
	}
}
