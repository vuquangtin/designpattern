package app.models;

import java.awt.image.BufferedImage;

import app.abstractClass.Church;
import app.abstractClass.Resource;
import app.gui.BufferedImageLoader;

public class ChurchSimpson extends Church {

	@Override
	public BufferedImage CaricaImmagine() {
		// TODO Auto-generated method stub
		BufferedImageLoader l = new BufferedImageLoader();
		BufferedImage church = l.loadBufferedImage(Resource.PATH
				+ "/ChurchSimpson.png");
		return church;

	}

	@Override
	public String getTipo() {
		// TODO Auto-generated method stub
		return "Church";
	}

}
