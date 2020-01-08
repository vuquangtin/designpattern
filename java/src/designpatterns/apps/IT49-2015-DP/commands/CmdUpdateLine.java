package commands;


import geometry.Command;
import geometry.Line;
import geometry.Point;

public class CmdUpdateLine implements Command {

	private Line oldState;
	private Point tmpValues;
	private Line originalState;
	private String commandLog;

	public CmdUpdateLine(Line oldState, Point tmpValues) {
		this.oldState = oldState;
		this.tmpValues = tmpValues;
	}

	@Override
	public void execute() {
		originalState = (Line) oldState.clone();
		oldState.moveBy(tmpValues.getX(), tmpValues.getY());
		oldState.setColor(tmpValues.getColor());
		commandLog = "UPDATELINE" + "_EXECUTE_" + originalState + "->" + oldState;
	}

	@Override
	public void unexecute() {
		oldState.getStartPoint().setX(originalState.getStartPoint().getX());
		oldState.getStartPoint().setY(originalState.getStartPoint().getY());
		oldState.getEndPoint().setX(originalState.getEndPoint().getX());
		oldState.getEndPoint().setY(originalState.getEndPoint().getY());
		oldState.setColor(originalState.getColor());
		commandLog= "UPDATELINE" + "_UNEXECUTE_"+ oldState + "->" + originalState;
	}

	public String getCommandLog() {
		return commandLog;
	}

	public void setCommandLog(String commandLog) {
		this.commandLog = commandLog;
	}

}
