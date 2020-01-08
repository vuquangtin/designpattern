package commands;

import geometry.Command;
import geometry.Rectangle;

public class CmdUpdateRectangle implements Command {

	private Rectangle oldState;
	private Rectangle newState;
	private Rectangle originalState;
	private boolean option;
	private String commandLog;

	public CmdUpdateRectangle(Rectangle oldState, Rectangle newState, boolean option) {
		this.oldState = oldState;
		this.newState = newState;
		this.option = option;
	}

	@Override
	public void execute() {
		originalState = oldState.clone();
		//true --> MoveTo();
		if(option) 
			oldState.moveTo(newState.getUpperLeft().getX(), newState.getUpperLeft().getY());
		else
			oldState.moveBy(newState.getUpperLeft().getX(), newState.getUpperLeft().getY());
		oldState.setSideLength(newState.getSideLength());
		oldState.setWidth(newState.getWidth());
		oldState.setColor(newState.getColor());
		oldState.setInnerColor(newState.getInnerColor());
		commandLog = "UPDATEREC" + "_EXECUTE_" + originalState + "->" + oldState;
	}

	@Override
	public void unexecute() {
		oldState.getUpperLeft().setX(originalState.getUpperLeft().getX());
		oldState.getUpperLeft().setY(originalState.getUpperLeft().getY());
		oldState.setSideLength(originalState.getSideLength());
		oldState.setWidth(originalState.getWidth());
		oldState.setColor(originalState.getColor());
		oldState.setInnerColor(originalState.getInnerColor());
		commandLog = "UPDATEREC" + "_UNEXECUTE_" + oldState + "->" + originalState;
	}

	public String getCommandLog() {
		return commandLog;
	}

	public void setCommandLog(String commandLog) {
		this.commandLog = commandLog;
	}

}
