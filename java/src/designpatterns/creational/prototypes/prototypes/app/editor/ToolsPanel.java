package prototypes.app.editor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import prototypes.app.model.Vegetables;
import prototypes.app.prototype.VegetablesCache;

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

@SuppressWarnings("serial")
public class ToolsPanel extends JPanel implements ActionListener {

	private PreviewPanel pp;
	private JButton b1 = new JButton();
	private JButton b2 = new JButton();
	private JButton b3 = new JButton();
	private BufferedImage b1Image = null;
	private BufferedImage b2Image = null;
	private BufferedImage b3Image = null;

	public ToolsPanel(PreviewPanel pp) {
		super();
		this.pp = pp;

		// CLONAZIONE

		VegetablesCache.loadVegetables();
		Vegetables cloned_tomato = (Vegetables) VegetablesCache
				.getVegetables("a");
		Vegetables cloned_chillies = (Vegetables) VegetablesCache
				.getVegetables("b");
		Vegetables cloned_yucca = (Vegetables) VegetablesCache
				.getVegetables("c");

		b1Image = cloned_tomato.Image();
		b2Image = cloned_chillies.Image();
		b3Image = cloned_yucca.Image();

		pp.paintImage = b1Image;
		b1.addActionListener(this);
		b1.setIcon(new ImageIcon(b1Image.getScaledInstance(80, 80, 0)));
		add(b1);
		b2.addActionListener(this);
		b2.setIcon(new ImageIcon(b2Image.getScaledInstance(80, 80, 0)));
		add(b2);
		b3.addActionListener(this);
		b3.setIcon(new ImageIcon(b3Image.getScaledInstance(80, 80, 0)));
		add(b3);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {

			pp.paintImage = b1Image;
		} else if (e.getSource() == b2) {

			pp.paintImage = b2Image;
		} else if (e.getSource() == b3) {

			pp.paintImage = b3Image;
		}

	}
}
