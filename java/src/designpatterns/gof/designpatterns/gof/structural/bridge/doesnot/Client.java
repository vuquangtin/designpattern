package designpatterns.gof.structural.bridge.doesnot;

/**
 * <h1>Bridge</h1> Tách một abstraction khỏi implementation của nó để cả hai có
 * thể thay đổi độc lập nhau.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/designpattern">https://github.com
 * 
 *      /vuquangtin/designpattern</a>
 *
 */
public class Client {
	public static void main(String[] args) {
		Goods goods = new CommonGoodsAirDelivery();
		String message = goods.transport();
		System.out.println(message);

		goods = new ExpressGoodsTrainDelivery();
		String expressMessage = goods.transport();
		System.out.println(expressMessage);

	}
}