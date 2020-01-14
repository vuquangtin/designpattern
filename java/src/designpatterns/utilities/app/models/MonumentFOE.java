package app.models;

import java.awt.image.BufferedImage;

import app.abstractclass.Building;
import app.abstractclass.House;
import app.abstractclass.Monument;
import app.abstractclass.Resource;
import app.gui.BufferedImageLoader;


public class MonumentFOE extends Monument {

	@Override
	public BufferedImage CaricaImmagine() {
		// TODO Auto-generated method stub
				BufferedImageLoader l= new BufferedImageLoader();
				BufferedImage monument=l.loadBufferedImage(Resource.PATH
						+ "MonumentFOE.png");
				return monument;
				
		
	}

	@Override
	public String getTipo() {
		// TODO Auto-generated method stub
		return "Monument";
	}

}
