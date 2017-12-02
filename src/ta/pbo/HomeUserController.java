/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ta.pbo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Moesaldi
 */
public class HomeUserController implements Initializable {

    @FXML
    private AnchorPane pane_home;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

  

    @FXML
    private void exit(ActionEvent event) {
                        System.exit(0);

    }

    @FXML
    private void file(ActionEvent event) {
    }
 @FXML
    private void home(ActionEvent event) throws IOException {
 AnchorPane pane = FXMLLoader.load(getClass().getResource("halaman1.fxml"));
            pane_home.getChildren().setAll(pane);    }

    @FXML
    private void databar(ActionEvent event) throws IOException {
         AnchorPane pane = FXMLLoader.load(getClass().getResource("datatransaksi.fxml"));
            pane_home.getChildren().setAll(pane);
    }

    @FXML
    private void transaksi(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("TransaksiUser.fxml"));
            pane_home.getChildren().setAll(pane);
    }
    
}
