package JavaSwingwithMvpStrategyFacadeSingleton.main;

import javax.swing.SwingUtilities;

import JavaSwingwithMvpStrategyFacadeSingleton.model.Model;
import JavaSwingwithMvpStrategyFacadeSingleton.presenter.Presenter;
import JavaSwingwithMvpStrategyFacadeSingleton.view.FacadeGenelView;
import JavaSwingwithMvpStrategyFacadeSingleton.view.View;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author inanb
 */
public class Main {
	public static final String PATH_CONTENT = "java/resources/com/resources/content/";

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			View view = new View();
			view.setPresenter(new Presenter(view, new Model()));
			view.setVisible(true);

			FacadeGenelView fv = new FacadeGenelView();
			fv.setVisible(true);

		});
	}
}
