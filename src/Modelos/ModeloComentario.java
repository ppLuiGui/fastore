/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import Dtos.ClienteDTO;
import Dtos.ComentarioDTO;
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
public class ModeloComentario extends Conexion{
    
    private Connection ObjConnection;
     
    
    public ModeloComentario(){
         this.ObjConnection = getConexion();
    }
 
    public void guardarComentario(ComentarioDTO comentario ){
        
        String sqlComentario = "INSERT INTO comentarios (comentario, fecha, cliente_id, proveedor_id, leido) VALUES (?,?,?,?,?)"; 
        
        int pedidoId = 0;
        
        try {
            PreparedStatement sSQL = this.ObjConnection.prepareStatement(sqlComentario);
            sSQL.setString(1, comentario.getComentario()  );
            sSQL.setString(2, comentario.getFecha() );
            sSQL.setInt(3, comentario.getCliente_id() );
            sSQL.setInt(4, comentario.getProveedor_id());
            sSQL.setInt(5, comentario.getLeido());
            
            sSQL.executeUpdate();
            
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, e.toString());
           
        }
        
    }
    
    
    
    public ArrayList<ComentarioDTO> listarPorProveedorId(int proveedorId) {
        
        
        ArrayList<ComentarioDTO> listaComentarios = new ArrayList<>();
        
       
        String sql = "SELECT * FROM comentarios WHERE proveedor_id =? ORDER BY fecha DESC"; 
        ResultSet rs = null;
        
        
        try {
            PreparedStatement sSQL = this.ObjConnection.prepareStatement(sql);
            sSQL.setInt(1, proveedorId);
            rs = sSQL.executeQuery();
            
            if(rs.next()){
                do {
                    ComentarioDTO comentario = new ComentarioDTO();
                    comentario.setId_comentario(rs.getInt("id_comentario"));
                    comentario.setComentario(rs.getString("comentario"));
                    comentario.setFecha(rs.getString("fecha"));
                    comentario.setCliente_id(rs.getInt("cliente_id"));
                    comentario.setProveedor_id(rs.getInt("proveedor_id"));
                    comentario.setLeido(rs.getInt("leido"));
                    
                    // Agregamos los detalles del cliente
                    ModeloCliente mCliente = new ModeloCliente();
                    ClienteDTO cliente = mCliente.buscarPorId(rs.getInt("cliente_id"));                    
                    comentario.setCliente(cliente);
                    
                    listaComentarios.add(comentario);
                } while (rs.next() );
            }
            
         } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, e.toString());
           
           return null;
        }
        
        return listaComentarios;
        
        
    }
    
    
    
    public void marcarComoLeido(int comentarioId) {
        
        String sqlComentario= "UPDATE comentarios SET leido = 1  WHERE id_comentario=?"; 
        ResultSet rs = null;
        
        
        try {
            
            PreparedStatement sSQL = this.ObjConnection.prepareStatement(sqlComentario);
            sSQL.setInt(1,comentarioId);
            
        
            sSQL.executeUpdate();
            
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, e.toString());
           
        }
        
    }
    
}
