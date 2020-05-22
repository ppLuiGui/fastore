/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dtos;

import java.util.ArrayList;

/**
 *
 * @author ppluigui
 */
public class PedidoDTO {
    
    
    private int id_pedido;
    private int proveedor_id;
    private int cliente_id;
    private String fecha;
    private Double total;
    private int status;
    
    private ProveedorDTO proveedor;
    private ArrayList<PedidoDetalleDTO> pedDetalles;

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public int getProveedor_id() {
        return proveedor_id;
    }

    public void setProveedor_id(int proveedor_id) {
        this.proveedor_id = proveedor_id;
    }

    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public ProveedorDTO getProveedor() {
        return proveedor;
    }

    public void setProveedor(ProveedorDTO proveedor) {
        this.proveedor = proveedor;
    }

    public ArrayList<PedidoDetalleDTO> getPedDetalles() {
        return pedDetalles;
    }

    public void setPedDetalles(ArrayList<PedidoDetalleDTO> pedDetalles) {
        this.pedDetalles = pedDetalles;
    }
            
    
    
    
}
