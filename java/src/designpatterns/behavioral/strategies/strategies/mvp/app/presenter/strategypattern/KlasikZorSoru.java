/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategies.mvp.app.presenter.strategypattern;

import java.io.BufferedWriter;
import java.io.File;
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

public class KlasikZorSoru implements SoruBankasiStrategy {

	@Override
	public void SoruKaydet(String dersAdiSelectedItem,
			String soruTipiSelectedItem, String zorlukDereceseiSelectedItem,
			String soruTextBoxItem, String soruYanitTextBoxItem,
			int soruPuanTextBoxItem) {
		String path2 = Main.PATH_CONTENT
				+ "SoruBankasi/TasarimDesenleriKlasikZor.txt";

		if (zorlukDereceseiSelectedItem.equals("Zor")
				&& soruTipiSelectedItem.equals("Klasik")) {
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
