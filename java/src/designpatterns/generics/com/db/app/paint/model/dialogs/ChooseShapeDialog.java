package com.db.app.paint.model.dialogs;

import com.db.app.paint.model.interfaces.IApplicationState;
import com.db.app.paint.models.ShapeType;
import com.db.app.paint.view.interfaces.IDialogChoice;

public class ChooseShapeDialog implements IDialogChoice<ShapeType> {
    private final IApplicationState applicationState;

    public ChooseShapeDialog(IApplicationState applicationState) {

        this.applicationState = applicationState;
    }

    @Override
    public String getDialogTitle() {
        return "Shape";
    }

    @Override
    public String getDialogText() {
        return "Select a shape from the menu below:";
    }

    @Override
    public ShapeType[] getDialogOptions() {
        return ShapeType.values();
    }

    @Override
    public ShapeType getCurrentSelection() {
        return applicationState.getActiveShapeType();
    }
}
