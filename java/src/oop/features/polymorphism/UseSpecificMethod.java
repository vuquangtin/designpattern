package features.polymorphism;

/**
 * <h1>Invoking specific methods in a polymorphic method call</h1> It's possible
 * to invoke specific methods in a polymorphic call, but doing it comes at the
 * cost of flexibility. Here’s an example:
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/designpattern">https://github.com
 *      /vuquangtin/designpattern</a>
 *
 */
abstract class MetalGearCharacter {
	abstract void useWeapon(String weapon);
}

class BigBoss extends MetalGearCharacter {
	@Override
	void useWeapon(String weapon) {
		System.out.println("Big Boss is using a " + weapon);
	}

	void giveOrderToTheArmy(String orderMessage) {
		System.out.println(orderMessage);
	}
}

class SolidSnake extends MetalGearCharacter {
	void useWeapon(String weapon) {
		System.out.println("Solid Snake is using a " + weapon);
	}
}

public class UseSpecificMethod {
	public static void executeActionWith(MetalGearCharacter metalGearCharacter) {
		metalGearCharacter.useWeapon("SOCOM");
		// The below line wouldn't work
		// metalGearCharacter.giveOrderToTheArmy("Attack!");
		if (metalGearCharacter instanceof BigBoss) {
			((BigBoss) metalGearCharacter).giveOrderToTheArmy("Attack!");
		}
	}

	public static void main(String... specificPolymorphismInvocation) {
		executeActionWith(new SolidSnake());
		executeActionWith(new BigBoss());
	}
}
