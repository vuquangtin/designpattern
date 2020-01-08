/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaSwingwithMvpStrategyFacadeSingleton.presenter;

import java.io.BufferedReader;
import java.io.FileReader;

import JavaSwingwithMvpStrategyFacadeSingleton.main.Main;
import JavaSwingwithMvpStrategyFacadeSingleton.model.Model;
import JavaSwingwithMvpStrategyFacadeSingleton.model.SoruBankasiModel;
import JavaSwingwithMvpStrategyFacadeSingleton.view.SoruBankasiView;

/**
 *
 * @author mustafa
 */
public class SoruBankasiPresenter {

	String path = Main.PATH_CONTENT + "Dersler.txt";

	private SoruBankasiView view;
	private SoruBankasiModel model;
	private Model model2;

	public SoruBankasiPresenter(SoruBankasiView view, SoruBankasiModel model,
			Model model2) {
		this.view = view;
		this.model = model;
		this.model2 = model2;
	}

	public void DosyaOku() {

		try {

			BufferedReader bf = new BufferedReader(new FileReader(path));

			String line = bf.readLine();

			while (line != null) {
				view.updateStatusComboBox2(line);
				line = bf.readLine();

			}
			System.out.println("Okuma İşlemi Başarılı");

		} catch (Exception hata) {
			hata.printStackTrace();
		}
	}

}
