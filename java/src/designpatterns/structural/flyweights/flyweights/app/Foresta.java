package flyweights.app;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

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
public class Foresta extends JFrame {

	private static final long serialVersionUID = 1L;
	private List<Albero> alberi = new ArrayList<>();

	public void piantaAlbero(int x, int y, String nome, Color colore,
			String dati) {
		Tipo tipoAlbero = TipoFactory.getTreeType(nome, colore, dati);
		Albero albero = new Albero(x, y, tipoAlbero);
		alberi.add(albero);
	}

	@Override
	public void paint(Graphics graphics) {
		for (Albero albero : alberi) {
			albero.draw(graphics);
		}
	}
}
