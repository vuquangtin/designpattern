package abstractfactories.app.gui;

/**
 * <h1>Abstract Factory</h1> Cung cấp một interface để tạo ra 1 họ các object
 * (đối tượng) có liên quan hoặc phụ thuộc lẫn nhau mà không chỉ rõ các lớp cụ
 * thể của chúng (concrete classes)
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