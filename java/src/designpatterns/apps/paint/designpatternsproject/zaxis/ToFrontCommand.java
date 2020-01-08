package designpatternsproject.zaxis;

import designpatternsproject.app.MainFrame;
import designpatternsproject.model.ShapeModel;
import designpatternsproject.shapes.Command;
import designpatternsproject.shapes.Shape;
import designpatternsproject.util.Logger;
import designpatternsproject.util.ZAxisHelper;

public class ToFrontCommand implements Command {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7066997025909178409L;

	private ShapeModel model;
	private MainFrame frame;
	private Shape shape;

	public ToFrontCommand(ShapeModel model, MainFrame frame) {
		this.model = model;
		this.frame = frame;
		shape = ZAxisHelper.getSelectedShape(model);
	}

	@Override
	public void execute() {
		ZAxisHelper.doToFront(model.getShapeIndex(shape), model, frame);

		Logger.getInstance().log(getClass().getSimpleName() + "_execute",
				model.get(model.getShapeIndex(shape)).toString(), true, true);
	}

	@Override
	public void unexecute() {
		ZAxisHelper.doToBack(model.getShapeIndex(shape), model, frame);

		Logger.getInstance().log(getClass().getSimpleName() + "_unexecute",
				model.get(model.getShapeIndex(shape)).toString(), true, true);
	}

}
