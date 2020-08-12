package com.db.app.paint.model.interfaces;

import com.db.app.paint.models.DoRedo;
import com.db.app.paint.models.DoUndo;
import com.db.app.paint.models.ShapeColor;
import com.db.app.paint.models.ShapeShadingType;
import com.db.app.paint.models.ShapeType;
import com.db.app.paint.models.StartAndEndPointMode;
import com.db.app.paint.view.interfaces.IDialogChoice;

public interface IDialogProvider {

    IDialogChoice<ShapeType> getChooseShapeDialog();

    IDialogChoice<ShapeColor> getChoosePrimaryColorDialog();

    IDialogChoice<ShapeColor> getChooseSecondaryColorDialog();

    IDialogChoice<ShapeShadingType> getChooseShadingTypeDialog();

    IDialogChoice<StartAndEndPointMode> getChooseStartAndEndPointModeDialog();
    
    IDialogChoice<DoUndo> getChooseDoUndo();

	IDialogChoice<DoRedo> getChooseDoRedo();
}
