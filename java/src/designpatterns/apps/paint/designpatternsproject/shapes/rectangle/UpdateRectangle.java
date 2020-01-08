package designpatternsproject.shapes.rectangle;

import designpatternsproject.shapes.Command;
import designpatternsproject.shapes.point.Point;
import designpatternsproject.util.Logger;

public class UpdateRectangle implements Command {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7084900106194156145L;

	private Rectangle original;
	private Rectangle newState;
	private Rectangle oldState = new Rectangle(new Point(), 0, 0);
	private int shapeId;

	public UpdateRectangle(Rectangle original, Rectangle newState, int shapeId) {
		this.original = original;
		this.newState = newState;
		this.shapeId = shapeId;
	}

	@Override
	public void execute() {
		oldState.getUpperLeft().setX(original.getUpperLeft().getX());
		oldState.getUpperLeft().setY(original.getUpperLeft().getY());
		oldState.setSideLength(original.getSideLength());
		oldState.setWidth(original.getWidth());
		oldState.setColor(original.getColor());
		oldState.setInnerColor(original.getInnerColor());

		original.getUpperLeft().setX(newState.getUpperLeft().getX());
		original.getUpperLeft().setY(newState.getUpperLeft().getY());
		original.setSideLength(newState.getSideLength());
		original.setWidth(newState.getWidth());
		original.setColor(newState.getColor());
		original.setInnerColor(newState.getInnerColor());

		Logger.getInstance().log(getClass().getSimpleName() + "_execute", shapeId, newState.toString(), true);
	}

	@Override
	public void unexecute() {
		original.getUpperLeft().setX(oldState.getUpperLeft().getX());
		original.getUpperLeft().setY(oldState.getUpperLeft().getY());
		original.setSideLength(oldState.getSideLength());
		original.setWidth(oldState.getWidth());
		original.setColor(oldState.getColor());
		original.setInnerColor(oldState.getInnerColor());

		Logger.getInstance().log(getClass().getSimpleName() + "_unexecute", shapeId, original.toString(), true);
	}
}
