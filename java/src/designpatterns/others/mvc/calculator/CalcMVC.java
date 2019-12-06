package mvc.calculator;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */

public class CalcMVC {
	// ... Create model, view, and controller. They are
	// created once here and passed to the parts that
	// need them so there is only one copy of each.
	@SuppressWarnings("unused")
	public static void main(String[] args) {

		CalcModel model = new CalcModel();
		CalcView view = new CalcView(model);
		CalcController controller = new CalcController(model, view);

		view.setVisible(true);
	}
}