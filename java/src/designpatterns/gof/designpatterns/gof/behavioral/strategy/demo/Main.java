package designpatterns.gof.behavioral.strategy.demo;


/**
 * <h1>Strategy</h1> Định nghĩa tập hợp các thuật toán, đóng gói từng thuật toán
 * lại, và làm chúng hoán đổi lẫn nhau. Strategy cho phép thuật toán biến đổi
 * độc lập khi người dùng sử dụng chúng.
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com

 *      /vuquangtin/designpattern</a>
 *
 */

// The classes that implement a concrete strategy should implement this
// The context class uses this to call the concrete strategy
public class Main {
    public static void main(String[] args){
        String type = "满300减100";
        CashContext cc = null;

        switch (type){
            case "正常收费":
                cc = new CashContext(new CashNormal());
                break;
            case "满300减100":
                cc = new CashContext(new CashReturn(300,100));
                break;
            case "打8折":
                cc = new CashContext(new CashRebate(0.8));
                break;
        }

        double resultPrice = cc.GetResult(520);
        System.out.println("最终的价格是："+resultPrice);
    }
}