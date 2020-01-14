package app.models;

import java.awt.image.BufferedImage;

import app.abstractclass.Theatre;
import app.gui.BufferedImageLoader;

public class TheatreFOE extends Theatre {

	@Override
	public BufferedImage CaricaImmagine() {
		// TODO Auto-generated method stub
		BufferedImageLoader l = new BufferedImageLoader();
		BufferedImage theatre = l.loadBufferedImage(PATH + "TheatreFOE.png");
		return theatre;

	}

	@Override
	public String getTipo() {
		// TODO Auto-generated method stub
		return "Theatre";
	}

}
