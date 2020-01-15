package prototypes.app.editor;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

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

public class Main {

	public static void main(String[] args) {
		MyFrame frame = new MyFrame("Farmville");
		PreviewPanel panel = new PreviewPanel();
		ToolsPanel tools = new ToolsPanel(panel);
		Container contentPane = frame.getContentPane();
		panel.setPreferredSize(new Dimension(800, 608));
		tools.setPreferredSize(new Dimension(300, 608));

		contentPane.setLayout(new FlowLayout());
		contentPane.add(panel, BorderLayout.EAST);
		contentPane.add(tools, BorderLayout.WEST);

		frame.setResizable(false);

		frame.pack();
		frame.setLocationRelativeTo(null);

		frame.addMouseWheelListener(new MouseWheelListener() {

			@Override
			public void mouseWheelMoved(MouseWheelEvent event) {
				if (event.isShiftDown()) {
					System.err.println("Horizontal " + event.getWheelRotation());
				} else {
					System.err.println("Vertical " + event.getWheelRotation());
				}
			}
		});

		frame.setVisible(true);

	}

}
