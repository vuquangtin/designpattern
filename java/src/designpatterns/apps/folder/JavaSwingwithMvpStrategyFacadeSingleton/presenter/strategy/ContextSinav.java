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
public class ContextSinav {
     
    private SinavOlusturmaStrategy sStrategy;

    public ContextSinav(SinavOlusturmaStrategy sStrategy) {
        this.sStrategy = sStrategy;
    }
   

   
   
    
    public void executeStrategy3(String dersAdiSelectedItem,String kategoriSelectedItem,String seviyeSelectedItem,String derslikSelectedItem,
                            String gozetmenSelectedItem , int sinavSoruTextBoxItem)
    {
        sStrategy.SinavOlustur(dersAdiSelectedItem,kategoriSelectedItem, seviyeSelectedItem, derslikSelectedItem,
                             gozetmenSelectedItem ,  sinavSoruTextBoxItem);
       
    }
}
