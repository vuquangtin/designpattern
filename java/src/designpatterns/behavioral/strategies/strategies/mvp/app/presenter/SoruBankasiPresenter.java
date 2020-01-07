/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategies.mvp.app.presenter;

import java.io.BufferedReader;
import java.io.FileReader;

import strategies.mvp.app.main.Main;
import strategies.mvp.app.model.Model;
import strategies.mvp.app.model.SoruBankasiModel;
import strategies.mvp.app.view.SoruBankasiView;

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
public class SoruBankasiPresenter {

	String path = Main.PATH_CONTENT + "Dersler.txt";
	String path2 = Main.PATH_CONTENT
			+ "SoruBankasi/TasarimDesenleriÇoktanSeçmeliKolay.txt";
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

	public void messageBox(String message) {
		if (message.matches("a")) {
			view.updateMessageBox();
		}
	}

}
