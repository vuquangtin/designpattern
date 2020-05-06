package designpatterns.gof.structural.bridge.doesnot;
/**
 * <h1>Bridge</h1> Tách một abstraction khỏi implementation của nó để cả hai có
 * thể thay đổi độc lập nhau.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com

 *      /vuquangtin/designpattern</a>
 *
 */
public class ExpressGoodsTrainDelivery implements ExpressGoods {
    @Override
    public String speedUp() {
        return "运输加速，";
    }

    @Override
    public String transport() {
        return speedUp() + "使用火车运输货物";
    }
}