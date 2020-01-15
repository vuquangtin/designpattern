package prototypes.app.editor;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.Vector;

import javax.swing.JPanel;

import app.gui.BufferedImageLoader;

/**
 * <h1>Prototype</h1> Xác định các kiểu của các object (đối tượng) muốn tạo ra
 * bằng cách sử dụng một prototype (khuôn mẫu,nguyên mẫu), và tạo ra những
 * object (đối tượng) mới bằng cách sao chép prototype này.
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com

 *      /vuquangtin/designpattern</a>
 *
 */

public class PreviewPanel extends JPanel implements MouseListener,
		MouseMotionListener {
	private static final long serialVersionUID = 1L;

	private Vector<ColoredPoint> points = new Vector<ColoredPoint>();
	private Color paintColor = Color.yellow;
	public BufferedImage paintImage = null;

	public PreviewPanel() {
		super();
		addMouseListener(this);
		addMouseMotionListener(this);
	}

	public void paintComponent(Graphics g) {
		g.fillRect(0, 0, 1100, 800);
		BufferedImageLoader l = new BufferedImageLoader();
		BufferedImage sfondo = l.loadBufferedImage("Background_color.jpg");
		g.drawImage(sfondo, 0, 0, 1200, 700, this);

		for (int i = 0; i < points.size(); i++) {
			ColoredPoint tmp = points.get(i);
			g.drawImage(tmp.getImage(), tmp.getPoint().x * 32,
					tmp.getPoint().y * 32, 32, 32, null);
		}
	}

	public void mouseDragged(MouseEvent e) {
		mousePressed(e);

	}

	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		Point p = clickToGrid(x, y);
		ColoredPoint cp = new ColoredPoint(p, paintColor, paintImage);
		removeDuplicate(p);
		points.add(cp);
		repaint();

	}

	private Point clickToGrid(int x, int y) {
		int px = x;
		int py = y;
		px = px / 32;
		py = py / 32;

		return new Point(px, py);
	}

	private void removeDuplicate(Point p) {
		for (int i = 0; i < points.size(); i++) {
			ColoredPoint tmp = points.get(i);
			if (tmp.getPoint().equals(p)) {
				points.remove(i);
				return;
			}
		}
	}

	public void setPaintColor(Color color) {
		this.paintColor = color;
	}

	public void mouseMoved(MouseEvent e) {
	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

}
