package controller;

import frame.DrawingFrame;
import geometry.Circle;
import geometry.Command;
import geometry.Line;
import geometry.Observer;
import geometry.Point;
import geometry.Rectangle;
import geometry.Shape;
import geometry.Square;
import geometry.Subject;
import hexagon.Hexagon;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

import javax.swing.DefaultListModel;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import model.DrawingModel;
import strategy.Context;
import strategy.FileLog;
import strategy.FileSerialization;
import adapter.HexagonAdapter;

import commands.CmdAddShape;
import commands.CmdBringToBack;
import commands.CmdBringToFront;
import commands.CmdDeleteAll;
import commands.CmdDeleteShape;
import commands.CmdToBack;
import commands.CmdToFront;
import commands.CmdUpdateCircle;
import commands.CmdUpdateHexagon;
import commands.CmdUpdateLine;
import commands.CmdUpdatePoint;
import commands.CmdUpdateRectangle;
import commands.CmdUpdateSquare;

import dialogs.DlgDrawingCircle;
import dialogs.DlgDrawingHexagon;
import dialogs.DlgDrawingRectangle;
import dialogs.DlgDrawingSquare;
import dialogs.DlgModifyingCircle;
import dialogs.DlgModifyingHexagon;
import dialogs.DlgModifyingLine;
import dialogs.DlgModifyingPoint;
import dialogs.DlgModifyingRectangle;
import dialogs.DlgModifyingSquare;

public class DrawingController implements Subject{

	private DrawingModel model;
	private DrawingFrame frame;

	private int numberOfSelectedShapes = 0;

	private ArrayList<Observer> observers;

	private Stack<Command> undoCommands = new Stack<Command>();
	private Stack<Command> redoCommands = new Stack<Command>();

	private DefaultListModel<String> log;
	private Context context;
	private FileLog fileLog;

	private String tglBtn;
	private int numberOfClicks;
	private Point startingPoint;
	private String btn;

	public DrawingController(DrawingModel model, DrawingFrame frame) {
		this.model = model;
		this.frame = frame;
		this.observers = new ArrayList<Observer>();
		this.undoCommands = new Stack<Command>();
		this.redoCommands = new Stack<Command>();
		log = frame.getDlmLogList();

	}

	public void mouseClicked(MouseEvent arg0) {
		if (tglBtn != null) {
			CmdAddShape shape;
			if (tglBtn.equals("Point")) {
				//System.out.println("Jos nije nastupio error 1");
				Point point = new Point(arg0.getX(), arg0.getY(), frame.getBorderColor());
				//System.out.println("Jos nije nastupio 2 \\n" + point.toString() + " hehe");
				shape = new CmdAddShape(point, model);
				//System.out.println("Jos nista 3");
				//System.out.println(point.toString());
				doCommand(shape);
				System.out.println("Sad je nastupio heh");
				//frame.getView().repaint();
				log.addElement(shape.getCommandLog());

			} else if (tglBtn.equals("Line")) {
				if (numberOfClicks == 0) {
					startingPoint = new Point(arg0.getX(), arg0.getY());
					numberOfClicks = 1;
				} else {
					Point endingPoint = new Point(arg0.getX(), arg0.getY());
					Line line = new Line(startingPoint, endingPoint, frame.getBorderColor());
					numberOfClicks = 0;

					shape = new CmdAddShape(line, model);
					doCommand(shape);
					log.addElement(shape.getCommandLog());
				}

			} else if (tglBtn.equals("Square")) {
				DlgDrawingSquare dlgDrawingSquare = new DlgDrawingSquare();
				dlgDrawingSquare.setVisible(true);
				if (!dlgDrawingSquare.isConfirmed()) {
					log.addElement("Adding square canceled");
				} else {
					Square square = new Square(new Point(arg0.getX(), arg0.getY()), dlgDrawingSquare.getSideLength(),
							frame.getBorderColor(), frame.getInnerColor());

					shape = new CmdAddShape(square, model);
					doCommand(shape);
					log.addElement(shape.getCommandLog());

				}

			} else if (tglBtn.equals("Rectangle")) {
				DlgDrawingRectangle dlgDrawingRectangle = new DlgDrawingRectangle();
				dlgDrawingRectangle.setVisible(true);
				if (!dlgDrawingRectangle.isConfirmed()) {
					log.addElement("Adding rectangle canceled");
				} else {
					Rectangle rectangle = new Rectangle(new Point(arg0.getX(), arg0.getY()),
							dlgDrawingRectangle.getRectangleHeight(), dlgDrawingRectangle.getRectangleWidth(),
							frame.getBorderColor(), frame.getInnerColor());

					shape = new CmdAddShape(rectangle, model);
					doCommand(shape);
					log.addElement(shape.getCommandLog());
				} 

			} else if (tglBtn.equals("Circle")) {
				DlgDrawingCircle dlgDrawingCircle = new DlgDrawingCircle();
				dlgDrawingCircle.setVisible(true);
				if (!dlgDrawingCircle.isConfirmed()) {
					log.addElement("Adding circle canceled");
				} else {
					Circle circle = new Circle(dlgDrawingCircle.getR(), new Point(arg0.getX(), arg0.getY()),
							frame.getBorderColor(), frame.getInnerColor());

					shape = new CmdAddShape(circle, model);
					doCommand(shape);
					log.addElement(shape.getCommandLog());
				}

			} else if (tglBtn.equals("Hexagon")) {
				DlgDrawingHexagon dlgDrawingHexagon = new DlgDrawingHexagon();
				dlgDrawingHexagon.setVisible(true);
				if (!dlgDrawingHexagon.isConfirmed()) {
					log.addElement("Adding hexagon canceled");
				} else {
					HexagonAdapter hexagonAdapter = new HexagonAdapter(
							new Hexagon(arg0.getX(), arg0.getY(), dlgDrawingHexagon.getR()),
							frame.getBorderColor(), frame.getInnerColor());

					shape = new CmdAddShape(hexagonAdapter, model);
					doCommand(shape);
					log.addElement(shape.getCommandLog());
				}

			} else if (tglBtn.equals("Select")) {
				/* Ukoliko je korisnik kliknuo na dugme "Select" a nakon toga na ekran,
				 proveravamo da li neki od oblika sadrzi tacku klika i ukoliko sadrzi,
				oznacavamo ga kao selektovanog. U slucaju da je oblik vec selektovan,
				bice deselektovan.*/
				for (int i = this.model.getAllShapes().size() - 1; i >= 0; i--) {
					//if (this.model.getAllShapes().get(i).contains(arg0.getX(), arg0.getY())) {
					if(this.model.getShapeByIndex(i).contains(arg0.getX(), arg0.getY()))
						//if (this.model.getAllShapes().get(i).isSelected()) {
						if(this.model.getShapeByIndex(i).isSelected()) {
							// Oblik je vec selektovan
							this.numberOfSelectedShapes = this.numberOfSelectedShapes - 1;
							//this.model.getAllShapes().get(i).setSelected(false);
							this.model.getShapeByIndex(i).setSelected(false);
							notifyObservers(numberOfSelectedShapes, undoCommands.size(), redoCommands.size());
							log.addElement("Deselect_" + model.getShapeByIndex(i).toString());
							break;
						} else {
							numberOfSelectedShapes = numberOfSelectedShapes + 1;
							//this.model.getAll().get(i).setSelected(true);
							this.model.getShapeByIndex(i).setSelected(true);
							notifyObservers(numberOfSelectedShapes, undoCommands.size(), redoCommands.size());
							log.addElement("Select_" + model.getShapeByIndex(i).toString());
							break;
						}
				}
			}

			//Odredjena je pocetna tacka linije ali vise nije selektovana opcija crtanja Linije
			if(numberOfClicks==1 && !tglBtn.equals("Line"))
				numberOfClicks=0;
		}  

		frame.getView().repaint();
	} 

	//za tglBtns
	public void tglBtnClicked(String name) {
		tglBtn = name;
	}

	//za modify/delete
	public void btnClicked(String name) {
		Shape shape;
		Command newShape;
		Command deleteShape;
		Command deleteAllShapes;
		ArrayList<Shape> listOfSelectedShapes = new ArrayList<Shape>();
		Object[] options = { "Yes", "No" };
		int n = 0;

		if (name.equals("Delete")) {
			for (int i = model.getAllShapes().size() - 1; i >= 0; i--)
				if (model.getShapeByIndex(i).isSelected())
					listOfSelectedShapes.add(model.getShapeByIndex(i));

			if (listOfSelectedShapes.size() == 1) {
				n = JOptionPane.showOptionDialog(null, "Are you sure you want to delete this selected shape?",
						"Delete Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,
						options[0]);

				//0 ukoliko korisnik stisne Yes
				if (n == 0) {
					numberOfSelectedShapes = numberOfSelectedShapes - 1;
					deleteShape = new CmdDeleteShape(model, listOfSelectedShapes.get(0));
					doCommand(deleteShape);
					System.out.println(((CmdDeleteShape) deleteShape).getCommandLog());
					log.addElement(((CmdDeleteShape) deleteShape).getCommandLog());
				}

			} else if (listOfSelectedShapes.size() > 1) {
				n = JOptionPane.showOptionDialog(null, "Are you sure you want to delete these selected shapes?",
						"Delete confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,
						options[0]);

				//0 ukoliko korisnik stisne Yes
				if (n == 0) {
					numberOfSelectedShapes = numberOfSelectedShapes - listOfSelectedShapes.size();
					deleteAllShapes = new CmdDeleteAll(listOfSelectedShapes, model);
					doCommand(deleteAllShapes);
					log.addElement(((CmdDeleteAll) deleteAllShapes).getCommandLog());
				}
			}

		}

		/*Prolazimo kroz sve oblike i proveravamo da li je neki od njih selektovan.
		Ukoliko jeste, gledamo da li je korisnik pritisnuo na Modify i ukoliko jeste,
		proveravamo koji je oblik u pitanju i otvara se odgovarajuci dijalog za izmenu.*/
		for (int i = 0; i < this.model.getAllShapes().size(); i++) {
			if (this.model.getShapeByIndex(i).isSelected()) {
				if (name.equals("Modify")) {
					shape = this.model.getShapeByIndex(i);

					if (shape instanceof Point) {
						DlgModifyingPoint dlgModifyingPoint = new DlgModifyingPoint();
						dlgModifyingPoint.getTxtCoordinateX().setText(((Point) shape).getX() + "");
						dlgModifyingPoint.getTxtCoordinateY().setText(((Point) shape).getY() + "");
						dlgModifyingPoint.getBtnColor().setBackground(shape.getColor());
						dlgModifyingPoint.setVisible(true);
						if (!dlgModifyingPoint.isConfirmed()) {
							log.addElement("Point modification canceled");
						} else {
							//true za MoveTo()
							if(dlgModifyingPoint.isChoosenOption()) {
								Point newPoint = new Point(dlgModifyingPoint.getX(), dlgModifyingPoint.getY(),
										dlgModifyingPoint.getColor());
								newShape = new CmdUpdatePoint((Point) shape, newPoint, true);
							} else {
								Point moveByCoordinates = new Point(dlgModifyingPoint.getMoveByX(), dlgModifyingPoint.getMoveByY(), dlgModifyingPoint.getColor());
								newShape = new CmdUpdatePoint((Point) shape, moveByCoordinates, false);
							}
							doCommand(newShape);
							model.getShapeByIndex(i).setSelected(true);
							log.addElement(((CmdUpdatePoint) newShape).getCommandLog());
						}
					} else if (shape instanceof Line) {
						DlgModifyingLine dlgModifyingLine = new DlgModifyingLine();
						dlgModifyingLine.getTxtStartXY().setText(((Line) shape).getStartPoint().getX() + "," + ((Line) shape).getStartPoint().getY());
						dlgModifyingLine.getTxtEndXY().setText(((Line) shape).getEndPoint().getX() + "," + ((Line) shape).getEndPoint().getY());
						dlgModifyingLine.getBtnColor().setBackground(shape.getColor());
						dlgModifyingLine.setVisible(true);
						if (!dlgModifyingLine.isConfirmed()) {
							log.addElement("Line modification canceled");
						} else {
							//							Line newLine = new Line(new Point(dlgModifyingLine.getX(), dlgModifyingLine.getY()),
							//									new Point(dlgModifyingLine.getxCordEndP(), dlgModifyingLine.getyCordEndP()),
							//									dlgModifyingLine.getBorderColor());
							Point tmpValues = new Point(dlgModifyingLine.getX(), dlgModifyingLine.getY(), dlgModifyingLine.getColor());
							newShape = new CmdUpdateLine((Line) shape, tmpValues);
							doCommand(newShape);
							model.getShapeByIndex(i).setSelected(true);
							log.addElement(((CmdUpdateLine) newShape).getCommandLog());
						}
					}else if (shape instanceof Rectangle) {
						DlgModifyingRectangle dlgModifyingRectangle = new DlgModifyingRectangle();
						dlgModifyingRectangle.getTxtCoordinateX().setText(((Rectangle) shape).getUpperLeft().getX() + "");
						dlgModifyingRectangle.getTxtCoordinateY().setText(((Rectangle) shape).getUpperLeft().getY() + "");
						dlgModifyingRectangle.getTxtRectangleHeight().setText(((Rectangle) shape).getSideLength() + "");
						dlgModifyingRectangle.getTxtRectangleWidth().setText(((Rectangle) shape).getWidth() + "");
						dlgModifyingRectangle.getBtnBorderColor().setBackground(shape.getColor());
						dlgModifyingRectangle.getBtnInnerColor().setBackground(((Rectangle) shape).getInnerColor());
						dlgModifyingRectangle.setVisible(true);
						if (!dlgModifyingRectangle.isConfirmed()) {
							log.addElement("Rectangle update canceled");
						} else {
							//true znaci da je u pitanju MoveTo()
							if(dlgModifyingRectangle.isOptionChosen()) {
								Rectangle newRec = new Rectangle(
										new Point(dlgModifyingRectangle.getX(), dlgModifyingRectangle.getY()),
										dlgModifyingRectangle.getHeight(), dlgModifyingRectangle.getWidth(),
										dlgModifyingRectangle.getRectangleBorderColor(), dlgModifyingRectangle.getRectangleInnerColor());
								newShape = new CmdUpdateRectangle((Rectangle) shape, newRec, true);
							}
							else
							{
								Rectangle tmpValues = new Rectangle(
										new Point(dlgModifyingRectangle.getMoveByX(), dlgModifyingRectangle.getMoveByY()),
										dlgModifyingRectangle.getHeight(), dlgModifyingRectangle.getWidth(),
										dlgModifyingRectangle.getRectangleBorderColor(), dlgModifyingRectangle.getRectangleInnerColor());
								newShape = new CmdUpdateRectangle((Rectangle) shape, tmpValues, false);
							}
							doCommand(newShape);
							model.getShapeByIndex(i).setSelected(true);
							log.addElement(((CmdUpdateRectangle) newShape).getCommandLog());
						}
					} else if (shape instanceof Square) {
						DlgModifyingSquare dlgModifyingSquare = new DlgModifyingSquare();
						dlgModifyingSquare.getTxtCoordinateX().setText(((Square) shape).getUpperLeft().getX() + "");
						dlgModifyingSquare.getTxtCoordinateY().setText(((Square) shape).getUpperLeft().getY() + "");
						dlgModifyingSquare.getTxtSideLength().setText(((Square) shape).getSideLength() + "");
						dlgModifyingSquare.getBtnBorderColor().setBackground(shape.getColor());
						dlgModifyingSquare.getBtnInnerColor().setBackground(((Square) shape).getInnerColor());
						dlgModifyingSquare.setVisible(true);
						if (!dlgModifyingSquare.isConfirmed()) {
							log.addElement("Square modification canceled");
						} else {
							if(dlgModifyingSquare.isOptionChosen()) {
								Square newSquare = new Square(
										new Point(dlgModifyingSquare.getX(), dlgModifyingSquare.getY()),
										dlgModifyingSquare.getSideLength(), dlgModifyingSquare.getSquareBorderColor(),
										dlgModifyingSquare.getSquareInnerColor());
								newShape = new CmdUpdateSquare((Square) shape, newSquare, true);
							}else {
								Square tmpValues = new Square(
										new Point(dlgModifyingSquare.getMoveByX(), dlgModifyingSquare.getMoveByY()),
										dlgModifyingSquare.getSideLength(), dlgModifyingSquare.getSquareBorderColor(),
										dlgModifyingSquare.getSquareInnerColor());
								newShape = new CmdUpdateSquare((Square) shape, tmpValues, false);
							}
							doCommand(newShape);
							model.getShapeByIndex(i).setSelected(true);
							log.addElement(((CmdUpdateSquare) newShape).getCommandLog());
						}

					} else if (shape instanceof Circle) {
						DlgModifyingCircle dlgModifyingCircle = new DlgModifyingCircle();
						dlgModifyingCircle.getTxtCoordinateX().setText(((Circle) shape).getCenter().getX() + "");
						dlgModifyingCircle.getTxtCoordinateY().setText(((Circle) shape).getCenter().getY() + "");
						dlgModifyingCircle.getTxtRadius().setText(((Circle) shape).getRadius() + "");
						dlgModifyingCircle.getBtnBorderColor().setBackground(shape.getColor());
						dlgModifyingCircle.getBtnInnerColor().setBackground(((Circle) shape).getInnerColor());
						dlgModifyingCircle.setVisible(true);
						if (!dlgModifyingCircle.isConfirmed()) {
							log.addElement("Circle modification canceled");
						} else {
							if(dlgModifyingCircle.isOptionChosen()) {
								Circle newCircle = new Circle(dlgModifyingCircle.getRadius(),
										new Point(dlgModifyingCircle.getX(), dlgModifyingCircle.getY()),
										dlgModifyingCircle.getCircleBorderColor(), dlgModifyingCircle.getCircleInnerColor());
								newShape = new CmdUpdateCircle((Circle) shape, newCircle, true);
							} else {
								Circle tmpValues = new Circle(dlgModifyingCircle.getRadius(),
										new Point(dlgModifyingCircle.getMoveByX(), dlgModifyingCircle.getMoveByY()),
										dlgModifyingCircle.getCircleBorderColor(), dlgModifyingCircle.getCircleInnerColor());
								newShape = new CmdUpdateCircle((Circle) shape, tmpValues, false);
							}
							doCommand(newShape);
							model.getShapeByIndex(i).setSelected(true);
							log.addElement(((CmdUpdateCircle) newShape).getCommandLog());

						}

					} else if (shape instanceof HexagonAdapter) {
						DlgModifyingHexagon dlgModifyingHexagon = new DlgModifyingHexagon();
						dlgModifyingHexagon.getTxtCoordinateX().setText(((HexagonAdapter) shape).getXCoordinate() + "");
						dlgModifyingHexagon.getTxtCoordinateY().setText(((HexagonAdapter) shape).getYCoordinate() + "");
						dlgModifyingHexagon.getTxtRadius().setText(((HexagonAdapter) shape).getR() + "");
						dlgModifyingHexagon.getBtnBorderColor().setBackground(((HexagonAdapter) shape).getEdgeColor());
						dlgModifyingHexagon.getBtnInnerColor().setBackground(((HexagonAdapter) shape).getAreaColor());
						dlgModifyingHexagon.setVisible(true);
						if (!dlgModifyingHexagon.isConfirmed()) {
							log.addElement("Hexagon modification canceled");
						} else {
							if(dlgModifyingHexagon.isOptionChosen()) {
								HexagonAdapter newHexagon = new HexagonAdapter(
										new Point(dlgModifyingHexagon.getX(), dlgModifyingHexagon.getY()),
										dlgModifyingHexagon.getRadius(), dlgModifyingHexagon.getHexagonBorderColor(),
										dlgModifyingHexagon.getHexagonInnerColor());
								newShape = new CmdUpdateHexagon((HexagonAdapter) shape, newHexagon, true);
							}
							else
							{
								HexagonAdapter tmpValues = new HexagonAdapter(
										new Point(dlgModifyingHexagon.getMoveByX(), dlgModifyingHexagon.getMoveByY()),
										dlgModifyingHexagon.getRadius(), dlgModifyingHexagon.getHexagonBorderColor(),
										dlgModifyingHexagon.getHexagonInnerColor());
								newShape = new CmdUpdateHexagon((HexagonAdapter) shape, tmpValues, false);
							}
							doCommand(newShape);
							model.getShapeByIndex(i).setSelected(true);
							log.addElement(((CmdUpdateHexagon) newShape).getCommandLog());
						}
					}
				}
			}
		}
		frame.getView().repaint();
	}  

	public void doCommand(Command c) {
		c.execute();
		//System.out.println("Da li ce se ovo izvrsiti");
		undoCommands.push(c);
		//System.out.println("Hehe" + getNumberOfSelectedShapes());
		notifyObservers(getNumberOfSelectedShapes(), undoCommands.size(), redoCommands.size());
	}

	public Color pickColor(Color oldColor) {
		Color newColor = JColorChooser.showDialog(null, "Pick color", oldColor);
		if (newColor != null) {
			return newColor;
		} else {
			return oldColor;
		}
	}

	public void save() {
		if (!model.getAllShapes().isEmpty()) {
			// jFileChooser ce videti iskljucivo .ser fajlove
			frame.getjFileChooser().setFileFilter(new FileNameExtensionFilter("SerializeDraw", "ser"));
		}
		if (!log.isEmpty()) {
			// jFileChooser ce videti iskljucivo .log fajlove
			frame.getjFileChooser().setFileFilter(new FileNameExtensionFilter("FileLog", "log"));
		}
		if (frame.getjFileChooser().showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
			if (frame.getjFileChooser().getFileFilter().getDescription().equals("FileLog"))
				context = new Context(new FileLog(frame, model, this));
			else if (frame.getjFileChooser().getFileFilter().getDescription().equals("SerializeDraw"))
				context = new Context(new FileSerialization(model));

			context.save(frame.getjFileChooser().getSelectedFile());
		}
		frame.getjFileChooser().setVisible(false);
	}

	public void openFile() {
		if (frame.getOpenChooser().showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			model.removeAllShapes();
			log.removeAllElements();
			//vise nema komandi za undo/redo
			undoCommands.clear();
			redoCommands.clear();
			notifyObservers(numberOfSelectedShapes, undoCommands.size(), redoCommands.size());

			frame.getView().repaint();

			if (frame.getOpenChooser().getFileFilter().getDescription().equals("SerializeDraw")) {
				context = new Context(new FileSerialization(model));

			} else if (frame.getOpenChooser().getFileFilter().getDescription().equals("FileLog")) {
				fileLog = new FileLog(frame, model, this);
				context = new Context(fileLog);
				frame.getMntmGetLog().setEnabled(true);
			}

			context.open(frame.getOpenChooser().getSelectedFile());
			log.addElement("Imported file from " + frame.getOpenChooser().getSelectedFile().toString());
		}
		frame.getOpenChooser().setVisible(false);
	}
	
	public void newFile() {
		model.removeAllShapes();
		log.removeAllElements();
		undoCommands.clear();
		redoCommands.clear();
		notifyObservers(numberOfSelectedShapes, undoCommands.size(), redoCommands.size());
		frame.getView().repaint();
	}

	public void undoRedo(String command) {
		if (command.equals("Undo")) {
			undoCommand();
		} else if (command.equals("Redo")) {
			redoCommand();
		}
		frame.getView().repaint();
	}
	
	public void undoCommand() {
		Command command = undoCommands.peek();
		command.unexecute();

		//obrisace oblik, deselektovace ga i smanjice broj selektovanih objekata
		if (command instanceof CmdAddShape) {
			if (((CmdAddShape) command).getShape().isSelected()) {
				((CmdAddShape) command).getShape().setSelected(false);
				setNumberOfSelectedShapes(getNumberOfSelectedShapes() - 1);
			}
			//vratice odnosno nacrtace oblik, selektovace ga i povecace broj selektovanih objekata
		} else if (command instanceof CmdDeleteShape) {
			if (((CmdDeleteShape) command).getShape().isSelected()) {
				setNumberOfSelectedShapes(getNumberOfSelectedShapes() + 1);
			}
		}
		
		//Ponovo loguje akciju 
		if (command instanceof CmdAddShape) {
			log.addElement(((CmdAddShape) command).getCommandLog());
		} else if (command instanceof CmdDeleteShape) {
			log.addElement(((CmdDeleteShape) command).getCommandLog());
		} else if (command instanceof CmdToFront) {
			log.addElement(((CmdToFront) command).getCommandLog());
		} else if (command instanceof CmdToBack) {
			log.addElement(((CmdToBack) command).getCommandLog());
		} else if (command instanceof CmdBringToFront) {
			log.addElement(((CmdBringToFront) command).getCommandLog());
		} else if (command instanceof CmdBringToBack) {
			log.addElement(((CmdBringToBack) command).getCommandLog());
		} else if (command instanceof CmdUpdatePoint) {
			log.addElement(((CmdUpdatePoint) command).getCommandLog());
		} else if (command instanceof CmdUpdateLine) {
			log.addElement(((CmdUpdateLine) command).getCommandLog());
		} else if (command instanceof CmdUpdateRectangle) {
			log.addElement(((CmdUpdateRectangle) command).getCommandLog());
		} else if (command instanceof CmdUpdateSquare) {
			log.addElement(((CmdUpdateSquare) command).getCommandLog());
		} else if (command instanceof CmdUpdateCircle) {
			log.addElement(((CmdUpdateCircle) command).getCommandLog());
		} else if (command instanceof CmdUpdateHexagon) {
			log.addElement(((CmdUpdateHexagon) command).getCommandLog());
		}

		if (command instanceof CmdDeleteAll) {
			log.addElement(((CmdDeleteAll) command).getCommandLog());
			int n = ((CmdDeleteAll) command).getList().size();
			setNumberOfSelectedShapes(getNumberOfSelectedShapes() + n);
		}

		undoCommands.pop();
		notifyObservers(numberOfSelectedShapes, undoCommands.size(), redoCommands.size());
		redoCommands.push(command);
		notifyObservers(numberOfSelectedShapes, undoCommands.size(), redoCommands.size());
	}
	
	public void redoCommand() {
		
	}

	@Override
	public void addObserver(Observer o) {
		observers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		observers.remove(o);
	}

	@Override
	public void notifyObservers(int selected, int undo, int redo) {
		Iterator<Observer> it = observers.iterator();
		while (it.hasNext()) {
			//System.out.println("Hehe" + selected);
			it.next().update(frame, model, selected, undo, redo);
		}
	}

	public int getNumberOfSelectedShapes() {
		return numberOfSelectedShapes;
	}

	public void setNumberOfSelectedShapes(int numberOfSelectedShapes) {
		this.numberOfSelectedShapes = numberOfSelectedShapes;

		notifyObservers(numberOfSelectedShapes, undoCommands.size(), redoCommands.size());
	}

}
