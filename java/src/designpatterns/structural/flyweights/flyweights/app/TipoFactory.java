package flyweights.app;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

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
public class TipoFactory {
	static private Map<String, Tipo> tipi = new HashMap<>();

	public static Tipo getTreeType(String nome, Color colore, String dati) {
		Tipo result = tipi.get(nome);
		if (result == null) {
			result = new Tipo(nome, colore, dati);
			tipi.put(nome, result);
		}
		return result;
	}
}
