package com.db.app.paint.view.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JComponent;

import com.db.app.paint.classes.ShapeFactory;
import com.db.app.paint.model.interfaces.IShape;
import com.db.app.paint.model.persistences.ApplicationState;
import com.db.app.paint.models.DoRedo;
import com.db.app.paint.models.DoUndo;
import com.db.app.paint.models.ShapeColor;
import com.db.app.paint.models.ShapeRepository;
import com.db.app.paint.models.ShapeShadingType;
import com.db.app.paint.models.ShapeType;
import com.db.app.paint.models.StartAndEndPointMode;
import com.db.app.paint.view.interfaces.IPaintCanvas;

@SuppressWarnings("serial")
public class PaintCanvas extends JComponent implements IPaintCanvas {

	public static ArrayList<IShape> shapes = new ArrayList<IShape>();
	public static ArrayList<IShape> bufferShapes,
			selectedShapesList = new ArrayList<IShape>();
	public static ArrayList<ArrayList> relativePositions = new ArrayList<ArrayList>();
	public ApplicationState appstate;
	int x, y, x2, y2;
	public static IShape shapeBeingDragged;

	private boolean shapeSelected = false;

	public static boolean isDragged() {
		return dragged;
	}

	public void setDragged(boolean dragged) {
		PaintCanvas.dragged = dragged;
	}

	private static boolean dragged = false;

	public Graphics2D getGraphics2D() {
		return (Graphics2D) getGraphics();
	}

	private static PaintCanvas instance = new PaintCanvas();

	private PaintCanvas() {
		MyMouseListener listener = new MyMouseListener();
		addMouseListener(listener);
		addMouseMotionListener(listener);
		x = y = x2 = y2 = 0;

	}

	public static PaintCanvas getInstance() {
		return instance;
	}

	public static ArrayList<IShape> getShapes() { // for delete there want
													// static just pub array
		return shapes;
	}

	public void setShapes(ArrayList<IShape> shapes) {
		this.shapes = shapes;
	}

	class MyMouseListener extends MouseAdapter {

		public void mousePressed(MouseEvent e) {
			if (appstate.getActiveStartAndEndPointMode().equals(
					StartAndEndPointMode.MOVE)) {
				setEndPoint(e.getX(), e.getY());
				if (shapeSelected)
					moveShape(selectedShapesList, e.getX(), e.getY());

			}
			if (appstate.getActiveStartAndEndPointMode().equals(
					StartAndEndPointMode.DRAW)) {
				dragged = true;
				setStartPoint(e.getX(), e.getY());
				if (e.getButton() == MouseEvent.BUTTON3) {
					ShapeColor color = appstate.getActivePrimaryColor();
					appstate.setActivePrimaryColorSwitch();
					appstate.setActiveSecondaryColorSwitch(color);
				}
			}
			if (appstate.getActiveStartAndEndPointMode().equals(
					StartAndEndPointMode.SELECT)) {

				// ShapeRepository shapeRepository = new ShapeRepository();
				int initialX = e.getX();
				int initialY = e.getY();
				// Iterator<IShape> iterator = shapeRepository.iterator();
				for (IShape s : shapes) {
					if (((s.getX() < initialX) && (s.getY() < initialY))
							&& ((s.getX() + Math.abs(s.getX2() - s.getX()) > initialX) && (s
									.getY() + Math.abs(s.getY() - s.getY2()) > initialY))) {

						if (e.getButton() == MouseEvent.BUTTON3) {
							IShape tempshape = s;
							tempshape.setContextColor(appstate
									.getActivePrimaryColor().getAwtColor());
							tempshape.setSecColor(appstate
									.getActiveSecondaryColor().getAwtColor());
							tempshape.setSst(appstate
									.getActiveShapeShadingType());
							Graphics g = tempshape.getG();
							Context context = new Context(tempshape);
							context.executeStrategy(g);
							// tempshape.draw(g);
							shapes.add(tempshape);
						}

						else if (e.getButton() == MouseEvent.BUTTON1) {
							ArrayList<Integer> relativePosition = new ArrayList<Integer>();
							if (!selectedShapesList.isEmpty()) {
								IShape firstShape = selectedShapesList.get(0);
								relativePosition.add(s.getX()
										- firstShape.getX());
								relativePosition.add(s.getY()
										- firstShape.getY());
								relativePositions.add(relativePosition);
							} else {
								relativePosition.add(0);
								relativePosition.add(0);
								relativePositions.add(relativePosition);
							}
							selectedShapesList.add(s);

							shapeSelected = true;
							System.out.println("A Shape has been selected");
						}
					}
				}

			}
		}

		public void mouseDragged(MouseEvent e) {
			setEndPoint(e.getX(), e.getY());
			repaint();
		}

		public void mouseReleased(MouseEvent e) {
			setEndPoint(e.getX(), e.getY());
			dragged = false;
			repaint();
		}

		public void mouseClicked(MouseEvent e) {
		}
	}

	public void setStartPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void setEndPoint(int x, int y) {
		x2 = (x);
		y2 = (y);
	}

	public void setAppState(ApplicationState appState) {
		this.appstate = appState;
	}

	public void renderAll(ArrayList<IShape> shapes, Graphics g) {
		ShapeRepository shapeRepository = new ShapeRepository();
		Iterator<IShape> iterator = shapeRepository.iterator();
		while (iterator.hasNext()) {
			IShape s = iterator.next();
			s.draw(g);
		}
	}

	public void paintComponent(Graphics g) {
		ShapeFactory shapeFactory = new ShapeFactory();
		super.paintComponent(g);
		ShapeType currentShape = null;
		currentShape = appstate.getActiveShapeType();
		ShapeColor primaryColor = null;
		primaryColor = appstate.getActivePrimaryColor();
		ShapeColor secondaryColor = null;
		secondaryColor = appstate.getActiveSecondaryColor();
		ShapeShadingType shapeShadingType = null;
		shapeShadingType = appstate.getActiveShapeShadingType();
		DoUndo doUndo = null;
		doUndo = appstate.getUndo();
		DoRedo doRedo = null;
		doRedo = appstate.getRedo();
		StartAndEndPointMode mode = null;
		mode = appstate.getActiveStartAndEndPointMode();

		if (mode.name().equals("DRAW")) {
			if (doUndo.name().equals("YES") || doRedo.name().equals("YES")) {
				return;
			}

			if (currentShape.name().equals("RECTANGLE")) {
				Color contextColor = primaryColor.getAwtColor();
				Color secColor = secondaryColor.getAwtColor();
				Rectangle r = (Rectangle) shapeFactory.getShape(
						(String) currentShape.name(), g, x, y, x2, y2,
						shapeShadingType, contextColor, secColor);
				if (!dragged) {
					if ((r.getX2() != r.getX()) && (r.getY() != r.getY2()))
						shapes.add(r);
					renderAll(shapes, g);
				} else {
					Context context = new Context(r);
					context.executeStrategy(g);
					// r.draw(g);
				}

			} else if (currentShape.name().equals("ELLIPSE")) {
				Color contextColor = primaryColor.getAwtColor();
				Color secColor = secondaryColor.getAwtColor();
				Ellipse e = (Ellipse) shapeFactory.getShape(
						(String) currentShape.name(), g, x, y, x2, y2,
						shapeShadingType, contextColor, secColor);
				if (!dragged) {
					if ((e.getX2() != e.getX()) && (e.getY() != e.getY2()))
						shapes.add(e);
					renderAll(shapes, g);
				} else {

					Context context = new Context(e);
					context.executeStrategy(g);
				}
			} else {
				Color contextColor = primaryColor.getAwtColor();
				Color secColor = secondaryColor.getAwtColor();
				Polygon p = (Polygon) shapeFactory.getShape(
						(String) currentShape.name(), g, x, y, x2, y2,
						shapeShadingType, contextColor, secColor);
				if (!dragged) {
					if ((p.getX2() != p.getX()) && (p.getY() != p.getY2()))
						shapes.add(p);
					renderAll(shapes, g);
				} else {
					Context context = new Context(p);
					context.executeStrategy(g);
				}

			}
		} else if (mode.name().equals("SELECT")) {
			for (IShape s : shapes) {
				s.draw(g);
			}
		} else {
			for (IShape s : shapes) {
				s.draw(g);
			}
		}
	}

	public void moveShape(ArrayList<IShape> selectedShapesList, int newX,
			int newY) {
		int i = 0;
		for (IShape tempShape : selectedShapesList) {

			ArrayList temp = relativePositions.get(i);
			int relX = (int) temp.get(0);
			int relY = (int) temp.get(1);
			int dX = Math.abs(tempShape.getX2() - tempShape.getX());
			int dY = Math.abs(tempShape.getY2() - tempShape.getY());
			newX = newX + relX;
			newY = newY + relY;
			tempShape.setX(newX);
			tempShape.setY(newY);
			tempShape.setX2(newX + dX);
			tempShape.setY2(newY + dY);
			tempShape.setContextColor(tempShape.getContextColor());
			tempShape.setSecColor(tempShape.getSecColor());
			tempShape.setSst(tempShape.getSst());
			tempShape.draw(tempShape.getG());
			shapes.add(tempShape);
			i++;
		}
		selectedShapesList.clear();
		shapeSelected = false;
	}

	public void Delete() {
		for (IShape shape : selectedShapesList) {
			if (shapes.contains(shape)) {
				shapes.remove(shape);
			}
		}
		selectedShapesList.clear();
		repaint();
	}

}
