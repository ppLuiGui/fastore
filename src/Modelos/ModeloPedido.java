/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import Dtos.PedidoDTO;
import Dtos.PedidoDetalleDTO;
import Dtos.PedidoEncabezadoDTO;
import Dtos.ProductoDTO;
import Dtos.UsuarioDTO;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author ppluigui
 */
public class ModeloPedido extends Conexion{
    
     private Connection ObjConnection;
     
    
    public ModeloPedido(){
         this.ObjConnection = getConexion();
    }
 
    
    public int guardarPedido( PedidoEncabezadoDTO pedEncabezado, ArrayList<PedidoDetalleDTO> pedDetalles  ){
        
        
        String sqlEncabezado = "INSERT INTO pedidos (proveedor_id, cliente_id, fecha, total, status) VALUES (?,?,?,?,?)"; 
        ResultSet rs = null;
        int pedidoId = 0;
        
        try {
            PreparedStatement sSQL = this.ObjConnection.prepareStatement(sqlEncabezado, Statement.RETURN_GENERATED_KEYS);
            sSQL.setInt(1, pedEncabezado.getProveedor_id() );
            sSQL.setInt(2, pedEncabezado.getCliente_id());
            sSQL.setString(3, pedEncabezado.getFecha());
            
            sSQL.setDouble(4, pedEncabezado.getTotal());
            sSQL.setInt(5, pedEncabezado.getStatus());
            
        
            sSQL.executeUpdate();
            
            rs = sSQL.getGeneratedKeys();
            if(rs.next()){
                
                pedidoId = rs.getInt(1);
                
                // una vez que tenemos el Id de Pedido insertamos los detalles
                for(PedidoDetalleDTO pedDtl : pedDetalles ){
                    String sqlDetalle = "INSERT INTO pedidos_detalles (id_pedido, id_producto, cantidad, precio) VALUES (?,?,?,?)";
                    
                    PreparedStatement sSqlDetalle = this.ObjConnection.prepareStatement(sqlDetalle);
                    sSqlDetalle.setInt(1, pedidoId);
                    sSqlDetalle.setInt(2, pedDtl.getId_producto());
                    sSqlDetalle.setInt(3, pedDtl.getCantidad());
                    sSqlDetalle.setDouble(4, pedDtl.getPrecio());
                    sSqlDetalle.execute();
                    
                }
               
            }
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, e.toString());
           return 0;
        }
        
        return pedidoId;
    }
    
    public ArrayList<PedidoDTO> listaPorProveedor(int proveedorId) {
        ArrayList<PedidoDTO> pedidos = new ArrayList<>();
        ModeloProducto mProducto = new ModeloProducto();
        int clientId = UsuarioDTO.getId(); 
        
        String sql = "SELECT * FROM pedidos WHERE proveedor_id=? AND cliente_id=?"; 
        ResultSet rs = null;
        
        
        try {
            PreparedStatement sSQL = this.ObjConnection.prepareStatement(sql);
            sSQL.setInt(1, proveedorId);
            sSQL.setInt(2, clientId);
        
            rs = sSQL.executeQuery();
            
            if(rs.next()){
                
                // Generaremos una lista de Pedidos
                do {
                    // Cada pedido tiene encabezado y detalles iniciamos con encabezado
                    PedidoDTO pedidoDto = new PedidoDTO();
                    
                    pedidoDto.setId_pedido( rs.getInt("id_pedido") );
                    pedidoDto.setProveedor_id(rs.getInt("proveedor_id"));
                    pedidoDto.setCliente_id( rs.getInt("cliente_id") );
                    pedidoDto.setFecha(rs.getString("fecha"));
                    pedidoDto.setTotal(rs.getDouble("total"));
                    pedidoDto.setStatus(rs.getInt("status"));
                    
                    
                    // Ahora obtenemos todos los detalles de este Pedido
                    String sqlDetalles = "SELECT * FROM pedidos_detalles WHERE id_pedido=?";
                    PreparedStatement ssqlDetalles = this.ObjConnection.prepareStatement(sqlDetalles);
                    ssqlDetalles.setInt(1, rs.getInt("id_pedido"));
                    
                    ResultSet rsDetalles = ssqlDetalles.executeQuery();
                    ArrayList<PedidoDetalleDTO> pedDetalles = new ArrayList<>();
                    
                    if(rsDetalles.next()) {    
                        while(rsDetalles.next()){
                            PedidoDetalleDTO pedDetalle = new PedidoDetalleDTO();
                            
                            pedDetalle.setId_pedido_detalles(rsDetalles.getInt("id_pedido_detalles"));
                            pedDetalle.setId_producto(rsDetalles.getInt("id_producto"));
                            pedDetalle.setCantidad(rsDetalles.getInt("cantidad"));
                            pedDetalle.setPrecio(rsDetalles.getDouble("precio"));
                            
                            ProductoDTO producto = mProducto.buscarProductoPorId(rsDetalles.getInt("id_producto"));
                            pedDetalle.setProducto( producto );
                            
                            pedDetalles.add(pedDetalle);
                            
                        }                        
                    }
                    pedidoDto.setPedDetalles(pedDetalles);
                    pedidos.add(pedidoDto);
                } while (rs.next() );
            }
            
         } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, e.toString());
           
           return null;
        }
        
        
        return pedidos;
    }
    
    
    
    public PedidoDTO buscarPorId(int pedidoId) {
        
        
        
        ModeloProducto mProducto = new ModeloProducto();
        
        
        String sql = "SELECT * FROM pedidos WHERE id_pedido=?"; 
        ResultSet rs = null;
        
        
        try {
            PreparedStatement sSQL = this.ObjConnection.prepareStatement(sql);
            sSQL.setInt(1, pedidoId);
        
            rs = sSQL.executeQuery();
            
            if(rs.next()){
               
                    PedidoDTO pedidoDto = new PedidoDTO();
                    
                    pedidoDto.setId_pedido( rs.getInt("id_pedido") );
                    pedidoDto.setProveedor_id(rs.getInt("proveedor_id"));
                    pedidoDto.setCliente_id( rs.getInt("cliente_id") );
                    pedidoDto.setFecha(rs.getString("fecha"));
                    pedidoDto.setTotal(rs.getDouble("total"));
                    pedidoDto.setStatus(rs.getInt("status"));
                    
                    
                    // Ahora obtenemos todos los detalles de este Pedido
                    String sqlDetalles = "SELECT * FROM pedidos_detalles WHERE id_pedido=?";
                    PreparedStatement ssqlDetalles = this.ObjConnection.prepareStatement(sqlDetalles);
                    ssqlDetalles.setInt(1, rs.getInt("id_pedido"));
                    
                    ResultSet rsDetalles = ssqlDetalles.executeQuery();
                    ArrayList<PedidoDetalleDTO> pedDetalles = new ArrayList<>();
                    
                    if(rsDetalles.next()) {    
                        do{
                            PedidoDetalleDTO pedDetalle = new PedidoDetalleDTO();
                            
                            pedDetalle.setId_pedido_detalles(rsDetalles.getInt("id_pedido_detalles"));
                            pedDetalle.setId_producto(rsDetalles.getInt("id_producto"));
                            pedDetalle.setCantidad(rsDetalles.getInt("cantidad"));
                            pedDetalle.setPrecio(rsDetalles.getDouble("precio"));
                            // Jalamos toodos los detalles de cada producto
                            ProductoDTO producto = mProducto.buscarProductoPorId(rsDetalles.getInt("id_producto"));
                            pedDetalle.setProducto( producto );
                            
                            pedDetalles.add(pedDetalle);
                            
                        }while(rsDetalles.next());                        
                    }
                    pedidoDto.setPedDetalles(pedDetalles);
                    return pedidoDto;
            }
             
         } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, e.toString());
           
           return null;
        }
        
       return null;
    }
    
    
    
    public void modificarDetalle(PedidoDetalleDTO pedDetalle) {
        
        String sqlDetalle = "UPDATE pedidos_detalles SET id_producto=?, cantidad=?, precio=? WHERE id_pedido_detalles=? "; 
        
        try {
            PreparedStatement sSQL = this.ObjConnection.prepareStatement(sqlDetalle);
            sSQL.setInt(1, pedDetalle.getId_producto() );
            sSQL.setInt(2, pedDetalle.getCantidad() );
            sSQL.setDouble(3, pedDetalle.getPrecio());
            sSQL.setInt(4, pedDetalle.getId_pedido_detalles());
            
            sSQL.executeUpdate();
            
         } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, e.toString());
         }
    }
    
    public void eliminarDetalle(PedidoDetalleDTO pedDetalle) {
        
        String sqlDetalle = "DELETE from pedidos_detalles WHERE id_pedido_detalles=?";
        try {
            PreparedStatement sSQL = this.ObjConnection.prepareStatement(sqlDetalle);
            sSQL.setInt(1, pedDetalle.getId_pedido_detalles());
            sSQL.executeUpdate();
            
         } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, e.toString());
         }
        
    }
    
    
    
}
