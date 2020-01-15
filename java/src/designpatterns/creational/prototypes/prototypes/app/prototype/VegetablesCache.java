package prototypes.app.prototype;

import java.util.HashMap;

import prototypes.app.model.Chillies;
import prototypes.app.model.Tomato;
import prototypes.app.model.Vegetables;
import prototypes.app.model.Yucca;

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
public class VegetablesCache {

	private static HashMap<String, Vegetables> vegetables = new HashMap<String, Vegetables>();

	public static void loadVegetables() {

		Tomato tomato = new Tomato();
		tomato.setId("a");
		vegetables.put(tomato.getId(), tomato);

		Chillies chillies = new Chillies();
		chillies.setId("b");
		vegetables.put(chillies.getId(), chillies);

		Yucca yucca = new Yucca();
		yucca.setId("c");
		vegetables.put(yucca.getId(), yucca);

	}

	public static Vegetables getVegetables(String id) {
		Vegetables v = vegetables.get(id);
		return (Vegetables) v.clone();
	}

}
