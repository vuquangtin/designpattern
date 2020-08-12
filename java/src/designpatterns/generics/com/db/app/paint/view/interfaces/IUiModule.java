package com.db.app.paint.view.interfaces;

import com.db.app.paint.view.EventName;

public interface IUiModule {
    void addEvent(EventName eventName, IEventCallback command);
    <T> T getDialogResponse(IDialogChoice dialogChoice);
}
