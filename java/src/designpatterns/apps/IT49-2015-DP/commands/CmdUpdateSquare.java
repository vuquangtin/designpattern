package commands;

import geometry.Command;
import geometry.Square;

public class CmdUpdateSquare implements Command {

	private Square oldState;
	private Square newState;
	private Square originalState;
	private boolean option;
	private String commandLog;
	
	public CmdUpdateSquare(Square oldState, Square newState, boolean option) {
		this.oldState=oldState;
		this.newState=newState;
		this.option = option;
	}
	@Override
	public void execute() {
		originalState = (Square) oldState.clone();
		//true --> MoveTo()
		if(option)
			oldState.moveTo(newState.getUpperLeft().getX(), newState.getUpperLeft().getY());
		else
			oldState.moveBy(newState.getUpperLeft().getX(), newState.getUpperLeft().getY());
		oldState.setSideLength(newState.getSideLength());
		oldState.setColor(newState.getColor());
		oldState.setInnerColor(newState.getInnerColor());
		commandLog = "UPDATESQUARE" + "_EXECUTE_" + originalState + "->" + oldState;
	}

	@Override
	public void unexecute() {
		oldState.getUpperLeft().setX(originalState.getUpperLeft().getX());
		oldState.getUpperLeft().setY(originalState.getUpperLeft().getY());
		oldState.setSideLength(originalState.getSideLength());
		oldState.setColor(originalState.getColor());
		oldState.setInnerColor(originalState.getInnerColor());
		commandLog = "UPDATESQUARE" + "_UNEXECUTE_" + oldState + "->" + originalState;
	}
	public String getCommandLog() {
		return commandLog;
	}
	public void setCommandLog(String commandLog) {
		this.commandLog = commandLog;
	}
	

}
