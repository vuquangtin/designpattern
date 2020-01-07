package strategies.mvp.app.presenter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import strategies.mvp.app.main.Main;
import strategies.mvp.app.model.Model;
import strategies.mvp.app.view.View;

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
		BufferedReader bf = null;
		try {

			bf = new BufferedReader(new FileReader(path));

			String line = bf.readLine();

			while (line != null) {
				view.updateStatusComboBox2(line);
				line = bf.readLine();

			}
			System.out.println("Okuma İşlemi Başarılı");

		} catch (Exception hata) {
			hata.printStackTrace();
		} finally {
			if (bf != null)
				try {
					bf.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

	public void comboBoxSil(String selectedItem) {

		view.Sil(selectedItem);

	}

}
