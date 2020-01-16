package observers.app.observerapp;

import java.util.ArrayList;

import observers.app.model.ChartController;
import observers.app.model.ObserverInterface;
import observers.app.view.BarChartUI;

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
public class BarChartController implements ChartController {

	ArrayList<ObserverInterface> monitors = new ArrayList<>();
	BarChartUI bar_ui;

	public BarChartController() {
		bar_ui = new BarChartUI();
		bar_ui.setVisible(true);
		bar_ui.setModel(monitors);
	}

	public void addMonitor(ObserverInterface m) {
		m.setCallback(bar_ui);
		monitors.add(m);
		bar_ui.update();
	}

	public String toString() {
		return "BarChart";
	}

}
