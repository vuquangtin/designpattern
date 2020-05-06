package designpatternsproject.controller;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.io.Serializable;

import javax.swing.ButtonModel;

import designpatternsproject.app.MainFrame;
import designpatternsproject.model.ShapeModel;
import designpatternsproject.shapes.Command;
import designpatternsproject.shapes.Shape;
import designpatternsproject.shapes.ShapeObserver;
import designpatternsproject.shapes.circle.AddCircle;
import designpatternsproject.shapes.circle.Circle;
import designpatternsproject.shapes.hexagon.AddHexagonAdapter;
import designpatternsproject.shapes.hexagon.HexagonAdapter;
import designpatternsproject.shapes.line.AddLine;
import designpatternsproject.shapes.line.Line;
import designpatternsproject.shapes.point.AddPoint;
import designpatternsproject.shapes.point.Point;
import designpatternsproject.shapes.rectangle.AddRectangle;
import designpatternsproject.shapes.rectangle.Rectangle;
import designpatternsproject.shapes.square.AddSquare;
import designpatternsproject.shapes.square.Square;
import hexagon.Hexagon;

public class CanvasController implements Serializable {
	private ButtonModel selectedShapeTypeModel;
	private ButtonModel pointModel;
	private ButtonModel lineModel;
	private ButtonModel circleModel;
	private ButtonModel squareModel;
	private ButtonModel rectangleModel;
	private ButtonModel hexagonModel;
	private Point startDrawingPoint;
	private Shape draggedShape;

	/**
	 * 
	 */
	private static final long serialVersionUID = 7683586572386187582L;
	private MainFrame frame;
	private ShapeModel model;

	public CanvasController(MainFrame frame, ShapeModel model) {
		this.frame = frame;
		this.model = model;

		// Get models for shape buttons
		pointModel = frame.getShapePickerView().getRdbtnPoint().getModel();
		lineModel = frame.getShapePickerView().getRdbtnLine().getModel();
		circleModel = frame.getShapePickerView().getRdbtnCircle().getModel();
		squareModel = frame.getShapePickerView().getRdbtnSquare().getModel();
		rectangleModel = frame.getShapePickerView().getRdbtnRectangle().getModel();
		hexagonModel = frame.getShapePickerView().getRdbtnHexagon().getModel();
	}

	/**
	 * Will get called when MousePressed event happened If point is selected it will
	 * draw it and do all other things (Add to UndoStack, repaint, etc) If other
	 * shapes are selected, it will set starting point of shape
	 * 
	 * @param e
	 * @param inner
	 * @param outer
	 */
	public void handleCanvasClick(MouseEvent e, Color inner, Color outer) {

		selectedShapeTypeModel = frame.getShapePickerView().getShapesGrp().getSelection();

		if (selectedShapeTypeModel == pointModel) {
			Point pt = new Point(e.getX(), e.getY(), outer);
			pt.setObserver(new ShapeObserver(frame, model));
			Command point = new AddPoint(model, pt);
			point.execute();
			model.getUndoStack().offerLast(point);

			frame.repaint();
		} else {
			if (startDrawingPoint == null) {
				startDrawingPoint = new Point(e.getX(), e.getY());
			} else {
				startDrawingPoint = null;
			}
		}
	}

	/**
	 * Will get called when MouseDragged event happened Will draw new shape while
	 * mouse is dragged (Something like preview of final shape)
	 * 
	 * @param e
	 * @param inner
	 * @param outer
	 */
	public void handleCanvasDrag(MouseEvent e, Color inner, Color outer) {
		selectedShapeTypeModel = frame.getShapePickerView().getShapesGrp().getSelection();

		int startDist = 0;
		double rawDist = (startDrawingPoint != null) ? startDrawingPoint.distance(new Point(e.getX(), e.getY())) : 0;
		if (rawDist > 0) {
			startDist = (int) rawDist; // distance from initial mouse click
		}

		if (draggedShape != null) {
			model.remove(draggedShape);
			draggedShape = null;
		}
		if (startDrawingPoint == null) {
			startDrawingPoint = new Point(e.getX(), e.getY());
		}
		if (selectedShapeTypeModel == lineModel && startDrawingPoint != null) {
			draggedShape = new Line(startDrawingPoint, new Point(e.getX(), e.getY()), outer);

		} else if (selectedShapeTypeModel == circleModel && startDrawingPoint != null) {
			draggedShape = new Circle(startDrawingPoint, startDist, outer, inner);
		} else if (selectedShapeTypeModel == rectangleModel && startDrawingPoint != null) {
			int startXDist = Math.abs(startDrawingPoint.getX() - e.getX());
			int startYDist = Math.abs(startDrawingPoint.getY() - e.getY());
			draggedShape = new Rectangle(startDrawingPoint, startYDist, startXDist, outer, inner);
		} else if (selectedShapeTypeModel == squareModel && startDrawingPoint != null) {
			draggedShape = new Square(startDrawingPoint, startDist, outer, inner);
		} else if (selectedShapeTypeModel == hexagonModel && startDrawingPoint != null) {
			draggedShape = new HexagonAdapter(
					new Hexagon(startDrawingPoint.getX(), startDrawingPoint.getY(), startDist), outer, inner);
		}
		draggedShape.setObserver(new ShapeObserver(frame, model));
		model.add(draggedShape);
		frame.repaint();
	}

	/**
	 * Will draw final shape when mouse is released (MouseReleased event) Order of
	 * events MousePressed -> MouseDragged -> MouseReleased
	 * 
	 * @param e
	 * @param inner
	 * @param outer
	 */
	public void handleCanvasRelease(MouseEvent e, Color inner, Color outer) {

		selectedShapeTypeModel = frame.getShapePickerView().getShapesGrp().getSelection();

		// Make sure that we have both starting point and dragged shape
		if (startDrawingPoint != null && draggedShape != null) {
			// Remove preview shape
			model.remove(draggedShape);
			frame.repaint();
			// Check what shape is selected
			if (selectedShapeTypeModel == lineModel) {
				// Create new command, execute it, add it to undo stack
				Command addLine = new AddLine(model, (Line) draggedShape);
				addLine.execute();
				model.getUndoStack().offerLast(addLine);

			} else if (selectedShapeTypeModel == circleModel) {
				Command addCircle = new AddCircle(model, (Circle) draggedShape);
				addCircle.execute();
				model.getUndoStack().offerLast(addCircle);
			} else if (selectedShapeTypeModel == rectangleModel) {
				Command addRectangle = new AddRectangle(model, (Rectangle) draggedShape);
				addRectangle.execute();
				model.getUndoStack().offerLast(addRectangle);
			} else if (selectedShapeTypeModel == squareModel) {
				Command addSquare = new AddSquare(model, (Square) draggedShape);
				addSquare.execute();
				model.getUndoStack().offerLast(addSquare);
			} else if (selectedShapeTypeModel == hexagonModel) {
				Command addHexagonAdapter = new AddHexagonAdapter(model, (HexagonAdapter) draggedShape);
				addHexagonAdapter.execute();
				model.getUndoStack().offerLast(addHexagonAdapter);
			}
			// re-draw frame
			frame.repaint();
			// Reset to null so we can draw new shape
			startDrawingPoint = null;
			draggedShape = null;
		}
	}
}