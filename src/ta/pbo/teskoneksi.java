/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ta.pbo;

import java.sql.SQLException;

/**
 *
 * @author Moesaldi
 */
public class teskoneksi {
  public static void main(String[] args) throws SQLException {  
     Koneksi connection = new Koneksi();  
     connection.config();  
   }  
}
