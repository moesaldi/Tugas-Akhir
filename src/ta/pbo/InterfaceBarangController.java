/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ta.pbo;

import com.jfoenix.controls.JFXTextField;
import com.mysql.jdbc.Connection;
import java.awt.HeadlessException;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Moesaldi
 */
public class InterfaceBarangController implements Initializable {

     @FXML
    private TableView<tampildatabarang> tabel;
    @FXML
    private TableColumn<tampildatabarang, String> kodecol;
    @FXML
    private TableColumn<tampildatabarang, String> namacol;
    @FXML
    private TableColumn<tampildatabarang, String> hargacol;
     @FXML
    private JFXTextField kodebar;
       @FXML
    private JFXTextField kodebar1;
     @FXML
    private JFXTextField namabar;
     @FXML
    private AnchorPane pane_home;
     @FXML
    private JFXTextField hargabar;
    private ObservableList<tampildatabarang> data;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         try {
            java.sql.Connection con = Config.configDB();
            data = FXCollections.observableArrayList();

            ResultSet rs = con.createStatement().executeQuery("select * from data_barang");

            while (rs.next()) {
                data.add(new tampildatabarang(rs.getString(1), rs.getString(2), rs.getString(3)));
            }

        } catch (SQLException ex) {
           System.out.println("Erorr"+ex);
           
        }
        kodecol.setCellValueFactory(new PropertyValueFactory<>("kodebar"));
        namacol.setCellValueFactory(new PropertyValueFactory<>("namabar"));
        hargacol.setCellValueFactory(new PropertyValueFactory<>("hargabar"));
        
        tabel.setItems(null);
        tabel.setItems(data);
    }    
   
    private void databarang(ActionEvent event) throws IOException {
         AnchorPane pane = FXMLLoader.load(getClass().getResource("InterfaceBarang.fxml"));
            pane_home.getChildren().setAll(pane);
    }

    private void datatrans(ActionEvent event) throws IOException {
         AnchorPane pane = FXMLLoader.load(getClass().getResource("InterfaceTransaksi.fxml"));
            pane_home.getChildren().setAll(pane);
    }
    
     @FXML
    private void simpan(ActionEvent event) {
                StringBuilder sviPaketi = new StringBuilder();
        if(kodebar.getText().equals("")||namabar.getText().equals("")||hargabar.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Lengkapi data barang");
        }
        else{
        try {
            String sql = "INSERT INTO data_barang VALUES('"+kodebar.getText()+"','"+namabar.getText()+"', '"+hargabar.getText()+"')";
            java.sql.Connection con=(Connection)Config.configDB();
            java.sql.PreparedStatement pst=con.prepareStatement(sql);
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Penyimpanan Data Berhasil");
            
          
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }  
    }

    @FXML
    private void tampil(ActionEvent event) {
       
         try {
            java.sql.Connection con = Config.configDB();
            data = FXCollections.observableArrayList();

            ResultSet rs = con.createStatement().executeQuery("select * from data_barang");

            while (rs.next()) {
                data.add(new tampildatabarang(rs.getString(1), rs.getString(2), rs.getString(3)));
            }

        } catch (SQLException ex) {
           System.out.println("Erorr"+ex);
           
        }
        kodecol.setCellValueFactory(new PropertyValueFactory<>("kodebar"));
        namacol.setCellValueFactory(new PropertyValueFactory<>("namabar"));
        hargacol.setCellValueFactory(new PropertyValueFactory<>("hargabar"));
        
        tabel.setItems(null);
        tabel.setItems(data);
        
    }
     @FXML
    private void hapus(ActionEvent event) {
    if(kodebar1.getText().equals("")){
        JOptionPane.showMessageDialog(null, "Mohon Cari Data Dahulu");}
        else{
            try {
            java.sql.Connection con = Config.configDB();
            data = FXCollections.observableArrayList();
            String hasil = "DELETE FROM data_barang WHERE kode_barang='"+kodebar1.getText()+"'";
            java.sql.PreparedStatement pst=con.prepareStatement(hasil);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Sukses Menghapus Siswa");
           
            } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Gagal Menghapus Siswa");
            }
        }
    }
}
