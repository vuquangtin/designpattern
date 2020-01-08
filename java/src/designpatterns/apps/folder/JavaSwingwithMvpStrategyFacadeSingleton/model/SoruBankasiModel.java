/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaSwingwithMvpStrategyFacadeSingleton.model;

/**
 *
 * @author mustafa
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
