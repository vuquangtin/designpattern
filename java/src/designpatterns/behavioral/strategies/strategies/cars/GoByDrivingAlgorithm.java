package strategies.cars;

/**
 * <h1>Strategy </h1> Định nghĩa 1 tập hợp (họ) các thuật toán, đóng gói từng thuật toán lại,
 * và làm chúng hoán đổi lẫn nhau. Strategy cho phép thuật toán biến đổi độc lập
 * khi người dùng sử dụng chúng.
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/designpattern">https://github.com
 *      /vuquangtin/designpattern</a>
 *
 */
public class GoByDrivingAlgorithm implements GoAlgorithm {
	public void go() {
		System.out.println("Now, i'm drving.");
	}
}
