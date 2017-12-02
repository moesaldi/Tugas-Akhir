/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ta.pbo;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.awt.HeadlessException;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Moesaldi
 */
public class LoginUserController implements Initializable {

    @FXML
    private JFXTextField username;
    @FXML
    private JFXPasswordField password;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void login(ActionEvent event) throws IOException {
            Connection con;
        Statement stat;
        ResultSet rs;
        String sql;

        Koneksi DB = new Koneksi();
        DB.config();
        con = (Connection) DB.con;
        stat = (Statement) DB.stm;
        
        if(username.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Tuliskan Username Anda");
        }
        else if(password.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Tuliskan Password Anda");
        }
        else{
        try {
            sql = "SELECT * FROM user WHERE username='"+username.getText()+"' AND password='"+password.getText()+"'";
            rs = stat.executeQuery(sql);
            if(rs.next()){
                if(username.getText().equals(rs.getString("username")) && password.getText().equals(rs.getString("password"))){
                    JOptionPane.showMessageDialog(null, "Berhasil Login");
                    // Hide this current window (if this is what you want)
                    ((Node)(event.getSource())).getScene().getWindow().hide();

                    // Load the new fxml
                    
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("HomeUser.fxml"));
                    Scene scene = new Scene(fxmlLoader.load());

                    // Create new stage (window), then set the new Scene
                    Stage stage = new Stage();
                    stage.setResizable(false);
                    stage.setScene(scene);
                    stage.setTitle("Halaman User");
                    stage.show();
                }
            }else{
                    JOptionPane.showMessageDialog(null, "Username Atau Password Salah");
                }
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
}
}
