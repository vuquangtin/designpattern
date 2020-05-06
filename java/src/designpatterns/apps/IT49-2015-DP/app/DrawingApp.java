package app;

import javax.swing.JFrame;

import controller.DrawingController;
import frame.DrawingFrame;
import geometry.UpdateNumberOfSelectedShapes;
import model.DrawingModel;

public class DrawingApp {

	public static void main(String[] args) {
		DrawingModel model = new DrawingModel();
		DrawingFrame frame = new DrawingFrame();
		frame.getView().setModel(model);
		DrawingController controller = new DrawingController(model, frame);
		frame.setController(controller);
		UpdateNumberOfSelectedShapes updateNumberOfSelectedShapes = new UpdateNumberOfSelectedShapes();
		controller.addObserver(updateNumberOfSelectedShapes);
		
		frame.setVisible(true);
		frame.setTitle("Nikola Savic IT49/2015");
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	
	}
}
