package factorymethods.app.gui;

/**
 * <h1>Factory Method</h1>Cung cấp 1 giao diện để tạo ra đối tượng nhưng để lớp
 * con quyết định kiểu đối tượng nào sẽ dc tạo.
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com

 *      /vuquangtin/designpattern</a>
 *
 */
public class Window {

	private MyFrame frame;
	private MyPanel panel;

	public Window(String title, int width, int heigth, int scale) {
		frame = new MyFrame(title);
		panel = new MyPanel(width, heigth, scale);
		frame.addContent(panel);
		panel.makePanelFocusable();

	}

	public MyFrame getFrame() {
		return frame;
	}

	public MyPanel getPanel() {
		return panel;
	}

}