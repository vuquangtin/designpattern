package commands;

import geometry.Command;
import geometry.Shape;
import model.DrawingModel;

public class CmdBringToBack implements Command {
	private Shape shape;
	private DrawingModel model;
	private int index;
	private String commandLog;
	
	public CmdBringToBack(Shape shape, DrawingModel model) {
		this.shape = shape;
		this.model = model;
	}
	@Override
	public void execute() {
		index = model.getIndexOfShape(shape);
		model.removeShapeAtIndex(index);
		model.addShapeToIndex(0, shape);
		commandLog = "BringToBack"+"_EXECUTE_"+shape;
		
	}

	@Override
	public void unexecute() {
		model.removeShapeAtIndex(0);
		model.addShapeToIndex(index, shape);
		commandLog = "BringToBack"+"_UNEXECUTE_"+shape;
		
	}
	public String getCommandLog() {
		return commandLog;
	}
	public void setCommandLog(String commandLog) {
		this.commandLog = commandLog;
	}
	

}
