package factorymethods.app.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import app.abstractclass.Church;
import app.gui.BufferedImageLoader;
import factorymethods.app.factory.VillageFOE;
import factorymethods.app.factory.VillageFactory;
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
public class MyPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public MyPanel(int width, int height, int scale) {

		Dimension s = new Dimension((int) width * scale, (int) height * scale);
		this.setPreferredSize(s);
		this.setMaximumSize(s);
		this.setMinimumSize(s);
	}

	public void makePanelFocusable() {
		this.setFocusable(true);
		this.requestFocusInWindow();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		BufferedImageLoader l = new BufferedImageLoader();
		BufferedImage sfondo = l.loadBufferedImage(Church.PATH
				+ "Background.png");
		g.drawImage(sfondo, 0, 0, 900, 540, this);

		// Creazione Villaggio

		VillageFactory v = new VillageFOE();
		g.drawImage(v.createBuilding("Church").CaricaImmagine(), 270, 190, 130,
				150, this);
		g.drawImage(v.createBuilding("Theatre").CaricaImmagine(), 420, 110,
				130, 150, this);
		g.drawImage(v.createBuilding("House").CaricaImmagine(), 580, 190, 130,
				150, this);
		g.drawImage(v.createBuilding("School").CaricaImmagine(), 410, 260, 130,
				150, this);
		g.drawImage(v.createBuilding("Monument").CaricaImmagine(), 100, 350,
				100, 120, this);

	}

}
