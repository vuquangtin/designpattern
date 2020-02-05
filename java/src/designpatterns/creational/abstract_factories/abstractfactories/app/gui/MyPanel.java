package abstractfactories.app.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import abstractfactories.app.factory.VillageFactory;
import abstractfactories.app.factory.VillageSimpsons;
import app.abstractclass.Resource;
import app.gui.BufferedImageLoader;

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

		System.out.println(Resource.PATH + "Background.png");

		BufferedImage sfondo;
		sfondo = l.loadBufferedImage(Resource.PATH + "Background.png");
		g.drawImage(sfondo, 0, 0, 900, 540, this);

		// Creazione Villaggio

		VillageFactory v = new VillageSimpsons();
		g.drawImage(v.createSchool().CaricaImmagine(), 270, 190, 130, 150, this);
		g.drawImage(v.createHouse().CaricaImmagine(), 420, 110, 130, 150, this);
		g.drawImage(v.createChurch().CaricaImmagine(), 580, 190, 130, 150, this);
		g.drawImage(v.createTheatre().CaricaImmagine(), 410, 260, 130, 150,
				this);
		g.drawImage(v.createMonument().CaricaImmagine(), 100, 350, 100, 120,
				this);

	}

}
