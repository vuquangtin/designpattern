package prototypes.app.editor;

import javax.swing.JFrame;

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

public class MyFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	public MyFrame(String title) {

		this.setTitle(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(10, 10);
		this.setResizable(false);
		this.setVisible(true);

	}

	public void addContent(PreviewPanel p) {

		this.setContentPane(p);
		this.pack();
	}

}
