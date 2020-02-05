package composites.shapes;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.Border;
/**
 * <h1>Composite</h1> Các đối tượng cấu thành các cấu trúc cây để mô tả bán toàn
 * bộ hệ thống phần cấp. Composite để cho các client tác động các đối tượng
 * riêng biệt và các thành phần của đối tượng một cách thống nhất.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class ImageEditor {
	private EditorCanvas canvas;
	private CompoundShape allShapes = new CompoundShape();

	public ImageEditor() {
		canvas = new EditorCanvas();
	}

	public void loadShapes(Shape... shapes) {
		allShapes.clear();
		allShapes.add(shapes);
		canvas.refresh();
	}

	private class EditorCanvas extends Canvas {
		/**
		 * 
		 */
		private static final long serialVersionUID = -7903769844613985303L;

		JFrame frame;

		private static final int PADDING = 10;

		EditorCanvas() {
			createFrame();
			refresh();
			addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					allShapes.unSelect();
					allShapes.selectChildAt(e.getX(), e.getY());
					e.getComponent().repaint();
				}
			});
		}

		void createFrame() {
			frame = new JFrame();
			frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			frame.setLocationRelativeTo(null);

			JPanel contentPanel = new JPanel();
			Border padding = BorderFactory.createEmptyBorder(PADDING, PADDING, PADDING, PADDING);
			contentPanel.setBorder(padding);
			frame.setContentPane(contentPanel);

			frame.add(this);
			frame.setVisible(true);
			frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		}

		public int getWidth() {
			return allShapes.getX() + allShapes.getWidth() + PADDING;
		}

		public int getHeight() {
			return allShapes.getY() + allShapes.getHeight() + PADDING;
		}

		void refresh() {
			this.setSize(getWidth(), getHeight());
			frame.pack();
		}

		public void paint(Graphics graphics) {
			allShapes.paint(graphics);
		}
	}
}