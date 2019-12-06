package visitors.animals;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class Dracula implements Monster {

	public void hitBy(Warrior warrior) {
		damaged(10);
	}

	public void hitBy(Wizard wizard) {
		damaged(80);
	}

	public void damaged(int hp) {
		System.out.println("Owie! I lost " + hp + "hp ᙙᙖ");
	}

}
