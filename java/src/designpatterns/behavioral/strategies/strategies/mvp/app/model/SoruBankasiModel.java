/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategies.mvp.app.model;

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
public class SoruBankasiModel {

	private String soruTipi;
	private String soruZorlukDerecesi;
	private String soru;
	private String soruYanit;
	private int soruPuan;

	public String getSoruTipi() {
		return soruTipi;
	}

	public void setSoruTipi(String soruTipi) {
		this.soruTipi = soruTipi;
	}

	public String getSoruZorlukDerecesi() {
		return soruZorlukDerecesi;
	}

	public void setSoruZorlukDerecesi(String soruZorlukDerecesi) {
		this.soruZorlukDerecesi = soruZorlukDerecesi;
	}

	public String getSoru() {
		return soru;
	}

	public void setSoru(String soru) {
		this.soru = soru;
	}

	public String getSoruYanit() {
		return soruYanit;
	}

	public void setSoruYanit(String soruYanit) {
		this.soruYanit = soruYanit;
	}

	public int getSoruPuan() {
		return soruPuan;
	}

	public void setSoruPuan(int soruPuan) {
		this.soruPuan = soruPuan;
	}

}
