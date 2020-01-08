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
public class ContextListele {
     
    private ListeleStrategy lStrategy;

    public ContextListele(ListeleStrategy lStrategy) {
        this.lStrategy = lStrategy;
    }
   

   
   
    
    public void executeStrategy2(String text)
    {
        lStrategy.Listele(text);
       
    }
}
