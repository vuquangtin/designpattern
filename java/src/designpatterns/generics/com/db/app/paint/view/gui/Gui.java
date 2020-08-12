package com.db.app.paint.view.gui;

import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import com.db.app.paint.view.EventName;
import com.db.app.paint.view.interfaces.IDialogChoice;
import com.db.app.paint.view.interfaces.IEventCallback;
import com.db.app.paint.view.interfaces.IGuiWindow;
import com.db.app.paint.view.interfaces.IUiModule;

public class Gui implements IUiModule {

    private final IGuiWindow gui;

    public Gui(IGuiWindow gui) {
        this.gui = gui;
    }
    
	@Override
	public void addEvent(EventName eventName, IEventCallback callback) {
		JButton button = gui.getButton(eventName);
		button.addActionListener((ActionEvent) -> callback.run());
		if(eventName.name().equals("UNDO")) {
			button.setMnemonic('z');
		}else if(eventName.name().equals("REDO")) {
			button.setMnemonic('y');
		}
		else if(eventName.name().equals("DELETE")) {
			button.setMnemonic(KeyEvent.VK_DELETE);
		}
	}
	

    @Override
    public <T> T getDialogResponse(IDialogChoice dialogSettings) {
        Object selectedValue = JOptionPane.showInputDialog(null,
                dialogSettings.getDialogText(), dialogSettings.getDialogTitle(),
                JOptionPane.PLAIN_MESSAGE,
                null,
                dialogSettings.getDialogOptions(),
                dialogSettings.getCurrentSelection());
        return selectedValue == null
                ? (T)dialogSettings.getCurrentSelection()
                : (T)selectedValue;
    }
}
