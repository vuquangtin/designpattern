/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaSwingwithMvpStrategyFacadeSingleton.presenter.strategy;

/**
 *
 * @author inanb
 */
public interface SoruBankasiStrategy {
    
    public void SoruKaydet(String dersAdiSelectedItem,String soruTipiSelectedItem,String zorlukDereceseiSelectedItem,
                            String soruTextBoxItem, String soruYanitTextBoxItem , int soruPuanTextBoxItem);
    
   
    
}
