package commands;

import geometry.Command;
import geometry.Shape;
import model.DrawingModel;

public class CmdToBack implements Command {
	private Shape shape;
	private DrawingModel model;
	private int index;
	private String commandLog;

	public CmdToBack(Shape shape, DrawingModel model) {
		this.shape = shape;
		this.model = model;
	}

	@Override
	public void execute() {
		index = model.getIndexOfShape(shape);
		model.removeShapeAtIndex(index);
		model.addShapeToIndex(index-1, shape);
		commandLog = "ToBack" + "_EXECUTE_" + shape;
	}

	@Override
	public void unexecute() {
		model.removeShapeAtIndex(index - 1);
		model.addShapeToIndex(index, shape);
		commandLog = "ToBack" + "_UNEXECUTE_" + shape;

	}

	public String getCommandLog() {
		return commandLog;
	}

	public void setCommandLog(String commandLog) {
		this.commandLog = commandLog;
	}

}
