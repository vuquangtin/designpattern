package abstractfactories.app.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JPanel;

import abstractfactories.app.factory.VillageFactory;
import abstractfactories.app.factory.VillageSimpsons;
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
		try {
			System.out.println(new File(".").getCanonicalPath()+ "/java/src/designpatterns/creational/abstract_factories/abstractfactories/app/resources/Background.png");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedImage sfondo;
		try {
			sfondo = l.loadBufferedImage(new File(".").getCanonicalPath()
					+ "/java/src/designpatterns/creational/abstract_factories/abstractfactories/app/resources/Background.png");
			g.drawImage(sfondo, 0, 0, 900, 540, this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
