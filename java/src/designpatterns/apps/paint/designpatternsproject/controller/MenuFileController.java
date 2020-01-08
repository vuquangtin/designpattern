package designpatternsproject.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import designpatternsproject.app.MainFrame;
import designpatternsproject.io.exporter.ExportManager;
import designpatternsproject.io.exporter.SaveLogToFile;
import designpatternsproject.io.exporter.SerializeShapesToFile;
import designpatternsproject.io.importer.ImportManager;
import designpatternsproject.io.importer.LoadDrawingFromFile;
import designpatternsproject.io.importer.LoadLogFromFile;
import designpatternsproject.logparser.CommandParser;
import designpatternsproject.model.LoggerModel;
import designpatternsproject.model.ShapeModel;
import designpatternsproject.shapes.Command;
import designpatternsproject.shapes.Shape;
import designpatternsproject.shapes.ShapeObserver;
import designpatternsproject.util.DialogsHelper;
import designpatternsproject.util.FileOperationsHelper;
import designpatternsproject.util.Logger;

public class MenuFileController implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2216489104960003132L;
	private MainFrame frame;
	private ShapeModel model;
	private LoggerModel loggerModel;
	private CommandParser cmdParser = CommandParser.getInstance();
	private ArrayList<String> logFileList;
	private int logFileLineProgress = 0;

	public MenuFileController(MainFrame frame, ShapeModel model, LoggerModel loggerModel) {
		this.frame = frame;
		this.model = model;
		this.loggerModel = loggerModel;
	}

	/**
	 * Bundles shape collections to Object ArrayList, opens File Dialog and calls
	 * export to file method
	 */
	public void handleExportToFile() {
		if (model.getShapesList().size() == 0) {
			DialogsHelper.showErrorMessage("You cannot export empty drawing!");
			return;
		}

		ArrayList<Object> bundle = new ArrayList<Object>();
		bundle.add(model.getShapesList());
		ExportManager manager = new ExportManager(new SerializeShapesToFile());
		String path = FileOperationsHelper.showFileDialogSave("drwg");
		if (path != null)
			manager.exportData(bundle, path);
	}

	/**
	 * Adds log lines list to bundle, opens FIle Dialog and calls save log to file
	 * method
	 */
	public void handleExportToLog() {
		if (model.getShapesList().size() == 0) {
			DialogsHelper.showErrorMessage("You cannot export empty drawing!");
			return;
		}
		ArrayList<Object> bundle = new ArrayList<Object>();
		bundle.add(loggerModel.getLogLines());
		ExportManager manager = new ExportManager(new SaveLogToFile());
		String path = FileOperationsHelper.showFileDialogSave("log");
		if (path != null)
			manager.exportData(bundle, path);
	}

	/**
	 * Imports all log lines from log file
	 */
	@SuppressWarnings("unchecked")
	public void handleImportFromLog() {
		ImportManager manager = new ImportManager(new LoadLogFromFile());
		String path = FileOperationsHelper.showFileDialogOpen("log");

		if (path != null) {
			ArrayList<Object> bundle = manager.importData(path);

			// Reset log file line progress to 0
			logFileLineProgress = 0;

			// Put log file lines from bundle to its array list
			logFileList = (ArrayList<String>) bundle.get(0);

			Iterator<String> iterator = logFileList.iterator();

			// Remove log lines that have [INFO] prefix
			while (iterator.hasNext()) {
				String next = iterator.next();
				if (next.contains("[INFO]") || next.trim().isEmpty()) {
					iterator.remove();
				}
			}

			// Log is imported so enable log parse buttons
			frame.getAdditionalActionsView().getBtnParseLog().setEnabled(true);
			frame.getHeaderWrapperView().getMntmParseNext().setEnabled(true);
		}
	}

	/**
	 * Parses next line from imported log
	 */
	public void parseNextLogLine() {

		// Make sure that log is actually loaded and that button is enabled
		if (logFileList == null || logFileList.size() == 0
				|| !frame.getAdditionalActionsView().getBtnParseLog().isEnabled()
				|| !frame.getHeaderWrapperView().getMntmParseNext().isEnabled())
			return;

		// Get current log line
		String s = logFileList.get(logFileLineProgress);

		// Get Command from log line
		Command cmd = cmdParser.parse(s, model, frame);

		if (!model.getUndoStack().contains(cmd)) {
			// Put new command in undo stack
			model.getUndoStack().offerLast(cmd);
		}

		// Check if command should be executed or unexecuted
		if (cmdParser.isExecuted(s)) {
			cmd.execute();
		} else {
			cmd.unexecute();
		}

		// Increase log file line progress so next time this function is called we
		// process next line
		logFileLineProgress++;

		// Disable button if there are no more log lines to parse, reset current line to
		// 0
		if (logFileLineProgress > logFileList.size() - 1) {
			frame.getAdditionalActionsView().getBtnParseLog().setEnabled(false);
			frame.getHeaderWrapperView().getMntmParseNext().setEnabled(false);
			logFileLineProgress = 0;
		}

		frame.repaint();
	}

	/**
	 * Imports whole drawing from serialized file with .drwg extension
	 */
	@SuppressWarnings("unchecked")
	public void handleImportFromFile() {
		ImportManager manager = new ImportManager(new LoadDrawingFromFile());
		String path = FileOperationsHelper.showFileDialogOpen("drwg");
		if (path != null) {
			ArrayList<Object> bundle = manager.importData(path);
			// If ArrayList setter was used observers wouldn't work at all
			for (Shape s : (ArrayList<Shape>) bundle.get(0)) {
				s.setObserver(new ShapeObserver(frame, model));
				model.add(s);
			}
			Logger.getInstance().log(
					"Imported drawing with " + ((ArrayList<Shape>) bundle.get(0)).size() + " shapes from " + path, true,
					true);
			frame.repaint();
		}
	}

	/**
	 * Exits process with given code
	 * 
	 * @param code
	 */
	public void exitApp(int code) {
		System.exit(code);
	}

	/**
	 * Create new empty drawing (will also ask user to confirm)
	 */
	public void writeNewDrawing() {
		// If drawing is already empty do not create new one
		if (model.getShapesList().size() == 0)
			return;

		frame.getHeaderWrapperView().getToolboxView().getBtnUndo().setEnabled(false);
		frame.getHeaderWrapperView().getToolboxView().getBtnRedo().setEnabled(false);
		frame.getHeaderWrapperView().getMntmUndo().setEnabled(false);
		frame.getHeaderWrapperView().getMntmRedo().setEnabled(false);

		if (DialogsHelper.askUserToConfirm("Are you sure? If you did not save current drawing it will be lost.")) {
			// Clear all shapes, both undo and redo stacks
			model.getShapesList().clear();
			model.getUndoStack().clear();
			model.getRedoStack().clear();

			// Clear DLM (so real time log is wiped), clear LogLines ArrayList (where log is
			// actually held)
			Logger.getInstance().getDlmLogger().clear();
			Logger.getInstance().getLoggerModel().getLogLines().clear();
			frame.repaint();
		}

	}

}
