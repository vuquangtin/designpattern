package designpatternsproject.shapes.line;

import designpatternsproject.model.ShapeModel;
import designpatternsproject.shapes.Command;
import designpatternsproject.util.Logger;

public class AddLine implements Command {
	/**
	 * 
	 */
	private static final long serialVersionUID = 453513436433583837L;
	private ShapeModel model;
	private Line line;

	public AddLine(ShapeModel model, Line line) {
		this.model = model;
		this.line = line;
	}

	@Override
	public void execute() {
		model.add(line);
		Logger.getInstance().log(getClass().getSimpleName() + "_execute", model.getShapeIndex(line), line.toString(),
				true);
	}

	@Override
	public void unexecute() {
		Logger.getInstance().log(getClass().getSimpleName() + "_unexecute", model.getShapeIndex(line), line.toString(),
				true);
		model.remove(line);
	}
}
