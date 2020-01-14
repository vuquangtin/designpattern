package model;

import geometry.Shape;

import java.util.ArrayList;

public class DrawingModel{

	private ArrayList<Shape> shapes;
	
	public DrawingModel() {
		shapes = new ArrayList<Shape>();
	}
	
	public void addShape(Shape shape) {
		shapes.add(shape);
	}
	
	public void addShapeToIndex(int index, Shape shape) {
		shapes.add(index, shape);
	}
	
	public void addMultipleShapes(ArrayList<Shape> shapes) {
		this.shapes.addAll(shapes);
	}
	
	public void removeShape(Shape shape) {
		shapes.remove(shape);
	}
	
	public void removeShapeAtIndex(int index) {
		shapes.remove(index);
	}
	
	public void removeMultipleShapes(ArrayList<Shape> shapes) {
		this.shapes.removeAll(shapes);
	}
	
	public void removeAllShapes() {
		shapes.clear();
	}
	
	public Shape getShapeByIndex(int index) {
		return shapes.get(index);
	}
	
	public int getIndexOfShape(Shape shape) {
		return shapes.indexOf(shape);
	}
	
	public ArrayList<Shape> getAllShapes() {
		return shapes;
	}
}
