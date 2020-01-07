/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategies.mvp.app.presenter.strategypattern;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 *
 * @author inanb
 */

public class DogruYanlisKolaySoru implements SoruBankasiStrategy{

    
    @Override
    public void SoruKaydet(String dersAdiSelectedItem, 
                            String soruTipiSelectedItem, String zorlukDereceseiSelectedItem, String soruTextBoxItem, 
                            String soruYanitTextBoxItem, int soruPuanTextBoxItem) 
    {
        String path2 = "Content\\SoruBankasi\\TasarimDesenleriDogruYanlisKolay.txt";
        
       
        
        if(zorlukDereceseiSelectedItem.equals("Kolay")&&soruTipiSelectedItem.equals("Doğru Yanlış"))  {      
            try{
                
                  
                  File dosya = new File(path2);
                  FileWriter yazici = new FileWriter(dosya,true);
                  BufferedWriter yaz = new BufferedWriter(yazici);
                  
                  yaz.append(dersAdiSelectedItem);
                  yaz.append(soruTipiSelectedItem);
                  yaz.append(zorlukDereceseiSelectedItem);
                  yaz.append(soruTextBoxItem);
                  yaz.append(soruYanitTextBoxItem);
                  yaz.append(String.valueOf(soruPuanTextBoxItem));
                 
                 

                  yaz.newLine();
                  yaz.close();
                  System.out.println("Soru Kaydetme İşlemi Başarılı");
                  
            }
            
            catch(Exception hata){
                  hata.printStackTrace();
            }
        }
    }
    
}
