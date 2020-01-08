package commands;

import geometry.Circle;
import geometry.Command;

public class CmdUpdateCircle implements Command{

	private Circle oldState;
	private Circle newState;
	private Circle originalState;
	private boolean option;
	private String commandLog;
	
	
	public CmdUpdateCircle(Circle oldState, Circle newState, boolean option) {
		this.oldState = oldState;
		this.newState = newState;
		this.option = option;
	}

	@Override
	public void execute() {
		originalState = (Circle) oldState.clone();
		//true --> MoveTo()
		if(option)
			oldState.moveTo(newState.getCenter().getX(), newState.getCenter().getY());
		else
			oldState.moveBy(newState.getCenter().getX(), newState.getCenter().getY());
		oldState.setRadius(newState.getRadius());
		oldState.setColor(newState.getColor());
		oldState.setInnerColor(newState.getInnerColor());
		
		commandLog= "UPDATECIRCLE" + "_EXECUTE_"+ originalState + "->" + oldState;
	}

	@Override
	public void unexecute() {
		oldState.getCenter().setX(originalState.getCenter().getX());
		oldState.getCenter().setY(originalState.getCenter().getY());
		oldState.setRadius(originalState.getRadius());
		oldState.setColor(originalState.getColor());
		oldState.setInnerColor(originalState.getInnerColor());
		
		commandLog= "UPDATECIRCLE" + "_UNEXECUTE_"+ oldState + "->" + originalState;
		
	}

	public String getCommandLog() {
		return commandLog;
	}

	public void setCommandLog(String commandLog) {
		this.commandLog = commandLog;
	}

}
