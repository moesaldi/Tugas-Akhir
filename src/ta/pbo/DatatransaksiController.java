/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ta.pbo;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Moesaldi
 */
public class DatatransaksiController implements Initializable {

    @FXML
    private AnchorPane pane_home;
    @FXML
    private JFXTextField nota;
    @FXML
    private JFXTextField nama;
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
    private JFXTextField namabar;

    @FXML
    private JFXTextArea hasil;

    @FXML
    private JFXTextField harga;

    @FXML
    private JFXTextField jumlah;
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

    @FXML
    private void proses(ActionEvent event) throws SQLException {
      
        hasil.setText("No Nota : "+nota.getText()+"\nNama Pembeli : "+nama.getText()+"\nNama Barang : "+namabar.getText()+"\nTotal Bayar : "+harga.getText()+"");
    }

    @FXML
    private void refresh(ActionEvent event) {
    }
    
}
