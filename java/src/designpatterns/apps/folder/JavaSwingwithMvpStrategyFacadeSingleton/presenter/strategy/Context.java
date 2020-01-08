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
public class Context {
    
    private SoruBankasiStrategy sbStrategy;
    private ListeleStrategy lStrategy;

    public Context(ListeleStrategy lStrategy) {
        this.lStrategy = lStrategy;
    }
   

    public Context(SoruBankasiStrategy sbStrategy) {
        this.sbStrategy = sbStrategy;
        
    }
    
    public void executeStrategy(String dersAdiSelectedItem, 
                            String soruTipiSelectedItem, String zorlukDereceseiSelectedItem, String soruTextBoxItem, 
                            String soruYanitTextBoxItem, int soruPuanTextBoxItem)
    {
        sbStrategy.SoruKaydet(dersAdiSelectedItem, soruTipiSelectedItem, zorlukDereceseiSelectedItem, 
                                soruTextBoxItem, soruYanitTextBoxItem, soruPuanTextBoxItem);
        
       
    }
    
    public void executeStrategy2(String text)
    {
        lStrategy.Listele(text);
       
    }
    
}
