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
public class BallItem extends GameItem {
	BallThread twin;
	int radius;
	int dx, dy;
	boolean suspended;

	public BallItem(int posX, int posY, int radius2) {
		// TODO Auto-generated constructor stub
	}

	public void draw() {
		board.getGraphics().drawOval(posX - radius, posY - radius, 2 * radius,
				2 * radius);
	}

	public void move() {
		posX += dx;
		posY += dy;
	}

	@SuppressWarnings("deprecation")
	public void click() {
		if (suspended)
			twin.resume();
		else
			twin.suspend();
		suspended = !suspended;
	}

	public boolean intersects(GameItem other) {
		if (other instanceof Wall)
			return posX - radius <= other.posX && other.posX <= posX + radius
					|| posY - radius <= other.posY
					&& other.posY <= posY + radius;
		else
			return false;
	}

	public void collideWith(GameItem other) {
		Wall wall = (Wall) other;
		if (wall.isVertical)
			dx = -dx;
		else
			dy = -dy;
	}

	@Override
	public void click(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}