package app.models;

import java.awt.image.BufferedImage;

import app.abstractclass.House;
import app.abstractclass.Resource;
import app.gui.BufferedImageLoader;

public class HouseSimpson extends House {

	@Override
	public BufferedImage CaricaImmagine() {
		// TODO Auto-generated method stub
		BufferedImageLoader l = new BufferedImageLoader();
		BufferedImage house = l.loadBufferedImage(Resource.PATH
				+ "HouseSimpson.png");
		return house;
	}

	@Override
	public String getTipo() {
		// TODO Auto-generated method stub
		return "House";
	}

}
