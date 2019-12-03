package com.designpattern.mvp;

import javax.swing.SwingUtilities;

/**
 * Design Patterns
 * 
 * Model-View-Presener(MVP) is a variation of the Model-View-Controller (MVC)
 * architectural pattern for building user interfaces. The main goal of MVP and
 * its variants is separation of concerns between the user interface (UI), the
 * model (application data), and the presenter (controller that handles
 * business/presentation logic). This version of MVP is called passive because
 * the View does not actively update itself, instead choosing to allow the
 * presenter to handle that task.<b/>
 * 
 * In MVP, the view and the presenter are tightly coupled with the view holding
 * a reference to the presenter and calling methods from it in response to UI
 * events. The view knows nothing of the existence of the model.
 * 
 * View -> Presenter.
 * 
 * The presenter is fully aware of and holds references to both the Model and
 * the View.
 * 
 * View <- Presenter -> Model.
 * 
 * The model knows nothing about either the view or the presenter. The model has
 * one purpose: to store and retrieve data.
 * 
 * In this example, we'll create a simple form that checks password input. Being
 * that the model is the simplest in this example, let's start there.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			View view = new View();
			view.setPresenter(new Presenter(view, new Model()));
		});
	}
}
