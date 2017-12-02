/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ta.pbo;

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

/**
 * FXML Controller class
 *
 * @author Moesaldi
 */
public class InterfaceTransaksiController implements Initializable {
  @FXML
 private TableView<tampildatatrans> tabel;    @FXML
    private TableColumn<tampildatatrans, String> notacol;
     @FXML
    private TableColumn<tampildatatrans, String> namacol;
    @FXML
    private TableColumn<tampildatatrans, String> totalcol;
    @FXML
    private JFXTextField nota;
    @FXML
    private JFXTextField nama;
    @FXML
    private JFXTextField total;
      
    private ObservableList<tampildatatrans> data;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         try {
            java.sql.Connection con = Config.configDB();
            data = FXCollections.observableArrayList();

            ResultSet rs = con.createStatement().executeQuery("select * from data_transaksi");

            while (rs.next()) {
                data.add(new tampildatatrans(rs.getString(1), rs.getString(2), rs.getString(3)));
            }

        } catch (SQLException ex) {
           System.out.println("Erorr"+ex);
           
        }
        notacol.setCellValueFactory(new PropertyValueFactory<>("nota"));
        namacol.setCellValueFactory(new PropertyValueFactory<>("nama"));
        totalcol.setCellValueFactory(new PropertyValueFactory<>("total"));
        
        tabel.setItems(null);
        tabel.setItems(data);
    }    

    @FXML
    private void refresh(ActionEvent event) {
         try {
            java.sql.Connection con = Config.configDB();
            data = FXCollections.observableArrayList();

            ResultSet rs = con.createStatement().executeQuery("select * from data_transaksi");

            while (rs.next()) {
                data.add(new tampildatatrans(rs.getString(1), rs.getString(2), rs.getString(3)));
            }

        } catch (SQLException ex) {
           System.out.println("Erorr"+ex);
           
        }
        notacol.setCellValueFactory(new PropertyValueFactory<>("nota"));
        namacol.setCellValueFactory(new PropertyValueFactory<>("nama"));
        totalcol.setCellValueFactory(new PropertyValueFactory<>("total"));
        
        tabel.setItems(null);
        tabel.setItems(data);
    }
    
}
