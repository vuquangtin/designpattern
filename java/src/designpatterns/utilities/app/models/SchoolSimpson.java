package app.models;

import java.awt.image.BufferedImage;

import app.abstractclass.Building;
import app.abstractclass.Resource;
import app.abstractclass.School;
import app.gui.BufferedImageLoader;

public class SchoolSimpson extends School {

	@Override
	public BufferedImage CaricaImmagine() {
		// TODO Auto-generated method stub
		BufferedImageLoader l = new BufferedImageLoader();
		BufferedImage school = l.loadBufferedImage(Resource.PATH
				+ "SchoolSimpson.png");
		return school;
	}

	@Override
	public String getTipo() {
		// TODO Auto-generated method stub
		return "School";
	}

}
