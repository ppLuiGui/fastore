/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dtos;

/**
 *
 * @author ppluigui
 */
public class PedidoDetalleDTO {
    
    private int id_pedido_detalles;
    private int id_pedido;
    private int id_producto;
    private int cantidad;
    private double precio;
    private ProductoDTO producto;

    public ProductoDTO getProducto() {
        return producto;
    }

    public void setProducto(ProductoDTO producto) {
        this.producto = producto;
    }

   

    public int getId_pedido_detalles() {
        return id_pedido_detalles;
    }

    public void setId_pedido_detalles(int id_pedido_detalles) {
        this.id_pedido_detalles = id_pedido_detalles;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
            
    
    
    
}
