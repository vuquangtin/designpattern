package designpatternsproject.shapes.point;

import designpatternsproject.model.ShapeModel;
import designpatternsproject.shapes.Command;
import designpatternsproject.util.Logger;

public class RemovePoint implements Command {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5691468685793918184L;
	private ShapeModel model;
	private Point point;

	public RemovePoint(ShapeModel model, Point point) {
		this.model = model;
		this.point = point;
	}

	@Override
	public void execute() {
		Logger.getInstance().log(getClass().getSimpleName() + "_execute", model.getShapeIndex(point), point.toString(),
				true);
		model.remove(point);
	}

	@Override
	public void unexecute() {
		model.add(point);
		Logger.getInstance().log(getClass().getSimpleName() + "_unexecute", model.getShapeIndex(point),
				point.toString(), true);
	}
}
