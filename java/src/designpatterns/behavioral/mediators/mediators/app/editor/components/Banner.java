package mediators.app.editor.components;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class Banner {
	public String generateBanner(String s) {
		int width = 150;
		int height = 28;

		String name = s;
		BufferedImage image = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		g.setFont(new Font("SansSerif", Font.BOLD, 16));
		Graphics2D graphics = (Graphics2D) g;
		graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
				RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		graphics.drawString(name, 2, 20);
		String out = "";
		for (int y = 0; y < height; y++) {
			StringBuilder strbuild = new StringBuilder();
			for (int x = 0; x < width; x++)
				strbuild.append(image.getRGB(x, y) == -16777216 ? "_" : "#");
			if (strbuild.toString().trim().isEmpty())
				continue;
			out += strbuild.toString() + System.lineSeparator();
		}
		return out;
	}
}
