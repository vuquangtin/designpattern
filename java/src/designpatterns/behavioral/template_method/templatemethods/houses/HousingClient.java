package templatemethods.houses;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class HousingClient {

	public static void main(String[] args) {

		HouseTemplate houseType = new WoodenHouse();

		// using template method

		houseType.buildHouse();

		System.out.println("************");

		houseType = new GlassHouse();

		houseType.buildHouse();

	}

}