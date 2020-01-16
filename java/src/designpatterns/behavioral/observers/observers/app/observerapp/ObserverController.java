package observers.app.observerapp;

import java.util.ArrayList;

import observers.app.model.ChartController;
import observers.app.model.Monitor;
import observers.app.model.ObservableInterface;
import observers.app.view.ObserverUI;

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
public class ObserverController {
	private ArrayList<ObservableInterface> stocks;
	private ArrayList<ChartController> charts;
	private ObserverUI ui;

	public ObserverController() {
		initialize();
	}

	private void initialize() {
		stocks = new ArrayList<>();
		charts = new ArrayList<>();

		ui = new ObserverUI();
		ui.setModel(stocks, charts);
		ui.setObserverController(this);
		ui.setVisible(true);
	}

	public void addStock(ObservableInterface s) {
		stocks.add(s);
		ui.setModel(stocks, charts);
	}

	public void addChart(ChartController cc) {
		charts.add(cc);
		ui.setModel(stocks, charts);
	}

	public void addMonitor(ObservableInterface s, int chart_id) {
		Monitor m = new Monitor(s);
		charts.get(chart_id).addMonitor(m);
	}

}
