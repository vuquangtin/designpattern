package designpatternsproject.zaxis;

import designpatternsproject.app.MainFrame;
import designpatternsproject.model.ShapeModel;
import designpatternsproject.shapes.Command;
import designpatternsproject.shapes.Shape;
import designpatternsproject.util.Logger;
import designpatternsproject.util.ZAxisHelper;

public class ToBackCommand implements Command {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7699736277398433843L;
	private ShapeModel model;
	private MainFrame frame;
	private Shape shape;

	public ToBackCommand(ShapeModel model, MainFrame frame) {
		this.model = model;
		this.frame = frame;
		shape = ZAxisHelper.getSelectedShape(model);
	}

	@Override
	public void execute() {
		ZAxisHelper.doToBack(model.getShapeIndex(shape), model, frame);

		Logger.getInstance().log(getClass().getSimpleName() + "_execute",
				model.get(model.getShapeIndex(shape)).toString(), true, true);
	}

	@Override
	public void unexecute() {
		ZAxisHelper.doToFront(model.getShapeIndex(shape), model, frame);

		Logger.getInstance().log(getClass().getSimpleName() + "_unexecute",
				model.get(model.getShapeIndex(shape)).toString(), true, true);
	}

}
