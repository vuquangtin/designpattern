package commands;

import model.DrawingModel;
import geometry.Command;
import geometry.Shape;

public class CmdAddShape implements Command {

	private Shape shape;
	private DrawingModel model;
	private String commandLog;

	public CmdAddShape(Shape shape, DrawingModel model) {
		this.shape = shape;
		this.model = model;
	}

	@Override
	public void execute() {
		model.addShape(shape);
		System.out.println("Sledi greska:");
		commandLog = "ADD" + "_EXECUTE_" + shape;
		System.out.println("Evo greske upravo");
		System.out.println(shape);
	}

	@Override
	public void unexecute() {
		model.removeShape(shape);
		commandLog = "ADD" + "_UNEXECUTE_" + shape;

	}

	public Shape getShape() {
		return shape;
	}

	public void setShape(Shape shape) {
		this.shape = shape;
	}

	public String getCommandLog() {
		return commandLog;
	}

	public void setCommandLog(String commandLog) {
		this.commandLog = commandLog;
	}
	

}
