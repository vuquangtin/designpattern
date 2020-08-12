package com.db.app.paint.model.interfaces;

import com.db.app.paint.models.DoRedo;
import com.db.app.paint.models.DoUndo;
import com.db.app.paint.models.ShapeColor;
import com.db.app.paint.models.ShapeShadingType;
import com.db.app.paint.models.ShapeType;
import com.db.app.paint.models.StartAndEndPointMode;

public interface IApplicationState {
    void setActiveShape();

    void setActivePrimaryColor();

    void setActiveSecondaryColor();

    void setActiveShadingType();

    void setActiveStartAndEndPointMode();

    void setUndo();

    void setRedo();
    
    ShapeType getActiveShapeType();

    ShapeColor getActivePrimaryColor();

    ShapeColor getActiveSecondaryColor();

    ShapeShadingType getActiveShapeShadingType();

    StartAndEndPointMode getActiveStartAndEndPointMode();

	DoUndo getUndo();

	DoRedo getRedo();

	

    
}
