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
public class tampildatatrans {
      private final StringProperty nota;
    private final StringProperty nama;
    
    private final StringProperty total;

    public tampildatatrans(String nota, String nama, String total) {
        this.nota = new SimpleStringProperty(nota);
        this.nama = new SimpleStringProperty(nama);
        this.total = new SimpleStringProperty(total);

    }

    tampildatatrans(String string, String string0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getnota() {
        return nota.get();
    }

    public String getnama() {
        return nama.get();
    }

    
   
    public String gettotal() {
        return total.get();
    }

    public void setnota(String value) {
        nota.set(value);
    }

    public void setnama(String value) {
        nama.set(value);
    }

   
     public void settotal(String value) {
        total.set(value);
    }

    public StringProperty notaProperty() {
        return nota;
    }

    public StringProperty namaProperty() {
        return nama;
    }

    
    
    public StringProperty totalProperty() {
        return total;
    }

}





