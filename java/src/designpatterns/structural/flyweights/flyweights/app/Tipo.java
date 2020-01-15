package flyweights.app;

import java.awt.Color;
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
public class Tipo {
	private String nome;
	private Color colore;
	private String dati;

	public Tipo(String name, Color color, String otherTreeData) {
		this.nome = name;
		this.colore = color;
		this.dati = otherTreeData;
	}

	public void draw(Graphics g, int x, int y) {
		g.setColor(Color.BLACK);
		g.fillRect(x - 1, y, 3, 5);
		g.setColor(colore);
		g.fillOval(x - 5, y - 10, 10, 10);
	}

}