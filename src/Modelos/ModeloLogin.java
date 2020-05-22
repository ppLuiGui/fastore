/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import Dtos.UsuarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author jose rivera
 */
public class ModeloLogin extends Conexion {
    
    private Connection objConexion;
    
    public ModeloLogin() 
    {
        objConexion = getConexion();
        
    }
   
    public boolean login (UsuarioDTO usr)
    {
        //insersion a sql
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection con = getConexion();
        
        String sql = "SELECT * FROM usuarios WHERE correo = ?";
        try {
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, usr.getCorreo());
            resultSet = preparedStatement.executeQuery();
           if(resultSet.next())
           {
               if(usr.getPassword().equals(resultSet.getString(6))){
                   
                   // El Correo y Contraseña coinciden almacenamos todos sus datos
                   usr.setId(resultSet.getInt(1));
                   usr.setNombre(resultSet.getString(2));
                   usr.setUbicacion(resultSet.getString(3));
                   usr.setTelefono(resultSet.getString(4));
                   usr.setTipo_usuario(resultSet.getString(7));
                   
                   return true;
                   
               }else{
                  return false;
               }
              
           }
           return false;
            
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
        
    }
    
    
    
}
