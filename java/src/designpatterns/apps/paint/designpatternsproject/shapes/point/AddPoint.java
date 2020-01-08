package designpatternsproject.shapes.point;

import designpatternsproject.model.ShapeModel;
import designpatternsproject.shapes.Command;
import designpatternsproject.util.Logger;

public class AddPoint implements Command {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7780529610976885676L;
	private ShapeModel model;
	private Point point;

	public AddPoint(ShapeModel model, Point point) {
		this.model = model;
		this.point = point;
	}

	@Override
	public void execute() {
		model.add(point);
		Logger.getInstance().log(getClass().getSimpleName() + "_execute", model.getShapeIndex(point), point.toString(),
				true);
	}

	@Override
	public void unexecute() {
		Logger.getInstance().log(getClass().getSimpleName() + "_unexecute", model.getShapeIndex(point),
				point.toString(), true);
		model.remove(point);
	}
}
