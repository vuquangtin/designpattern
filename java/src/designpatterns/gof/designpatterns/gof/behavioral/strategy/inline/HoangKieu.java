package designpatterns.gof.behavioral.strategy.inline;

/**
 * <h1>Strategy</h1> Định nghĩa tập hợp các thuật toán, đóng gói từng thuật toán
 * lại, và làm chúng hoán đổi lẫn nhau. Strategy cho phép thuật toán biến đổi
 * độc lập khi người dùng sử dụng chúng.
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/designpattern">https://github.com
 * 
 *      /vuquangtin/designpattern</a>
 *
 */
public class HoangKieu {

	public static void main(String[] args) {

		DaiLyMoiGioi daily = new DaiLyMoiGioi();

		// we could assume context is already set by preferences

		daily.setShowHangStrategy(new ThuyTop());

		daily.checkHang();

	}

	public interface IShow {

		public void showHang();

	}

	public class NgocTrinh implements IShow {

		public void showHang() {

			// show Da trắng

		}

	}

	public static class ThuyTop implements IShow {

		public void showHang() {

			// show Ngực Khủng

		}

	}

	public class LinhMuu implements IShow {

		public void showHang() {

			// show Chan dai

		}

	}

	public static class DaiLyMoiGioi {

		private IShow strategy;

		// this can be set at runtime by the application preferences

		public void setShowHangStrategy(IShow strategy) {

			this.strategy = strategy;

		}

		// use the strategy

		public void checkHang() {

			strategy.showHang();

		}

	}

}