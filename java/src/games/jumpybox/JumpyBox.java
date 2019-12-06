package jumpybox;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.Timer;
/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */


public class JumpyBox implements ActionListener, MouseListener, KeyListener {

	public static JumpyBox jumpyBox;
	public final int FRAME_WIDTH = 800, FRAME_HEIGHT = 800;
	public UIRenderer renderer;
	public Rectangle box;
	public ArrayList<Rectangle> columns;
	public int ticks, yMotion, score;
	public boolean gameOver, started;
	public Random random;

	public JumpyBox() {
		JFrame jframe = new JFrame();
		
		//Set a timer for fire actionPerformed(ActionEvent e) after interval
		//actionPerformed method will repaint UI, and check gameOver or not 
		Timer timer = new Timer(18, this);

		renderer = new UIRenderer();
		random = new Random();

		jframe.add(renderer);
		jframe.setTitle("Jumpy Box");
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		jframe.addMouseListener(this);
		jframe.addKeyListener(this);
		jframe.setResizable(false);
		jframe.setVisible(true);

		box = new Rectangle(FRAME_WIDTH / 2 - 10, FRAME_HEIGHT / 2 - 10, 20, 20);
		columns = new ArrayList<Rectangle>();

		addColumn(true);
		addColumn(true);
		addColumn(true);
		addColumn(true);

		timer.start();
	}

	public void addColumn(boolean start) {
		int space = 300;
		int width = 100;
		int height = 50 + random.nextInt(300);

		if (start) {
			columns.add(new Rectangle(FRAME_WIDTH + width + columns.size() * 300, FRAME_HEIGHT - height - 120, width, height));
			columns.add(new Rectangle(FRAME_WIDTH + width + (columns.size() - 1) * 300, 0, width, FRAME_HEIGHT - height - space));
		} else {
			columns.add(new Rectangle(columns.get(columns.size() - 1).x + 600, FRAME_HEIGHT - height - 120, width, height));
			columns.add(new Rectangle(columns.get(columns.size() - 1).x, 0, width, FRAME_HEIGHT - height - space));
		}
	}

	public void paintColumn(Graphics g, Rectangle column) {
		g.setColor(Color.green.darker());
		g.fillRect(column.x, column.y, column.width, column.height);
	}

	public void jump() {
		if (gameOver) {
			box = new Rectangle(FRAME_WIDTH / 2 - 10, FRAME_HEIGHT / 2 - 10, 20, 20);
			columns.clear();
			yMotion = 0;
			score = 0;

			addColumn(true);
			addColumn(true);
			addColumn(true);
			addColumn(true);

			gameOver = false;
		}

		if (!started) {
			started = true;
		} else if (!gameOver) {
			if (yMotion > 0) {
				yMotion = 0;
			}

			yMotion -= 10;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int speed = 10;

		ticks++;

		if (started) {
			for (int i = 0; i < columns.size(); i++) {
				Rectangle column = columns.get(i);
				column.x -= speed;
			}

			if (ticks % 2 == 0 && yMotion < 15) {
				yMotion += 2;
			}

			for (int i = 0; i < columns.size(); i++) {
				Rectangle column = columns.get(i);
				if (column.x + column.width < 0) {
					columns.remove(column);
					if (column.y == 0) {
						addColumn(false);
					}
				}
			}

			box.y += yMotion;

			for (Rectangle column : columns) {
				if (column.y == 0 && box.x + box.width / 2 > column.x + column.width / 2 - 10
						&& box.x + box.width / 2 < column.x + column.width / 2 + 10) {
					score++;
				}

				if (column.intersects(box)) {
					gameOver = true;

					if (box.x <= column.x) {
						box.x = column.x - box.width;
					} else {
						if (column.y != 0) {
							box.y = column.y - box.height;
						} else if (box.y < column.height) {
							box.y = column.height;
						}
					}
				}
			}

			if (box.y > FRAME_HEIGHT - 120 || box.y < 0) {
				gameOver = true;
			}

			if (box.y + yMotion >= FRAME_HEIGHT - 120) {
				box.y = FRAME_HEIGHT - 120 - box.height;
				gameOver = true;
			}
		}

		renderer.repaint();
	}

	public void repaint(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, FRAME_WIDTH, FRAME_HEIGHT);

		g.setColor(Color.gray);
		g.fillRect(0, FRAME_HEIGHT - 120, FRAME_WIDTH, 120);

		g.setColor(Color.yellow);
		g.fillRect(0, FRAME_HEIGHT - 120, FRAME_WIDTH, 20);

		g.setColor(Color.red);
		g.fillRect(box.x, box.y, box.width, box.height);

		for (Rectangle column : columns) {
			paintColumn(g, column);
		}

		g.setColor(Color.white);
		g.setFont(new Font("Arial", 1, 100));

		if (!started) {
			g.drawString("Click to start!", 75, FRAME_HEIGHT / 2 - 50);
		}

		if (gameOver) {
			g.drawString("Game Over!", 100, FRAME_HEIGHT / 2 - 50);
		}

		if (!gameOver && started) {
			g.drawString(String.valueOf(score), FRAME_WIDTH / 2 - 25, 100);
		}
	}

	public static void main(String[] args) {
		jumpyBox = new JumpyBox();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		jump();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			jump();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

}

