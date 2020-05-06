/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaSwingwithMvpStrategyFacadeSingleton.facade;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import JavaSwingwithMvpStrategyFacadeSingleton.main.Main;

/**
 *
 * @author mustafa
 */
public class SinavOlusturma {

	public void SinavOlustur(String ComboSelectedText) {
		Document d = new Document(PageSize.A4);

		String path = Main.PATH_CONTENT + "SoruBankasi/" + ComboSelectedText
				+ ".txt";
		String path2 = Main.PATH_CONTENT + "Facade/SinavDöküman.pdf";

		try {
			PdfWriter writer = PdfWriter.getInstance(d, new FileOutputStream(
					path2));

			d.open();
			BufferedReader bf = new BufferedReader(new FileReader(path));

			String line = bf.readLine();

			while (line != null) {
				line = bf.readLine();
				d.add(new Paragraph(line));

			}
			d.close();
			writer.close();

			System.out.println("Okuma İşlemi Başarılı");

		} catch (Exception hata) {
			hata.printStackTrace();
		}

	}
}
