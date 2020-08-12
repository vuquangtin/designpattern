package com.db.app.paint.model.dialogs;

	import com.db.app.paint.model.interfaces.IApplicationState;
import com.db.app.paint.models.DoRedo;
import com.db.app.paint.view.interfaces.IDialogChoice;

	public class ChooseRedoDialog implements IDialogChoice<DoRedo>{

			private IApplicationState applicationState;


			public ChooseRedoDialog(IApplicationState applicationState) {
			        this.applicationState = applicationState;
			    }

			@Override
			public String getDialogTitle() {
				return "Are You Sure You want to Redo?";
			}

			@Override
			public String getDialogText() {
				return "Redo";
			}

			@Override
			public DoRedo[] getDialogOptions() {
				return DoRedo.values();
			}

			@Override
			public DoRedo getCurrentSelection() {
				return applicationState.getRedo();
			}
}
