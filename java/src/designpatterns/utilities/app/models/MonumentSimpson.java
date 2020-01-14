package app.models;

import java.awt.image.BufferedImage;

import app.abstractClass.Monument;
import app.abstractClass.Resource;
import app.gui.BufferedImageLoader;

public class MonumentSimpson extends Monument {

	@Override
	public BufferedImage CaricaImmagine() {
		// TODO Auto-generated method stub
		BufferedImageLoader l = new BufferedImageLoader();
		BufferedImage monument = l
				.loadBufferedImage(Resource.PATH
						+ "/MonumentSimpson.png");
		return monument;

	}

	@Override
	public String getTipo() {
		// TODO Auto-generated method stub
		return "Monument";
	}

}
