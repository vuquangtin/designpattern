package factorymethods.app.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import factorymethods.app.factory.VillageFOE;
import app.abstractclass.Church;
import app.gui.BufferedImageLoader;
import factorymethods.app.factory.VillageFactory;

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
