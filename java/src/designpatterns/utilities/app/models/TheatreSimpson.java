package app.models;

import java.awt.image.BufferedImage;

import app.abstractclass.Resource;
import app.abstractclass.Theatre;
import app.gui.BufferedImageLoader;

public class TheatreSimpson extends Theatre {

	@Override
	public BufferedImage CaricaImmagine() {
		// TODO Auto-generated method stub
		BufferedImageLoader l = new BufferedImageLoader();
		BufferedImage theatre = l.loadBufferedImage(Resource.PATH
				+ "TheatreSimpson.png");
		return theatre;

	}

	@Override
	public String getTipo() {
		// TODO Auto-generated method stub
		return "Theatre";
	}

}
