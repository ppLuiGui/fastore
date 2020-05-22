/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Dtos.ProductoDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;


/**
 *
 * @author ppluigui
 */
public class ModeloProducto extends Conexion {
    
    private Connection ObjConnection;
    
    
    public ModeloProducto(){
        this.ObjConnection = getConexion();
    }
    
    
    public ProductoDTO buscarProductoPorClave( String claveProducto ) {
        
        ProductoDTO producto = new ProductoDTO();
        String sql = "SELECT * FROM productos WHERE clave=?"; 
        ResultSet rs = null;
        
        
        try {
            PreparedStatement sSQL = this.ObjConnection.prepareStatement(sql);
            sSQL.setString(1, claveProducto);
        
            rs = sSQL.executeQuery();
            
            if(rs.next()){
            
                producto.setId_producto(  rs.getInt(1)   );
                producto.setClave(claveProducto);
                producto.setNombre(rs.getString(3));
                producto.setPrecio(rs.getDouble(4));
                producto.setUnidad(rs.getString(5));
                producto.setDetalles(rs.getString(6));
                producto.setCategoria_id(rs.getInt(7));
                producto.setProveedor_id(rs.getInt(8));
                
            }
            
         } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, e.toString());
           
           return null;
        }
        
     
        return producto;
    }
    
    
    public ProductoDTO buscarProductoPorId( int productoId ) {
        
        ProductoDTO producto = new ProductoDTO();
        String sql = "SELECT * FROM productos WHERE id_producto=?"; 
        ResultSet rs = null;
        
        
        try {
            PreparedStatement sSQL = this.ObjConnection.prepareStatement(sql);
            sSQL.setInt(1, productoId);
        
            rs = sSQL.executeQuery();
            
            if(rs.next()){
            
                producto.setId_producto(  rs.getInt(1)   );
                producto.setClave(rs.getString(2));
                producto.setNombre(rs.getString(3));
                producto.setPrecio(rs.getDouble(4));
                producto.setUnidad(rs.getString(5));
                producto.setDetalles(rs.getString(6));
                producto.setCategoria_id(rs.getInt(7));
                producto.setProveedor_id(rs.getInt(8));
                
            }
            
         } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, e.toString());
           
           return null;
        }
        
     
        return producto;
    }
    
    
    public ArrayList<ProductoDTO> listarTodos(){
        
        ArrayList<ProductoDTO> listaProductos = new ArrayList<>();
        
       
        String sql = "SELECT * FROM productos ORDER BY nombre"; 
        ResultSet rs = null;
        
        
        try {
            PreparedStatement sSQL = this.ObjConnection.prepareStatement(sql);
            
            rs = sSQL.executeQuery();
            
            if(rs.next()){
                do {
                    ProductoDTO producto = new ProductoDTO();
                    producto.setId_producto(  rs.getInt("id_producto")   );
                    producto.setClave(rs.getString("clave"));
                    producto.setNombre(rs.getString("nombre"));
                    producto.setPrecio(rs.getDouble("precio"));
                    producto.setUnidad(rs.getString("unidad"));
                    producto.setDetalles(rs.getString("detalles"));
                    producto.setCategoria_id(rs.getInt("categoria_id"));
                    producto.setProveedor_id(rs.getInt("proveedor_id"));
                    listaProductos.add(producto);
                } while (rs.next() );
            }
            
         } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, e.toString());
           
           return null;
        }
        
        return listaProductos;
    }
 
    
    
    public void guardarProducto(ProductoDTO producto) {
        
        String sqlEncabezado = "INSERT INTO productos ( clave, nombre, precio, detalles, categoria_id, proveedor_id  ) VALUES (?,?,?,?,?,?)"; 
        ResultSet rs = null;
        int pedidoId = 0;
        
        try {
            
            PreparedStatement sSQL = this.ObjConnection.prepareStatement(sqlEncabezado);
            sSQL.setString(1, producto.getClave() );
            sSQL.setString(2, producto.getNombre());
            sSQL.setDouble(3, producto.getPrecio());
            sSQL.setString(4, producto.getDetalles());
            sSQL.setInt(5, producto.getCategoria_id());
            sSQL.setInt(6, producto.getProveedor_id());
            
        
            sSQL.executeUpdate();
            
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, e.toString());
           
        }
        
    }
    
    public void modificarProducto(ProductoDTO producto) {
        
        String sqlEncabezado = "UPDATE productos SET clave = ?, nombre = ?, precio = ?, detalles =?, categoria_id =?, proveedor_id =? WHERE id_producto=?"; 
        ResultSet rs = null;
        int pedidoId = 0;
        
        try {
            
            PreparedStatement sSQL = this.ObjConnection.prepareStatement(sqlEncabezado);
            sSQL.setString(1, producto.getClave() );
            sSQL.setString(2, producto.getNombre());
            sSQL.setDouble(3, producto.getPrecio());
            sSQL.setString(4, producto.getDetalles());
            sSQL.setInt(5, producto.getCategoria_id());
            sSQL.setInt(6, producto.getProveedor_id());
            sSQL.setInt(7, producto.getId_producto());
            
        
            sSQL.executeUpdate();
            
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, e.toString());
           
        }
        
    }
    
    public void eliminarProducto(int productoId){
        
        String sqlDetalle = "DELETE from productos WHERE id_producto=?";
        try {
            PreparedStatement sSQL = this.ObjConnection.prepareStatement(sqlDetalle);
            sSQL.setInt(1, productoId);
            sSQL.executeUpdate();
            
         } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, e.toString());
         }
    }
    
    
    
    
    
    
    
}
