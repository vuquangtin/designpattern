package app.models;

import java.awt.image.BufferedImage;

import app.abstractClass.Resource;
import app.abstractClass.School;
import app.gui.BufferedImageLoader;

public class SchoolFOE extends School {

	@Override
	public BufferedImage CaricaImmagine() {
		// TODO Auto-generated method stub
		BufferedImageLoader l = new BufferedImageLoader();
		BufferedImage school = l.loadBufferedImage(Resource.PATH
				+ "/SchoolFOE.png");
		return school;

	}

	@Override
	public String getTipo() {
		// TODO Auto-generated method stub
		return "School";
	}

}
