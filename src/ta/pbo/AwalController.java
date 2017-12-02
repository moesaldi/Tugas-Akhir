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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Moesaldi
 */
public class AwalController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void admin(ActionEvent event) throws IOException {
        ((Node)(event.getSource())).getScene().getWindow().hide();
        
        FXMLLoader fxmlLoader = new FXMLLoader();
              fxmlLoader.setLocation(getClass().getResource("LoginAdmin.fxml"));
              Scene scene = new Scene(fxmlLoader.load());
              
              Stage stage = new Stage();
                    stage.setResizable(false);
                    stage.setScene(scene);
                    stage.setTitle("LOGIN");
                    stage.show();
    }

    @FXML
    private void user(ActionEvent event) throws IOException {
        ((Node)(event.getSource())).getScene().getWindow().hide();
        
        FXMLLoader fxmlLoader = new FXMLLoader();
              fxmlLoader.setLocation(getClass().getResource("LoginUser.fxml"));
              Scene scene = new Scene(fxmlLoader.load());
              
              Stage stage = new Stage();
                    stage.setResizable(false);
                    stage.setScene(scene);
                    stage.setTitle("LOGIN");
                    stage.show();
    }
    
}
