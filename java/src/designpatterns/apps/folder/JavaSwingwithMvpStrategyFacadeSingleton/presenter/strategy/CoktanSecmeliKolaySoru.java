/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaSwingwithMvpStrategyFacadeSingleton.presenter.strategy;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import JavaSwingwithMvpStrategyFacadeSingleton.main.Main;

/**
 *
 * @author inanb
 */

public class CoktanSecmeliKolaySoru implements SoruBankasiStrategy {

	@Override
	public void SoruKaydet(String dersAdiSelectedItem,
			String soruTipiSelectedItem, String zorlukDereceseiSelectedItem,
			String soruTextBoxItem, String soruYanitTextBoxItem,
			int soruPuanTextBoxItem) {
		String path2 = Main.PATH_CONTENT
				+ "SoruBankasi/TasarimDesenleriÇoktanSeçmeliKolay.txt";

		if (zorlukDereceseiSelectedItem.equals("Kolay")
				&& soruTipiSelectedItem.equals("Çoktan Seçmeli")) {
			try {

				File dosya = new File(path2);
				FileWriter yazici = new FileWriter(dosya, true);
				BufferedWriter yaz = new BufferedWriter(yazici);

				yaz.append(dersAdiSelectedItem);
				yaz.append(soruTipiSelectedItem);
				yaz.append(zorlukDereceseiSelectedItem);
				yaz.append(soruTextBoxItem);
				yaz.append(soruYanitTextBoxItem);
				yaz.append(String.valueOf(soruPuanTextBoxItem));

				yaz.newLine();
				yaz.close();
				System.out.println("Soru Kaydetme İşlemi Başarılı");

			}

			catch (Exception hata) {
				hata.printStackTrace();
			}
		}
	}

}
