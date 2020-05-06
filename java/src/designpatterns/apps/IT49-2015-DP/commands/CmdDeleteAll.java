package commands;

import java.util.ArrayList;

import geometry.Command;
import geometry.Shape;
import model.DrawingModel;

public class CmdDeleteAll implements Command {

	private DrawingModel model;
	private ArrayList<Shape> listOfShapes;
	private String commandLog;

	public CmdDeleteAll(ArrayList<Shape> list, DrawingModel model) {
		this.listOfShapes = list;
		this.model = model;
	}

	@Override
	public void execute() {
		model.removeMultipleShapes(listOfShapes);
		commandLog = "DELETEshapes"+"_EXECUTE_"+listOfShapes;
	}

	@Override
	public void unexecute() {
		model.addMultipleShapes(listOfShapes);
		commandLog = "DELETEshapes"+"_UNEXECUTE_"+listOfShapes;

	}

	public ArrayList<Shape> getList() {
		return listOfShapes;
	}

	public void setList(ArrayList<Shape> list) {
		this.listOfShapes = list;
	}

	public String getCommandLog() {
		return commandLog;
	}

	public void setCommandLog(String commandLog) {
		this.commandLog = commandLog;
	}
	

}
