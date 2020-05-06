/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaSwingwithMvpStrategyFacadeSingleton.facade;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

import com.itextpdf.text.Document;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import JavaSwingwithMvpStrategyFacadeSingleton.main.Main;

/**
 *
 * @author inanb
 */
public class SinavYeriIlanListesi {

	public void SinavYeriIlanListesiOlustur(String Jderslik) {

		try {
			String path = Main.PATH_CONTENT + "Facade/OgrenciListesi2.xls";
			String path2 = Main.PATH_CONTENT
					+ "Facade/SinvaYeriIlanListesi.pdf";

			/*
			 * Cell cell = row.createCell(0); cell.setCellValue("201413171074");
			 * 
			 * FileOutputStream fileout = new FileOutputStream(path);
			 * wb.write(fileout); fileout.close();
			 */
			FileInputStream fi = new FileInputStream(new File(path));

			HSSFWorkbook workbook = new HSSFWorkbook(fi);

			HSSFSheet sheet = workbook.getSheetAt(0);

			Iterator<Row> rowIterator = sheet.iterator();

			Document document = new Document();

			PdfWriter.getInstance(document, new FileOutputStream(path2));
			document.open();

			PdfPTable my_table = new PdfPTable(3);

			PdfPCell table_cell;

			while (rowIterator.hasNext()) {

				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					CellType type = cell.getCellType();

					if (type == CellType.STRING) {

						table_cell = new PdfPCell(new Phrase(
								cell.getStringCellValue()));

						my_table.addCell(table_cell);

					}

				}

			}

			document.add(my_table);

			System.out.println("Sinav Yeri Ilan Listesi Oluşturuldu.");
			document.close();

			document.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
