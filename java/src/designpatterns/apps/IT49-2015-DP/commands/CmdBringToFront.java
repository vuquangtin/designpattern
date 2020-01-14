package commands;

import geometry.Command;
import geometry.Shape;
import model.DrawingModel;

public class CmdBringToFront implements Command {
	private Shape shape;
	private DrawingModel model;
	private int size;
	private int index;
	private String commandLog;
	
	public CmdBringToFront(Shape shape, DrawingModel model, int size) {
		this.shape = shape;
		this.model = model;
		this.size = size;
	}
	
	
	@Override
	public void execute() {
		index = model.getIndexOfShape(shape);
		model.removeShapeAtIndex(index);
		model.addShapeToIndex(size, shape);
		commandLog = "BringToFront"+"_EXECUTE_"+shape;
		
	}

	@Override
	public void unexecute() {
		model.removeShapeAtIndex(size);
		model.addShapeToIndex(index, shape);
		commandLog = "BringToFront"+"_UNEXECUTE_"+shape;
		
	}


	public String getCommandLog() {
		return commandLog;
	}


	public void setCommandLog(String commandLog) {
		this.commandLog = commandLog;
	}
	
}
