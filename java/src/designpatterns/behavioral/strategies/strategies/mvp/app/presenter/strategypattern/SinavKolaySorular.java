/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategies.mvp.app.presenter.strategypattern;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import strategies.mvp.app.main.Main;

/**
 * <h1>Strategy</h1> Định nghĩa tập hợp các thuật toán, đóng gói từng thuật toán
 * lại, và làm chúng hoán đổi lẫn nhau. Strategy cho phép thuật toán biến đổi
 * độc lập khi người dùng sử dụng chúng.
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com

 *      /vuquangtin/designpattern</a>
 *
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
