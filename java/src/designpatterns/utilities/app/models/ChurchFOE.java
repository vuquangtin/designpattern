package app.models;

import java.awt.image.BufferedImage;

import app.abstractClass.Church;
import app.gui.BufferedImageLoader;

public class ChurchFOE extends Church {
	public ChurchFOE() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public BufferedImage CaricaImmagine() {
		// TODO Auto-generated method stub
		BufferedImageLoader l = new BufferedImageLoader();
		BufferedImage church = l.loadBufferedImage(PATH + "/ChurchFOE.png");
		return church;

	}

	@Override
	public String getTipo() {
		// TODO Auto-generated method stub
		return "Church";
	}

}
