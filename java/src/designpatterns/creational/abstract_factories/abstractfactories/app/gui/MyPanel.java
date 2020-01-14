package abstractfactories.app.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JPanel;

import abstractfactories.app.factory.VillageFactory;
import abstractfactories.app.factory.VillageSimpsons;
import app.abstractclass.Resource;
import app.gui.BufferedImageLoader;

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
		g.drawImage(v.createTheatre().CaricaImmagine(), 410, 260, 130, 150, this);
		g.drawImage(v.createMonument().CaricaImmagine(), 100, 350, 100, 120, this);

	}

}
