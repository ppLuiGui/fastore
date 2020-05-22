/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import Dtos.ClienteDTO;
import Dtos.ProveedorDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;


/**
 *
 * @author ppluigui
 */
public class ModeloProveedor extends Conexion {
    
    
    private Connection ObjConnection;
    
    public ModeloProveedor(){
        this.ObjConnection = getConexion();
    }
    
    
    public ArrayList<ProveedorDTO>  obtenerLista() {
        
        Connection objConnection = getConexion();
        
        
        String sql = "SELECT * FROM usuarios WHERE tipo_usuario='PROVEEDOR' ORDER BY nombre";
        ArrayList<ProveedorDTO> listaProveedores = new ArrayList<>();
        ResultSet resultSet;
        try{
            Statement statement = objConnection.createStatement();
            resultSet = statement.executeQuery(sql);
            
            while (resultSet.next() ) {
                ProveedorDTO proveedor = new ProveedorDTO();
                
                int ProvId = resultSet.getInt("id");
                String ProvNombre = resultSet.getString("nombre");
                String ProvUbicacion = resultSet.getString("ubicacion");
                String ProvTelefono = resultSet.getString("telefono");
                String ProvCorreo = resultSet.getString("correo");
                
                proveedor.setId(ProvId);
                proveedor.setNombre(ProvNombre);
                proveedor.setUbicacion(ProvUbicacion);
                proveedor.setTelefono(ProvTelefono);
                proveedor.setCorreo(ProvCorreo);
                
                listaProveedores.add(proveedor);
             
            }
            
            return listaProveedores;
            
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, e.toString());
            return listaProveedores;
        }
  
    }
    
      public int existeProveedor(String nombreProveedor) {
        
        //insersion a sql
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        
        String sql = "SELECT count(id) FROM usuarios WHERE nombre = ?";//esto representa los valores que seran insertados en la tabla
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, nombreProveedor);
            rs = ps.executeQuery();
           if(rs.next())
           {
               return rs.getInt(1);//vamos a retornar el valor que nos esta regresando la consulta(porque va a contar cuantos resgitros hay)
           }
           return 1;
            
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, e.toString());
            return 1;
        }
    }
    
    
    public boolean registrar(ProveedorDTO proveedorDTO)//es para poder registrar un usuario
    {
        //insersion a sql
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "INSERT INTO usuarios (nombre, ubicacion, telefono, correo, password, tipo_usuario) "
                + "VALUES (?,?,?,?,?,?)";//esto representa los valores que seran insertados en la tabla
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, proveedorDTO.getNombre());
            ps.setString(2, proveedorDTO.getUbicacion());
            ps.setString(3, proveedorDTO.getTelefono());
            ps.setString(4, proveedorDTO.getCorreo());
            ps.setString(5, proveedorDTO.getPassword());
            ps.setString(6, "PROVEEDOR");
            
            ps.execute();
            return true;
            
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
        
    }
    
}
