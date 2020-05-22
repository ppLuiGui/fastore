/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import Dtos.CategoriaDTO;
import Dtos.ProductoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ppluigui
 */
public class ModeloCategorias extends Conexion {
 
     private Connection ObjConnection;
     
    
    public ModeloCategorias(){
         this.ObjConnection = getConexion();
    }
 
    
    public ArrayList<CategoriaDTO> obtenerLista() {
        
        ArrayList<CategoriaDTO> listaCategorias = new ArrayList<>();
        
       
        String sql = "SELECT * FROM categorias ORDER BY nombre"; 
        ResultSet rs = null;
        
        
        try {
            PreparedStatement sSQL = this.ObjConnection.prepareStatement(sql);
            
            rs = sSQL.executeQuery();
            
            if(rs.next()){
                do {
                    CategoriaDTO categoria = new CategoriaDTO();
                    categoria.setId_categoria(rs.getInt("id_categoria")   );
                    categoria.setNombre(rs.getString("nombre"));
                    listaCategorias.add(categoria);
                } while (rs.next() );
            }
            
         } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, e.toString());
           
           return null;
        }
        
        return listaCategorias;
        
    }
    
    
    public CategoriaDTO buscarPorId ( int categoriaId){
        
        
        String sql = "SELECT * FROM categorias WHERE id_categoria=?"; 
        ResultSet rs = null;
        
        
        try {
            PreparedStatement sSQL = this.ObjConnection.prepareStatement(sql);
            sSQL.setInt(1, categoriaId);
            rs = sSQL.executeQuery();
            
            if(rs.next()){
               
                CategoriaDTO categoria = new CategoriaDTO();
                categoria.setId_categoria(rs.getInt("id_categoria")   );
                categoria.setNombre(rs.getString("nombre"));
                
                return categoria;
            }
            
         } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, e.toString());
           
           return null;
        }
        
        return null;
        
    }
            
    
    
}
