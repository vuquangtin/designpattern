/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaSwingwithMvpStrategyFacadeSingleton.presenter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import JavaSwingwithMvpStrategyFacadeSingleton.main.Main;

/**
 *
 * @author mustafa
 */
public class Fonksiyonlar {

	public void GözetmenKaydet(String GozetmenText) {
		String path = Main.PATH_CONTENT + "Facade/Gozetmenler.txt";
		try {

			File dosya = new File(path);
			FileWriter yazici = new FileWriter(dosya, true);
			BufferedWriter yaz = new BufferedWriter(yazici);

			yaz.append(GozetmenText);
			yaz.newLine();

			yaz.close();

		} catch (Exception hata) {
			hata.printStackTrace();
		}
	}

	public void OgretimUyesiKaydet(String OgrText) {
		String path2 = "Content\\Facade\\OgretimUyeleri.txt";
		try {

			File dosya = new File(path2);
			FileWriter yazici2 = new FileWriter(dosya, true);
			BufferedWriter yaz2 = new BufferedWriter(yazici2);

			yaz2.append(OgrText);
			yaz2.newLine();

			yaz2.close();
			System.out
					.println("Gözetmen ve Ogretim Uyesi Kaydetme İşlemi Başarılı");

		} catch (Exception hata) {
			hata.printStackTrace();
		}
	}

	public void DerslikKaydet(String binaText, int salonText, String kodText,
			int kapasiteText) {
		String path2 = "Content\\Facade\\Derslikler.txt";
		try {

			File dosya = new File(path2);
			FileWriter yazici2 = new FileWriter(dosya, true);
			BufferedWriter yaz2 = new BufferedWriter(yazici2);
			yaz2.append(binaText + " ");
			yaz2.append(String.valueOf(salonText) + " ");
			yaz2.append(kodText + " ");
			yaz2.append(String.valueOf(kapasiteText) + " ");
			yaz2.newLine();
			yaz2.close();
			System.out.println("Derslik Kaydetme İşlemi Başarılı");

		} catch (Exception hata) {
			hata.printStackTrace();
		}
	}

}
