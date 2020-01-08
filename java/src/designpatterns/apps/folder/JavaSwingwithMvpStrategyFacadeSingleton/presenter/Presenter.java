package JavaSwingwithMvpStrategyFacadeSingleton.presenter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import JavaSwingwithMvpStrategyFacadeSingleton.main.Main;
import JavaSwingwithMvpStrategyFacadeSingleton.model.Model;
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
public class Presenter {

	String path = Main.PATH_CONTENT + "Dersler.txt";
	private View view;
	private Model model;

	public Presenter(View view, Model model) {
		this.view = view;
		this.model = model;
	}

	public void DosyaYaz(String dersAdi) {

		try {
			model.setDersAdi(dersAdi);
			File dosya = new File(path);
			FileWriter yazici = new FileWriter(dosya, true);
			BufferedWriter yaz = new BufferedWriter(yazici);

			yaz.append(model.getDersAdi());
			yaz.newLine();
			yaz.close();
			System.out.println("Yazma İşlemi Başarılı");
			view.updateStatusComboBox(model.getDersAdi());
		} catch (Exception hata) {
			hata.printStackTrace();
		}
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

	public void comboBoxSil(String selectedItem) {

		view.Sil(selectedItem);

	}

}
