package com.db.app.paint;

import com.db.app.paint.controller.IJPaintController;
import com.db.app.paint.controller.JPaintController;
import com.db.app.paint.model.persistences.ApplicationState;
import com.db.app.paint.view.gui.Gui;
import com.db.app.paint.view.gui.GuiWindow;
import com.db.app.paint.view.gui.PaintCanvas;
import com.db.app.paint.view.interfaces.IGuiWindow;
import com.db.app.paint.view.interfaces.IUiModule;

/**
 *
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class Main {

	public static void main(String[] args) {
		PaintCanvas pc = PaintCanvas.getInstance();
		IGuiWindow guiWindow = new GuiWindow(pc);
		IUiModule uiModule = new Gui(guiWindow);
		ApplicationState appState = new ApplicationState(uiModule);
		pc.setAppState(appState);
		IJPaintController controller = new JPaintController(uiModule, appState);
		controller.setup();
	}
}