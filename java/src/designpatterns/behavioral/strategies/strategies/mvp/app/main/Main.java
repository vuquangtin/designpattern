package strategies.mvp.app.main;

import javax.swing.SwingUtilities;

import strategies.mvp.app.model.Model;
import strategies.mvp.app.presenter.Presenter;
import strategies.mvp.app.view.View;

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
public class Main {
	public static final String PATH_CONTENT = "java/resources/com/resources/content/";

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			View view = new View();
			view.setPresenter(new Presenter(view, new Model()));
			view.setVisible(true);

		});
	}
}
