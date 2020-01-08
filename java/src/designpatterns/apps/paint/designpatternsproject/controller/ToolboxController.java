package designpatternsproject.controller;

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.MouseEvent;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JColorChooser;

import designpatternsproject.app.MainFrame;
import designpatternsproject.model.ShapeModel;
import designpatternsproject.shapes.Command;
import designpatternsproject.shapes.Shape;
import designpatternsproject.shapes.ShapeObserver;
import designpatternsproject.shapes.circle.Circle;
import designpatternsproject.shapes.circle.RemoveCircle;
import designpatternsproject.shapes.circle.UpdateCircle;
import designpatternsproject.shapes.hexagon.HexagonAdapter;
import designpatternsproject.shapes.hexagon.RemoveHexagonAdapter;
import designpatternsproject.shapes.hexagon.UpdateHexagonAdapter;
import designpatternsproject.shapes.line.Line;
import designpatternsproject.shapes.line.RemoveLine;
import designpatternsproject.shapes.line.UpdateLine;
import designpatternsproject.shapes.point.Point;
import designpatternsproject.shapes.point.RemovePoint;
import designpatternsproject.shapes.point.UpdatePoint;
import designpatternsproject.shapes.rectangle.Rectangle;
import designpatternsproject.shapes.rectangle.RemoveRectangle;
import designpatternsproject.shapes.rectangle.UpdateRectangle;
import designpatternsproject.shapes.square.RemoveSquare;
import designpatternsproject.shapes.square.Square;
import designpatternsproject.shapes.square.UpdateSquare;
import designpatternsproject.util.DialogsHelper;
import designpatternsproject.util.Logger;
import designpatternsproject.util.UndoRedoHelper;
import designpatternsproject.util.modifyDialogs.CircleModifyDialog;
import designpatternsproject.util.modifyDialogs.HexagonModifyDialog;
import designpatternsproject.util.modifyDialogs.LineModifyDialog;
import designpatternsproject.util.modifyDialogs.PointModifyDialog;
import designpatternsproject.util.modifyDialogs.RectangleModifyDialog;
import designpatternsproject.util.modifyDialogs.SquareModifyDialog;

public class ToolboxController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2584337498381831016L;
	ShapeModel model;
	MainFrame frame;

	public ToolboxController(ShapeModel model, MainFrame frame) {
		this.model = model;
		this.frame = frame;
	}

	/**
	 * Will handle event of clicking undo button
	 */
	public void handleUndoBtn() {
		if (!frame.getHeaderWrapperView().getToolboxView().getBtnUndo().isEnabled())
			return;
		UndoRedoHelper.undoAction(model.getUndoStack(), model.getRedoStack());
		frame.repaint();
	}

	/**
	 * Will handle event of clicking redo button
	 */
	public void handleRedoBtn() {
		if (!frame.getHeaderWrapperView().getToolboxView().getBtnRedo().isEnabled())
			return;
		UndoRedoHelper.redoAction(model.getUndoStack(), model.getRedoStack());
		frame.repaint();
	}

	/**
	 * Will handle event of selecting shape
	 * 
	 * @param e
	 */
	public void handleSelect(MouseEvent e) {
		if (!frame.getHeaderWrapperView().getToolboxView().getTglBtnSelect().isEnabled())
			return;

		boolean shapeFound = false;
		for (int i = model.getShapesList().size() - 1; i >= 0; i--) {
			Shape s = model.getShapesList().get(i);
			if (s.contains(e.getX(), e.getY()) && !s.isSelected()) {
				s.setSelected(true);
				Logger.getInstance().log("[INFO] SELECTED", s.toString(), true);
				frame.repaint();
				shapeFound = true;
				break;
			}
		}
		if (!shapeFound) {
			Logger.getInstance().log(String.format("No shapes found at location (%d,%d)", e.getX(), e.getY()), true,
					true);
			for (Shape s : model.getShapesList()) {
				s.setSelected(false);
				frame.repaint();
			}
		}
	}

	/**
	 * Returns selected shape from shape list
	 * 
	 * @return Shape
	 */
	private Shape getSelectedShape() {
		for (Shape s : model.getShapesList()) {
			if (s.isSelected())
				return s;
		}
		return null;
	}

	/**
	 * Will handle event of shape modify
	 */
	public void handleModify() {
		if (!frame.getHeaderWrapperView().getToolboxView().getBtnModify().isEnabled())
			return;

		Shape selected = getSelectedShape();
		if (selected != null && selected instanceof Shape) {
			if (selected instanceof Point) {
				Point selectedPt = (Point) selected;
				PointModifyDialog modifyDialog = new PointModifyDialog(selectedPt);
				Point modifiedPt = modifyDialog.getPt();
				modifiedPt.setObserver(new ShapeObserver(frame, model));
				if (!selectedPt.equals(modifiedPt) || selectedPt.getColor() != modifiedPt.getColor()) {
					Command updatePt = new UpdatePoint(selectedPt, modifiedPt, model.getShapeIndex(selectedPt));
					model.getUndoStack().offerLast(updatePt);
					updatePt.execute();
					frame.repaint();
				}
			} else if (selected instanceof Line) {
				Line selectedLine = (Line) selected;
				LineModifyDialog modifyDialog = new LineModifyDialog(selectedLine);
				Line modifiedLine = modifyDialog.getLine();
				modifiedLine.setObserver(new ShapeObserver(frame, model));
				if (!selectedLine.equals(modifiedLine) || selectedLine.getColor() != modifiedLine.getColor()) {
					Command updateLine = new UpdateLine(selectedLine, modifiedLine, model.getShapeIndex(selectedLine));
					model.getUndoStack().offerLast(updateLine);
					updateLine.execute();
					frame.repaint();
				}
			} else if (selected instanceof Circle) {
				Circle selectedCircle = (Circle) selected;
				CircleModifyDialog modifyDialog = new CircleModifyDialog(selectedCircle);
				Circle modifiedCircle = modifyDialog.getCircle();
				modifiedCircle.setObserver(new ShapeObserver(frame, model));
				if (!selectedCircle.equals(modifiedCircle) || selectedCircle.getColor() != modifiedCircle.getColor()
						|| selectedCircle.getInnerColor() != modifiedCircle.getInnerColor()) {
					Command updateCircle = new UpdateCircle(selectedCircle, modifiedCircle,
							model.getShapeIndex(selectedCircle));
					model.getUndoStack().offerLast(updateCircle);
					updateCircle.execute();
					frame.repaint();
				}
			} else if (selected instanceof Rectangle) {
				Rectangle selectedRectangle = (Rectangle) selected;
				RectangleModifyDialog modifyDialog = new RectangleModifyDialog(selectedRectangle);
				Rectangle modifiedRectangle = modifyDialog.getRectangle();
				if (!selectedRectangle.equals(modifiedRectangle)
						|| selectedRectangle.getColor() != modifiedRectangle.getColor()
						|| selectedRectangle.getInnerColor() != modifiedRectangle.getInnerColor()) {
					Command updateRectangle = new UpdateRectangle(selectedRectangle, modifiedRectangle,
							model.getShapeIndex(selectedRectangle));
					model.getUndoStack().offerLast(updateRectangle);
					updateRectangle.execute();
					frame.repaint();
				}

			} else if (selected instanceof Square) {
				Square selectedSquare = (Square) selected;
				SquareModifyDialog modifyDialog = new SquareModifyDialog(selectedSquare);
				Square modifiedSquare = modifyDialog.getSquare();
				modifiedSquare.setObserver(new ShapeObserver(frame, model));
				if (!selectedSquare.equals(modifiedSquare) || selectedSquare.getColor() != modifiedSquare.getColor()
						|| selectedSquare.getInnerColor() != modifiedSquare.getInnerColor()) {
					Command updateSquare = new UpdateSquare(selectedSquare, modifiedSquare,
							model.getShapeIndex(selectedSquare));
					model.getUndoStack().offerLast(updateSquare);
					updateSquare.execute();
					frame.repaint();
				}
			} else if (selected instanceof HexagonAdapter) {
				HexagonAdapter selectedHexagon = (HexagonAdapter) selected;
				HexagonModifyDialog modifyDialog = new HexagonModifyDialog(selectedHexagon);
				HexagonAdapter modifiedHexagonAdapter = modifyDialog.getHexagonAdapter();
				modifiedHexagonAdapter.setObserver(new ShapeObserver(frame, model));
				if (!selectedHexagon.equals(modifiedHexagonAdapter)
						|| selectedHexagon.getColor() != modifiedHexagonAdapter.getColor()
						|| selectedHexagon.getInnerColor() != modifiedHexagonAdapter.getInnerColor()) {
					Command updateHexagonAdapter = new UpdateHexagonAdapter(selectedHexagon, modifiedHexagonAdapter,
							model.getShapeIndex(selectedHexagon));
					model.getUndoStack().offerLast(updateHexagonAdapter);
					updateHexagonAdapter.execute();
					frame.repaint();
				}
			}
		}
	}

	/**
	 * Will check if there are any selected shapes in list and delete them
	 */
	public void handleDelete() {
		if (!frame.getHeaderWrapperView().getToolboxView().getBtnDelete().isEnabled())
			return;

		ArrayList<Shape> shapesToDelete = new ArrayList<Shape>();
		for (Shape s : model.getShapesList()) {
			if (s.isSelected())
				shapesToDelete.add(s);
		}
		if (shapesToDelete.size() == 0)
			return;
		else if (shapesToDelete.size() == 1) {

			Command removeCmd = null;
			Boolean confirmed = false;
			// Detect what kind of shape is to be deleted
			if (shapesToDelete.get(0) instanceof Point) {
				removeCmd = new RemovePoint(model, (Point) shapesToDelete.get(0));
				confirmed = DialogsHelper
						.askUserToConfirm("Are you sure you want to remove this " + Point.class.getSimpleName() + "?");
			} else if (shapesToDelete.get(0) instanceof Line) {
				removeCmd = new RemoveLine(model, (Line) shapesToDelete.get(0));
				confirmed = DialogsHelper
						.askUserToConfirm("Are you sure you want to remove this " + Line.class.getSimpleName() + "?");
			} else if (shapesToDelete.get(0) instanceof Circle) {
				removeCmd = new RemoveCircle(model, (Circle) shapesToDelete.get(0));
				confirmed = DialogsHelper
						.askUserToConfirm("Are you sure you want to remove this " + Circle.class.getSimpleName() + "?");
			} else if (shapesToDelete.get(0) instanceof Rectangle) {
				removeCmd = new RemoveRectangle(model, (Rectangle) shapesToDelete.get(0));
				confirmed = DialogsHelper.askUserToConfirm(
						"Are you sure you want to remove this " + Rectangle.class.getSimpleName() + "?");
			} else if (shapesToDelete.get(0) instanceof Square) {
				removeCmd = new RemoveSquare(model, (Square) shapesToDelete.get(0));
				confirmed = DialogsHelper
						.askUserToConfirm("Are you sure you want to remove this " + Square.class.getSimpleName() + "?");
			} else if (shapesToDelete.get(0) instanceof HexagonAdapter) {
				removeCmd = new RemoveHexagonAdapter(model, (HexagonAdapter) shapesToDelete.get(0));
				confirmed = DialogsHelper.askUserToConfirm("Are you sure you want to remove this "
						+ ((HexagonAdapter) shapesToDelete.get(0)).getHexagon().getClass().getSimpleName() + "?");
			}

			// If user confirmed popup (JOptionPane)
			if (confirmed) {
				shapesToDelete.get(0).setSelected(false);
				model.getUndoStack().offerLast(removeCmd);
				removeCmd.execute();
				frame.repaint();
			}

		} else { // Will get to else if there are more than 1 shapes to remove

			if (DialogsHelper.askUserToConfirm(String.format(
					"You selected %d shapes, are you sure you want to delete them all?", shapesToDelete.size()))) {
				Command removeCmd = null;
				for (Shape s : shapesToDelete) {
					s.setSelected(false); // Fix UNDO getting selected shape
					if (s instanceof Point) {
						removeCmd = new RemovePoint(model, (Point) s);
					} else if (s instanceof Line) {
						removeCmd = new RemoveLine(model, (Line) s);
					} else if (s instanceof Circle) {
						removeCmd = new RemoveCircle(model, (Circle) s);
					} else if (s instanceof Rectangle) {
						removeCmd = new RemoveRectangle(model, (Rectangle) s);
					} else if (s instanceof Square) {
						removeCmd = new RemoveSquare(model, (Square) s);
					} else if (s instanceof HexagonAdapter) {
						removeCmd = new RemoveHexagonAdapter(model, (HexagonAdapter) s);
					}

					model.getUndoStack().offerLast(removeCmd);
					removeCmd.execute();
				}
				frame.repaint();
			}
		}
	}

	/**
	 * Will handle event when select button changes its state Exits from select mode
	 * when button is not toggled, de-selects all shapes
	 * 
	 * @param ev
	 */
	public void handleSelectBtnStateChange(ItemEvent ev) {
		if (ev.getStateChange() == ItemEvent.SELECTED) {
			Logger.getInstance().log("Entering select mode", true, true);
		} else if (ev.getStateChange() == ItemEvent.DESELECTED) {
			Logger.getInstance().log("Exiting select mode", true, true);
			for (Shape s : model.getShapesList()) {
				if (s != null)
					s.setSelected(false);
			}
			frame.repaint();
			Logger.getInstance().log("All shapes have been de-selected", true, true);
		}
	}

	/**
	 * Will set background color of button based on chosen color in JColorChooser If
	 * color is not chosen, it will return current color
	 * 
	 * @param btn
	 */
	public void handleColorButtonClick(JButton btn) {
		if (!btn.isEnabled())
			return;

		Color newColor = JColorChooser.showDialog(btn, "Choose color", btn.getBackground());
		btn.setBackground((newColor != null) ? newColor : btn.getBackground());
	}

	/**
	 * Will disable Inner Color button if point or line is selected, because they
	 * don't have inner color
	 */
	public void handleShapePickerChange() {
		boolean isPointActive = frame.getShapePickerView().getRdbtnPoint().isSelected();
		boolean isLineActive = frame.getShapePickerView().getRdbtnLine().isSelected();
		if (isLineActive || isPointActive) {
			frame.getHeaderWrapperView().getToolboxView().getBtnInnerColor().setEnabled(false);
			frame.repaint();
		} else {
			frame.getHeaderWrapperView().getToolboxView().getBtnInnerColor().setEnabled(true);
		}
		// Disable select mode so shapes can be drawn again
		frame.getHeaderWrapperView().getToolboxView().getTglbtnSelect().setSelected(false);
	}
}
