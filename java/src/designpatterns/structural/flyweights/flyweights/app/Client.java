package flyweights.app;

import java.awt.Color;

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

public class Client {
	static int CANVAS_SIZE = 500;
	static int TREES_TO_DRAW = 1000000;
	static int TREE_TYPES = 2;

	public static void main(String[] args) {
		Foresta foresta = new Foresta();
		for (int i = 0; i < Math.floor(TREES_TO_DRAW / TREE_TYPES); i++) {
			foresta.piantaAlbero(random(0, CANVAS_SIZE),
					random(0, CANVAS_SIZE), "Summer Oak", Color.GREEN,
					"Oak texture stub");
			foresta.piantaAlbero(random(0, CANVAS_SIZE),
					random(0, CANVAS_SIZE), "Autumn Oak", Color.ORANGE,
					"Autumn Oak texture stub");
		}
		foresta.setSize(CANVAS_SIZE, CANVAS_SIZE);
		foresta.setVisible(true);

		System.out.println("Total: "
				+ ((TREES_TO_DRAW * 8 + TREE_TYPES * 30) / 1024 / 1024)
				+ "MB (invece di " + ((TREES_TO_DRAW * 38) / 1024 / 1024)
				+ "MB)");
	}

	private static int random(int min, int max) {
		return min + (int) (Math.random() * ((max - min) + 1));
	}
}
