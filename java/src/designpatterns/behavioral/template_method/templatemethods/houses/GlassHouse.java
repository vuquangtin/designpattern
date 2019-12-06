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
public class GlassHouse extends HouseTemplate {

	@Override
	public void buildWalls() {

		System.out.println("Building Glass Walls");

	}

	@Override
	public void buildPillars() {

		System.out.println("Building Pillars with glass coating");

	}

}