package app.gui;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BufferedImageLoader {

	private BufferedImage image;

	public BufferedImageLoader() {
	}

	public BufferedImageLoader(String path) {
		try {
			setImage(ImageIO.read(getClass().getResource(path)));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public BufferedImage loadBufferedImage(String path) {
		BufferedImage image2 = null;
		try {
			if (path.startsWith("/")) {
				System.out.println(path);
				image2 = ImageIO.read(new File(path));
			} else
				image2 = ImageIO.read(getClass().getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image2;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

}
