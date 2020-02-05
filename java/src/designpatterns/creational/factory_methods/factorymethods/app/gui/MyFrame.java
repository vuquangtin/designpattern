package factorymethods.app.gui;


import javax.swing.JFrame;

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
