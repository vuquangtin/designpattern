package designpatternsproject.app;

import javax.swing.DefaultListModel;

import designpatternsproject.controller.AdditionalActionsController;
import designpatternsproject.controller.CanvasController;
import designpatternsproject.controller.InformationPaneController;
import designpatternsproject.controller.MenuFileController;
import designpatternsproject.controller.MenuHelpController;
import designpatternsproject.controller.ToolboxController;
import designpatternsproject.model.ShapeModel;
import designpatternsproject.util.Logger;

public class App {
	/**
	 * Initializes everything needed for app to start
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// Get Logger singleton object
		Logger logger = Logger.getInstance();

		// Init all collections
		ShapeModel model = new ShapeModel();
		DefaultListModel<String> dlmLogger = logger.getDlmLogger();

		// Init main frame with resolution 800x600
		MainFrame frame = new MainFrame(800, 600);

		// Set Logger DLM to Logger view so actions can be logged in real time
		frame.getFooterWrapperView().getLoggerView().setDlm(dlmLogger);

		// Set all controllers
		frame.setCanvasController(new CanvasController(frame, model));
		frame.setInformationPaneController(new InformationPaneController());
		frame.setToolboxController(new ToolboxController(model, frame));
		frame.setAdditionalActionsController(new AdditionalActionsController(
				model, frame));
		frame.setMfController(new MenuFileController(frame, model, logger
				.getLoggerModel()));
		frame.setMhController(new MenuHelpController());

		// Set shape model for Canvas View (View where all shapes are drawn)
		frame.getCanvasView().setModel(model);

	}
}
