package designpatternsproject.zaxis;

import designpatternsproject.app.MainFrame;
import designpatternsproject.model.ShapeModel;
import designpatternsproject.shapes.Command;
import designpatternsproject.shapes.Shape;
import designpatternsproject.util.Logger;
import designpatternsproject.util.ZAxisHelper;

public class BringToBackCommand implements Command {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1523731526797266070L;
	private int selectedIndex = -1;
	private Shape shape;
	private ShapeModel model;
	private MainFrame frame;

	public BringToBackCommand(int selectedIndex, ShapeModel model, MainFrame frame) {
		this.selectedIndex = selectedIndex;
		this.model = model;
		this.frame = frame;
		this.shape = ZAxisHelper.getSelectedShape(model);
	}

	@Override
	public void execute() {
		ZAxisHelper.doBringToBack(shape, model, frame);

		Logger.getInstance().log(getClass().getSimpleName() + "_execute", shape.toString(), true, true);
	}

	@Override
	public void unexecute() {
		ZAxisHelper.moveShapeToIndex(selectedIndex, shape, model, frame);

		Logger.getInstance().log(getClass().getSimpleName() + "_unexecute", shape.toString(), true, true);
	}

}
