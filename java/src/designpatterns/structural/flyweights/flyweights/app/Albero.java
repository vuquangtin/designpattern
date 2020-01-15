package flyweights.app;

import java.awt.Graphics;

/**
 * <h1>Flyweight</h1> Sử dụng việc chia sẻ để hỗ trợ số lượng lớn các đối tượng
 * fine-graied cỡ nhỏ 1 cách hiệu quả
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com

 *      /vuquangtin/designpattern</a>
 *
 */
public class Albero {
	private int x;
	private int y;
	private Tipo tipo;

	public Albero(int x, int y, Tipo tipo) {
		this.x = x;
		this.y = y;
		this.tipo = tipo;
	}

	public void draw(Graphics g) {
		tipo.draw(g, x, y);
	}
}
