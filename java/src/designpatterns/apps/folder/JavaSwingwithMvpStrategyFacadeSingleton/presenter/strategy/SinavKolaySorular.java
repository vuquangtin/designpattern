/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaSwingwithMvpStrategyFacadeSingleton.presenter.strategy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import JavaSwingwithMvpStrategyFacadeSingleton.main.Main;

/**
 *
 * @author inanb
 */
public class SinavKolaySorular implements SinavOlusturmaStrategy {

	@Override
	public void SinavOlustur(String dersAdiSelectedItem,
			String kategoriSelectedItem, String seviyeSelectedItem,
			String derslikSelectedItem, String gozetmenSelectedItem,
			int sinavSoruTextBoxItem) {

		String path3 = Main.PATH_CONTENT
				+ "SoruBankasi/TasarimDesenleriÇoktanSeçmeliKolay.txt";
		String path2 = Main.PATH_CONTENT
				+ "SoruBankasi/TasarimDesenleriKlasikKolay.txt";
		String path = Main.PATH_CONTENT
				+ "SoruBankasi/TasarimDesenleriDogruYanlisKolay.txt";
		String path5 = Main.PATH_CONTENT + "Sinavlar.txt";

		if (seviyeSelectedItem.equals("Kolay")
				&& kategoriSelectedItem.equals("Çoktan Seçmeli")) {

			int sorusayisiZor = (sinavSoruTextBoxItem * 20) / 100;
			int sorusayisiOrta = (sinavSoruTextBoxItem * 30) / 100;
			int sorusayisiKolay = (sinavSoruTextBoxItem * 50) / 100;

			try {

				File dosya = new File(path5);
				FileWriter yazici = new FileWriter(dosya, true);
				BufferedWriter yaz = new BufferedWriter(yazici);

				yaz.append(dersAdiSelectedItem);
				yaz.append(kategoriSelectedItem);
				yaz.append(seviyeSelectedItem);
				yaz.append(derslikSelectedItem);
				yaz.append(gozetmenSelectedItem);
				yaz.append(String.valueOf(sinavSoruTextBoxItem));
				yaz.newLine();

				System.out.println("Yazma İşlemi Başarılı");

				// BufferedReader bf=new BufferedReader(new FileReader(path2));
				// BufferedReader bf2=new BufferedReader(new FileReader(path));
				BufferedReader bf3 = new BufferedReader(new FileReader(path3));

				// String line=bf.readLine();
				// String line2=bf2.readLine();
				String line3 = bf3.readLine();

				System.out.println("Klasik Kolay Sorular");

				for (int i = 0; i <= sorusayisiZor; i++) {

					System.out.println(line3);
					line3 = bf3.readLine();
					yaz.append(line3);
					yaz.newLine();

				}
				yaz.close();
			} catch (Exception hata) {
				hata.printStackTrace();
			}

		}

	}

}
