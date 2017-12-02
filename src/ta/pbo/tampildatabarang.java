/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ta.pbo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Moesaldi
 */
public class tampildatabarang {
      private final StringProperty kodebar;
    private final StringProperty namabar;
    
    private final StringProperty hargabar;

    public tampildatabarang(String kodebar, String namabar, String hargabar) {
        this.kodebar = new SimpleStringProperty(kodebar);
        this.namabar = new SimpleStringProperty(namabar);
        this.hargabar = new SimpleStringProperty(hargabar);

    }

    tampildatabarang(String string, String string0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getkodebar() {
        return kodebar.get();
    }

    public String getnamabar() {
        return namabar.get();
    }

    
   
    public String gethargabar() {
        return hargabar.get();
    }

    public void setkodebar(String value) {
        kodebar.set(value);
    }

    public void setnamabar(String value) {
        namabar.set(value);
    }

   
     public void sethargabar(String value) {
        hargabar.set(value);
    }

    public StringProperty kodebarProperty() {
        return kodebar;
    }

    public StringProperty namabarProperty() {
        return namabar;
    }

    
    
    public StringProperty hargabarProperty() {
        return hargabar;
    }

}




