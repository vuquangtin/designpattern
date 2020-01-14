package app.models;

import java.awt.image.BufferedImage;

import app.abstractClass.Building;
import app.abstractClass.House;
import app.abstractClass.Monument;
import app.abstractClass.Resource;
import app.gui.BufferedImageLoader;


public class MonumentFOE extends Monument {

	@Override
	public BufferedImage CaricaImmagine() {
		// TODO Auto-generated method stub
				BufferedImageLoader l= new BufferedImageLoader();
				BufferedImage monument=l.loadBufferedImage(Resource.PATH
						+ "/MonumentFOE.png");
				return monument;
				
		
	}

	@Override
	public String getTipo() {
		// TODO Auto-generated method stub
		return "Monument";
	}

}
