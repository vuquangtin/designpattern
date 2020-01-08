package commands;

import geometry.Command;
import geometry.Point;

public class CmdUpdatePoint implements Command{

	private Point oldState;
	private Point newState;
	private Point originalState;
	private boolean option;
	private String commandLog;

	public CmdUpdatePoint(Point oldState,Point newState, boolean option) {
		this.oldState=oldState;
		this.newState=newState;
		this.option = option;
	}
	@Override
	public void execute() {
		originalState = (Point) oldState.clone();
		//option==true --> MoveTo()
		if(option)
			oldState.moveTo(newState.getX(), newState.getY());
		else
			oldState.moveBy(newState.getX(), newState.getY());
		
		oldState.setColor(newState.getColor());
		commandLog = "UPDATEPOINT" + "_EXECUTE_" + originalState + "->" + oldState;
	}

	@Override
	public void unexecute() {
		oldState.moveTo(originalState.getX(), originalState.getY());
		oldState.setColor(originalState.getColor());
		commandLog = "UPDATEPOINT" + "_UNEXECUTE_" + oldState + "->" + originalState;
	}
	public String getCommandLog() {
		return commandLog;
	}
	public void setCommandLog(String commandLog) {
		this.commandLog = commandLog;
	}

}
