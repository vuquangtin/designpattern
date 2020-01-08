/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaSwingwithMvpStrategyFacadeSingleton.facade;


/**
 *
 * @author mustafa
 */
public class FacadeClass {
    
    SinavOlusturma s=new SinavOlusturma();
    SinavYoklamaListeleri syl = new SinavYoklamaListeleri();
    SinavYeriIlanListesi syil=new SinavYeriIlanListesi();
    
    public void SinavOlusturmaSinavOlustur(String ComboSelectedText){
    s.SinavOlustur(ComboSelectedText);
}

    public void SinavYoklamaListeleriSinavYoklamaOlustur(String Jderslik,String Jgözetmen){
        syl.SinavYoklamaOlustur( Jderslik, Jgözetmen);
    }
    
    public void SinavYeriIlanListesiSinavYeriOlustur(String Jderslik){
        syil.SinavYeriIlanListesiOlustur(Jderslik);
    }
   
    
}
