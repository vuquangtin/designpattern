package composites.app;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
public class CompositePatternInSwing {

	Stylo stylo;
	Commande commande;
	Lot lot;
	Ramette ramette;

	public static void main(String[] args) {
		CompositePatternInSwing gui = new CompositePatternInSwing();
		gui.go();
	}

	public void go() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel label1 = new JLabel("I'm a label!");
		JLabel label2 = new JLabel("Me too!");

		JPanel labelPanel = new JPanel();
		labelPanel.add(label1);
		labelPanel.add(label2);

		JButton button1 = new JButton("I'm just a button");
		JButton button2 = new JButton("Ditto");

		JPanel buttonPanel = new JPanel();
		buttonPanel.add(button1);
		buttonPanel.add(button2);

		JPanel fullPanel = new JPanel();
		fullPanel.setLayout(new BoxLayout(fullPanel, BoxLayout.Y_AXIS));
		fullPanel.add(labelPanel);
		fullPanel.add(buttonPanel);

		frame.getContentPane().add(BorderLayout.CENTER, fullPanel);
		frame.setSize(400, 200);
		frame.setVisible(true);
	}

}
