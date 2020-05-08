package designpatterns.gof.book.inline;

import java.util.List;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;

import designpatterns.gof.book.inline.DesignPatternContants.Pattern;

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
@DesignPattern(value = Pattern.Observer, description = "观察者")
public class ObserverPattern implements DesignPatternClient {

	/** 主题：模型 */
	private abstract class Model {
		/** 观察者列表 */
		protected List<View> views = Lists.newArrayList();

		/** 添加观察者 */
		public void attach(View view) {
			views.add(view);
		}

		/** 移除观察者 */
		public void detach(View view) {
			views.remove(view);
		}

		/** 通知所有观察者更新，观察者不应该调用这个方法 */
		protected void _notifyAll() {
			for (View view : views) {
				view.update();
			}
		}
	}

	/** 具体主题：数据模型 */
	private class DataModel extends Model {
		/** 主题状态 */
		private List<Integer> records = Lists.newArrayList();

		public List<Integer> getRecords() {
			return records;
		}

		public void setRecords(List<Integer> records) {
			this.records = records;
			super._notifyAll();// 通知
		}

		@Override
		public String toString() {
			return MoreObjects.toStringHelper(this).omitNullValues()
					.add("records", records).toString();
		}

	}

	/** 观察者：视图 */
	private interface View {
		/** 更新 */
		public void update();
	}

	private abstract class ViewInnerState {
		/** 对具体主题的引用 */
		protected DataModel dataModel;

		/** 内部状态 */
		protected List<Integer> state;

		/** 单个观察者的更新 */
		public void updateInnerState(List<Integer> state) {
			this.state = state;
			/** 更新数据模型 */
			dataModel.setRecords(state);
		}

		protected List<Integer> getInnerState() {
			return state;
		}
	}

	/** 表格 */
	private class TableView extends ViewInnerState implements View {
		public TableView(DataModel dataModel) {
			this.dataModel = dataModel;
		}

		@Override
		public void update() {
			state = this.dataModel.getRecords();
			System.out.println("TableView updated: " + dataModel);
		}
	}

	/** 饼图 */
	private class PieView extends ViewInnerState implements View {
		public PieView(DataModel dataModel) {
			this.dataModel = dataModel;
		}

		@Override
		public void update() {
			System.out.println("PieView updated: " + dataModel);
		}
	}

	/** 柱状图 */
	private class HistogramView extends ViewInnerState implements View {
		public HistogramView(DataModel dataModel) {
			this.dataModel = dataModel;
		}

		@Override
		public void update() {
			System.out.println("HistogramView updated: " + dataModel);
		}
	}

	@Override
	public void usage() {
		// 1 主动更新
		DataModel dataModel = new DataModel();

		TableView tableView = new TableView(dataModel);
		PieView pieView = new PieView(dataModel);
		HistogramView histogramView = new HistogramView(dataModel);

		dataModel.attach(tableView);
		dataModel.attach(pieView);
		dataModel.attach(histogramView);

		List<Integer> records = Lists.newArrayList(1, 2, 3, 4, 5);
		dataModel.setRecords(records);

		System.out.println();

		// 2 被动更新
		dataModel.detach(pieView);
		tableView.updateInnerState(Lists.newArrayList(1, 2, 3, 4, 6));
		System.out.println(tableView.getInnerState());
	}

	public static void main(String[] args) {
		new ObserverPattern().usage();
	}
}