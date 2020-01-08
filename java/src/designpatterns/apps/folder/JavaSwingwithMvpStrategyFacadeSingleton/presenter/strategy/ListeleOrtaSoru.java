/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaSwingwithMvpStrategyFacadeSingleton.presenter.strategy;

import java.io.BufferedReader;
import java.io.FileReader;

import JavaSwingwithMvpStrategyFacadeSingleton.main.Main;
import JavaSwingwithMvpStrategyFacadeSingleton.view.SoruBankasiView;

/**
 *
 * @author inanb
 */
public class ListeleOrtaSoru implements ListeleStrategy {

	private SoruBankasiView view;

	@Override
	public void Listele(String text) {

		String path3 = Main.PATH_CONTENT
				+ "SoruBankasi/TasarimDesenleriÇoktanSeçmeliOrta.txt";
		String path2 = Main.PATH_CONTENT
				+ "SoruBankasi/TasarimDesenleriKlasikOrta.txt";
		String path = Main.PATH_CONTENT
				+ "SoruBankasi/TasarimDesenleriDogruYanlisOrta.txt";

		if (text.equals("Orta")) {
			try {

				BufferedReader bf = new BufferedReader(new FileReader(path2));
				BufferedReader bf2 = new BufferedReader(new FileReader(path));
				BufferedReader bf3 = new BufferedReader(new FileReader(path3));

				String line = bf.readLine();
				String line2 = bf2.readLine();
				String line3 = bf3.readLine();

				System.out.println("Klasik Orta Sorular");
				while (line != null) {
					// view.updateStatusListeleTextField(line);

					System.out.println(line);
					line = bf.readLine();

				}
				System.out.println("Doğru Yanlış Orta Sorular");
				while (line2 != null) {

					System.out.println(line2);
					line2 = bf2.readLine();
				}

				System.out.println("Çoktan Seçmeli Orta Sorular");
				while (line3 != null) {

					System.out.println(line3);
					line3 = bf3.readLine();
				}
				System.out.println("Okuma İşlemi Başarılı");

			} catch (Exception hata) {
				hata.printStackTrace();
			}
		}

	}
}
