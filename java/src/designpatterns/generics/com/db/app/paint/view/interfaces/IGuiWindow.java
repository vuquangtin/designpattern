package com.db.app.paint.view.interfaces;

import javax.swing.JButton;

import com.db.app.paint.view.EventName;

public interface IGuiWindow {
    JButton getButton(EventName eventName);
}
