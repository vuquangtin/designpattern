package com.db.app.paint.model.persistences;

import com.db.app.paint.model.dialogs.DialogProvider;
import com.db.app.paint.model.interfaces.IApplicationState;
import com.db.app.paint.model.interfaces.IDialogProvider;
import com.db.app.paint.models.DoRedo;
import com.db.app.paint.models.DoUndo;
import com.db.app.paint.models.ShapeColor;
import com.db.app.paint.models.ShapeShadingType;
import com.db.app.paint.models.ShapeType;
import com.db.app.paint.models.StartAndEndPointMode;
import com.db.app.paint.models.UndoRedo;
import com.db.app.paint.view.interfaces.IUiModule;

public class ApplicationState implements IApplicationState {
    private final IUiModule uiModule;
    private final IDialogProvider dialogProvider;

    private ShapeType activeShapeType;
    private ShapeColor activePrimaryColor;
    private ShapeColor activeSecondaryColor;
    private ShapeShadingType activeShapeShadingType;
    private StartAndEndPointMode activeStartAndEndPointMode;
	private DoUndo activeUndo;
	private DoRedo activeRedo;
	private UndoRedo undoRedo = new UndoRedo();
    public ApplicationState(IUiModule uiModule) {
        this.uiModule = uiModule;
        this.dialogProvider = new DialogProvider(this);
        
        setDefaults();
    }
   
    
    @Override
    public void setActiveShape() {
        activeShapeType = uiModule.getDialogResponse(dialogProvider.getChooseShapeDialog());
    }
    
    @Override
    public void setUndo() {
    	undoRedo.undoAction();
    }
    
    @Override
    public void setRedo(){
    	undoRedo.redoAction();
    }

    @Override
    public void setActivePrimaryColor() {
        activePrimaryColor = uiModule.getDialogResponse(dialogProvider.getChoosePrimaryColorDialog());
    }
    
    public void setActivePrimaryColorSwitch() {
        activePrimaryColor = getActiveSecondaryColor();
    }

    @Override
    public void setActiveSecondaryColor() {
        activeSecondaryColor = uiModule.getDialogResponse(dialogProvider.getChooseSecondaryColorDialog());
    }
    
    public void setActiveSecondaryColorSwitch(ShapeColor c) {
		activeSecondaryColor = c;
	}

    @Override
    public void setActiveShadingType() {
        activeShapeShadingType = uiModule.getDialogResponse(dialogProvider.getChooseShadingTypeDialog());
    }

    @Override
    public void setActiveStartAndEndPointMode() {
        activeStartAndEndPointMode = uiModule.getDialogResponse(dialogProvider.getChooseStartAndEndPointModeDialog());
    }

    @Override
    public ShapeType getActiveShapeType() {
        return activeShapeType;
    }

    @Override
    public ShapeColor getActivePrimaryColor() {
        return activePrimaryColor;
    }

    @Override
    public ShapeColor getActiveSecondaryColor() {
        return activeSecondaryColor;
    }

    @Override
    public ShapeShadingType getActiveShapeShadingType() {
        return activeShapeShadingType;
    }

    @Override
    public StartAndEndPointMode getActiveStartAndEndPointMode() {
        return activeStartAndEndPointMode;
    }
    
	@Override
	public DoUndo getUndo() {
		return activeUndo;
	}
	
	@Override
	public DoRedo getRedo() {
		return activeRedo;
	}

    private void setDefaults() {
        activeShapeType = ShapeType.ELLIPSE;
        activePrimaryColor = ShapeColor.BLUE;
        activeSecondaryColor = ShapeColor.GREEN;
        activeShapeShadingType = ShapeShadingType.FILLED_IN;
        activeStartAndEndPointMode = StartAndEndPointMode.DRAW;
        activeUndo = DoUndo.NO;
        activeRedo = DoRedo.NO;
    }

}
