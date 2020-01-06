package strategies.cars;

/**
 * <h1>Strategy</h1> Định nghĩa tập hợp các thuật toán, đóng gói từng thuật toán
 * lại, và làm chúng hoán đổi lẫn nhau. Strategy cho phép thuật toán biến đổi
 * độc lập khi người dùng sử dụng chúng.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/designpattern">https://github.com
 *      /vuquangtin/designpattern</a>
 *
 */
public class StartTheRace {
	public static void main(String[] args) {
		StreetRacer streetracer = new StreetRacer();
		RollRoyce rollRoyce = new RollRoyce();
		Helicopter helicopter = new Helicopter();
		Jet jet = new Jet();
		streetracer.go();
		rollRoyce.go();
		helicopter.go();
		jet.go();

		jet.setGoAlgorithm(new GoByFlying());
		jet.go();
	}
}