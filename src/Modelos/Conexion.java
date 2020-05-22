/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jose rivera
 */
public class Conexion {
    
    private final String baseDeDatos    = "fastore";
    private final String usuario        = "root";
    private final String password       = "helloworld";
    private final String url            = "jdbc:mysql://localhost:3308/fastore";
    private Connection objConexion      = null;
    
    public Connection getConexion()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");            
            objConexion = DriverManager.getConnection(url, usuario, password);
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return objConexion;
    }
       
    
    
    
    
}
