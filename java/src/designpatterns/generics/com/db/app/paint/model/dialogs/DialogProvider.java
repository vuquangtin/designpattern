package com.db.app.paint.model.dialogs;

import com.db.app.paint.model.interfaces.IApplicationState;
import com.db.app.paint.model.interfaces.IDialogProvider;
import com.db.app.paint.models.DoRedo;
import com.db.app.paint.models.DoUndo;
import com.db.app.paint.models.ShapeColor;
import com.db.app.paint.models.ShapeShadingType;
import com.db.app.paint.models.ShapeType;
import com.db.app.paint.models.StartAndEndPointMode;
import com.db.app.paint.view.interfaces.IDialogChoice;

public class DialogProvider implements IDialogProvider {
    private final IDialogChoice<ShapeType> chooseShapeDialog;
    private final IDialogChoice<ShapeColor> choosePrimaryColorDialog;
    private final IDialogChoice<ShapeColor> chooseSecondaryColorDialog;
    private final IDialogChoice<ShapeShadingType> chooseShadingTypeDialog;
    private final IDialogChoice<StartAndEndPointMode> chooseStartAndEndPointModeDialog;
    private final IDialogChoice<DoUndo> chooseUndoDialog;
    private final IDialogChoice<DoRedo> chooseRedoDialog;
    private final IApplicationState applicationState;
	

    public DialogProvider(IApplicationState applicationState) {
        this.applicationState = applicationState;
        chooseShapeDialog = new ChooseShapeDialog(this.applicationState);
        choosePrimaryColorDialog = new ChoosePrimaryColorDialog(this.applicationState);
        chooseSecondaryColorDialog = new ChooseSecondaryColorDialog(this.applicationState);
        chooseShadingTypeDialog = new ChooseShadingTypeDialog(this.applicationState);
        chooseStartAndEndPointModeDialog = new ChooseStartAndEndPointModeDialog(this.applicationState);
        chooseUndoDialog = new ChooseUndoDialog(this.applicationState);
        chooseRedoDialog = new ChooseRedoDialog(this.applicationState);
    }

    @Override
    public IDialogChoice<ShapeType> getChooseShapeDialog() {
        return chooseShapeDialog;
    }

    @Override
    public IDialogChoice<ShapeColor> getChoosePrimaryColorDialog() {
        return choosePrimaryColorDialog;
    }

    @Override
    public IDialogChoice<ShapeColor> getChooseSecondaryColorDialog() {
        return chooseSecondaryColorDialog;
    }

    @Override
    public IDialogChoice<ShapeShadingType> getChooseShadingTypeDialog() {
        return chooseShadingTypeDialog;
    }

    @Override
    public IDialogChoice<StartAndEndPointMode> getChooseStartAndEndPointModeDialog() {
        return chooseStartAndEndPointModeDialog;
    }

	@Override
	public IDialogChoice<DoUndo> getChooseDoUndo() {
		return chooseUndoDialog;
	}
	
	@Override
	public IDialogChoice<DoRedo> getChooseDoRedo() {
		return chooseRedoDialog;
	}
}
