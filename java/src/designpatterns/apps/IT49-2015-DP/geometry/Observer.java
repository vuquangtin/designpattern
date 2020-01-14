package geometry;

import model.DrawingModel;
import frame.DrawingFrame;

public interface Observer {
	void update(DrawingFrame frame,DrawingModel model,int numberOfSelected,int numberOfUndoCmd,int numberOfRedoCmd);
}
