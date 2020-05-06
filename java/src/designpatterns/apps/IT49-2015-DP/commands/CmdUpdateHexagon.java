package commands;

import adapter.HexagonAdapter;
import geometry.Command;

public class CmdUpdateHexagon implements Command {

	private HexagonAdapter oldState;
	private HexagonAdapter newState;
	private HexagonAdapter originalState;
	private boolean option;
	private String commandLog;

	public CmdUpdateHexagon(HexagonAdapter oldState, HexagonAdapter newState, boolean option) {
		this.oldState = oldState;
		this.newState = newState;
		this.option = option;
	}

	@Override
	public void execute() {
		originalState = oldState.clone();
		//true --> MoveTo()
		if(option)
			oldState.moveTo(newState.getHexagon().getX(), newState.getHexagon().getY());
		else
			oldState.moveBy(newState.getHexagon().getX(), newState.getHexagon().getY());
		oldState.setR(newState.getR());
		oldState.setEdgeColor(newState.getEdgeColor());
		oldState.setAreaColor(newState.getAreaColor());
		commandLog = "UPDATEHEX" + "_EXECUTE_" + originalState + "->" + oldState;
	}

	@Override
	public void unexecute() {
		oldState.getHexagon().setX(originalState.getHexagon().getX());
		oldState.getHexagon().setY(originalState.getHexagon().getY());
		oldState.setR(originalState.getR());
		oldState.setEdgeColor(originalState.getEdgeColor());
		oldState.setAreaColor(originalState.getAreaColor());
		commandLog= "UPDATEHEX" + "_UNEXECUTE_"+ oldState + "->" + originalState;
	}

	public String getCommandLog() {
		return commandLog;
	}

	public void setCommandLog(String commandLog) {
		this.commandLog = commandLog;
	}
	

}
