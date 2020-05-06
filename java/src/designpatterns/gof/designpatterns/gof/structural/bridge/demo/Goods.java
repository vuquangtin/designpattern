package designpatterns.gof.structural.bridge.demo;
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
public class Goods {
    private Transport transport;

    public Goods(Transport transport) {
        this.transport = transport;
    }

    public String transport() {
        return transport.transport();
    }
}