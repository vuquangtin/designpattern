package prototypes.app.model;

import java.awt.image.BufferedImage;

import app.gui.BufferedImageLoader;

/**
 * <h1>Prototype</h1> Xác định các kiểu của các object (đối tượng) muốn tạo ra
 * bằng cách sử dụng một prototype (khuôn mẫu,nguyên mẫu), và tạo ra những
 * object (đối tượng) mới bằng cách sao chép prototype này.
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com

 *      /vuquangtin/designpattern</a>
 *
 */
public class Tomato extends Vegetables {

	public Tomato() {
		type = "Tomato";
	}

	@Override
	public BufferedImage Image() {
		// TODO Auto-generated method stub
		BufferedImageLoader loader = new BufferedImageLoader();
		return loader.loadBufferedImage("Tomato.png");

	}

}
