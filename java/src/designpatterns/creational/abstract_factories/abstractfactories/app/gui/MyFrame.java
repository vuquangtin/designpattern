package abstractfactories.app.gui;

import javax.swing.JFrame;

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
public class MyFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	public MyFrame(String title) {

		this.setTitle(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(10, 10);
		this.setResizable(false);
		this.setVisible(true);

	}

	public void addContent(MyPanel p) {

		this.setContentPane(p);
		this.pack();

	}

}
