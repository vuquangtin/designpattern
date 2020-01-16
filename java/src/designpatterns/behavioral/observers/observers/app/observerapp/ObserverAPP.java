package observers.app.observerapp;

import observers.app.model.Stock;

/**
 * <h1>Observer</h1> Định nghĩa một sự phụ thuộc 1-nhiều giữa các đối tượng để
 * khi một đối tượng thay đổi trạng thái, tất cả phụ thuộc của nó được thông báo
 * và cập nhật một cách tự động.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */

public class ObserverAPP {

	public static void main(String[] args) {
		Stock s;
		ObserverController oc = new ObserverController();
		BarChartController bcc = new BarChartController();
		PieChartController pcc = new PieChartController();
		oc.addChart(bcc);
		oc.addChart(pcc);

		s = new Stock("Google");
		oc.addStock(s);
		oc.addMonitor(s, 0);

		s = new Stock("Amazon");
		oc.addStock(s);
		oc.addMonitor(s, 0);

		s = new Stock("IBM");
		oc.addStock(s);
		oc.addMonitor(s, 0);
		oc.addMonitor(s, 1);

		s = new Stock("INTC");
		oc.addStock(s);
		oc.addMonitor(s, 1);

	}

}
