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
public class ModeloCliente extends Conexion {
    
    
    private Connection ObjConnection;
    
    public ModeloCliente(){
        this.ObjConnection = getConexion();
    }
    
    
    public ArrayList<ClienteDTO>  obtenerLista() {
        
        Connection objConnection = getConexion();
        
        String sql = "SELECT * FROM usuarios WHERE tipo_usuario='CLIENTE' ORDER BY nombre";
        ArrayList<ClienteDTO> listaClientes = new ArrayList<>();
        ResultSet resultSet;
        try{
            Statement statement = objConnection.createStatement();
            resultSet = statement.executeQuery(sql);
            
            while (resultSet.next() ) {
                ClienteDTO cliente = new ClienteDTO();
                
                int cteId = resultSet.getInt("id");
                String cteNombre = resultSet.getString("nombre");
                String cteUbicacion = resultSet.getString("ubicacion");
                String cteTelefono = resultSet.getString("telefono");
                String cteCorreo = resultSet.getString("correo");
                
                cliente.setId(cteId);
                cliente.setNombre(cteNombre);
                cliente.setUbicacion(cteUbicacion);
                cliente.setTelefono(cteTelefono);
                cliente.setCorreo(cteCorreo);
                
                listaClientes.add(cliente);
             
            }
            
            return listaClientes;
            
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, e.toString());
            return listaClientes;
        }
  
    }
    
    
    public ClienteDTO buscarPorId(int clienteId) {
        
        ClienteDTO cliente = new ClienteDTO();
        String sql = "SELECT * FROM usuarios WHERE id=? AND tipo_usuario='CLIENTE'"; 
        ResultSet rs = null;
        
        
        try {
            PreparedStatement sSQL = this.ObjConnection.prepareStatement(sql);
            sSQL.setInt(1, clienteId);
        
            rs = sSQL.executeQuery();
            
            if(rs.next()){
            
                int cteId = rs.getInt("id");
                String cteNombre = rs.getString("nombre");
                String cteUbicacion = rs.getString("ubicacion");
                String cteTelefono = rs.getString("telefono");
                String cteCorreo = rs.getString("correo");
                
                cliente.setId(cteId);
                cliente.setNombre(cteNombre);
                cliente.setUbicacion(cteUbicacion);
                cliente.setTelefono(cteTelefono);
                cliente.setCorreo(cteCorreo);
                
            }
            
         } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, e.toString());
           
           return null;
        }
        
     
        return cliente;
        
    }
    
    public int existeCliente(String nombreCliente) {
        
        //insersion a sql
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        
        String sql = "SELECT count(id) FROM usuarios WHERE nombre = ?";//esto representa los valores que seran insertados en la tabla
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, nombreCliente);
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
    
    
    public boolean registrar(ClienteDTO clienteDTO)//es para poder registrar un usuario
    {
        //insersion a sql
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "INSERT INTO usuarios (nombre, ubicacion, telefono, correo, password, tipo_usuario) "
                + "VALUES (?,?,?,?,?,?)";//esto representa los valores que seran insertados en la tabla
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, clienteDTO.getNombre());
            ps.setString(2, clienteDTO.getUbicacion());
            ps.setString(3, clienteDTO.getTelefono());
            ps.setString(4, clienteDTO.getCorreo());
            ps.setString(5, clienteDTO.getPassword());
            ps.setString(6, "CLIENTE");
            
            ps.execute();
            return true;
            
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
        
    }
    
}
