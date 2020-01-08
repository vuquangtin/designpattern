package designpatternsproject.shapes.hexagon;

import hexagon.Hexagon;

import java.awt.Color;

import designpatternsproject.shapes.Command;
import designpatternsproject.util.Logger;

public class UpdateHexagonAdapter implements Command {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6579972934064154290L;
	private HexagonAdapter original;
	private HexagonAdapter newState;
	private HexagonAdapter oldState = new HexagonAdapter(new Hexagon(0, 0, 0), Color.BLACK, Color.BLACK);
	private int shapeId;

	public UpdateHexagonAdapter(HexagonAdapter original, HexagonAdapter newState, int shapeId) {
		this.original = original;
		this.newState = newState;
		this.shapeId = shapeId;
	}

	@Override
	public void execute() {
		oldState.getHexagon().setX(original.getHexagon().getX());
		oldState.getHexagon().setY(original.getHexagon().getY());
		oldState.getHexagon().setR(original.getHexagon().getR());
		oldState.setColor(original.getColor());
		oldState.setInnerColor(original.getInnerColor());

		original.getHexagon().setX(newState.getHexagon().getX());
		original.getHexagon().setY(newState.getHexagon().getY());
		original.getHexagon().setR(newState.getHexagon().getR());
		original.setColor(newState.getColor());
		original.setInnerColor(newState.getInnerColor());

		Logger.getInstance().log(getClass().getSimpleName() + "_execute", shapeId, newState.toString(), true);
	}

	@Override
	public void unexecute() {
		original.getHexagon().setX(oldState.getHexagon().getX());
		original.getHexagon().setY(oldState.getHexagon().getY());
		original.getHexagon().setR(oldState.getHexagon().getR());
		original.setColor(oldState.getColor());
		original.setInnerColor(oldState.getInnerColor());

		Logger.getInstance().log(getClass().getSimpleName() + "_unexecute", shapeId, original.toString(), true);
	}

}
