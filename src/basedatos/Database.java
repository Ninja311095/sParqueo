/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basedatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author heracles
 */
public class Database {
    private final String USER = "parqueo";
    private final String PASSWORD = "imdump";
    private final String DBNANME = "bdparqueo";
    private final int PORT = 3306;
    private static Database db = null;
    public Connection connection = null;
    
    private Database(){
        establecerConexion();
    }
    
    private void establecerConexion(){
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:" + PORT + "/" + DBNANME, USER, PASSWORD);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "establecerConexion: " + e.getMessage());
        }
    }
    
    public static Database obtenerInstancia(){
        if(db == null){
            db = new Database();
        }
        
        return db;
    }
}
