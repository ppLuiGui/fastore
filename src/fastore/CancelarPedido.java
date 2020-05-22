/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastore;

import Dtos.PedidoDTO;
import Dtos.PedidoDetalleDTO;
import Dtos.ProductoDTO;
import Dtos.ProveedorDTO;
import Modelos.ComboItem;
import Modelos.ModeloPedido;
import Modelos.ModeloProveedor;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ppluigui
 */
public class CancelarPedido extends javax.swing.JInternalFrame {
    private int pedidoId;
    private PedidoDTO pedidoDTO;
    
    /**
     * Creates new form CancelarPedido
     */
    public CancelarPedido() {
        initComponents();
    }
    
    public void setPedido(int pedidoId) {
        this.pedidoId = pedidoId;
        lblNumPedido.setText(String.valueOf(pedidoId));
        
        llenarProductos();
    }
    
    private void llenarProductos(){
        
        ModeloPedido mPedido = new ModeloPedido();
        this.pedidoDTO = mPedido.buscarPorId(this.pedidoId);
        
        
       
        ddItems.addItem( new ComboItem( "Seleccione uno...", 0));
        
        for (PedidoDetalleDTO pedDetalle : this.pedidoDTO.getPedDetalles()) {    
            
            String ProdNombre = pedDetalle.getProducto().getNombre();
            int ProdId = pedDetalle.getId_pedido_detalles();
            
            
            ddItems.addItem(  new ComboItem(ProdNombre, ProdId));
        }      
        
        
    }
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblNumPedido = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        ddItems = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(252, 248, 232));
        setClosable(true);
        setTitle("Cancelar Pedido");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/hubo-error.png"))); // NOI18N

        lblNumPedido.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        lblNumPedido.setForeground(new java.awt.Color(223, 122, 99));
        lblNumPedido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNumPedido.setText("numPedido");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/id-producto.png"))); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cantidad-red.png"))); // NOI18N

        jButton1.setBackground(new java.awt.Color(223, 120, 97));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancelar-white.png"))); // NOI18N
        jButton1.setText("Eliminar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(223, 120, 97));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/modificar-white.png"))); // NOI18N
        jButton2.setText("Modificar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        ddItems.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ddItemsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 30, Short.MAX_VALUE))
                            .addComponent(ddItems, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(lblNumPedido)))
                .addGap(37, 37, 37))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblNumPedido)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ddItems))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ddItemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ddItemsActionPerformed
          // Al seleccionarlo cargamos la cantidad
        int productoId = ddItems.getItemAt( ddItems.getSelectedIndex()).getValue();
          
        for (PedidoDetalleDTO pedDetalle : this.pedidoDTO.getPedDetalles()) {        
            if(pedDetalle.getId_pedido_detalles() == productoId) {
                txtCantidad.setText( String.valueOf(pedDetalle.getCantidad() ));
            }
        }      
    }//GEN-LAST:event_ddItemsActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ModeloPedido mPedido = new ModeloPedido();
        int productoId = ddItems.getItemAt( ddItems.getSelectedIndex()).getValue();
          
        for (PedidoDetalleDTO pedDetalle : this.pedidoDTO.getPedDetalles()) {        
            if(pedDetalle.getId_pedido_detalles() == productoId) {
               int cantidad = Integer.valueOf(txtCantidad.getText());
                pedDetalle.setCantidad(cantidad);
                mPedido.modificarDetalle(pedDetalle);
                JOptionPane.showMessageDialog(null, "Producto Actualizado");
                break; // Con este salimos del ciclo
            }
        }      
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        int opcion = JOptionPane.showConfirmDialog(null, "Esta seguro de que quiere eliminar este producto?");
        // 0=yes, 1=no, 2=cancel
        if(opcion == 0){
            int productoId = ddItems.getItemAt( ddItems.getSelectedIndex()).getValue();
            
             PedidoDetalleDTO pedidoDetalleDTO = new PedidoDetalleDTO();
             pedidoDetalleDTO.setId_pedido_detalles(productoId);
            
              ModeloPedido mPedido = new ModeloPedido();
              mPedido.eliminarDetalle(pedidoDetalleDTO);
              
              JOptionPane.showMessageDialog(null, "Producto Eliminado");
              dispose();
            
        }else{
            JOptionPane.showMessageDialog(null, "Producto No Modificado");
        }        
        
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<ComboItem> ddItems;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblNumPedido;
    private javax.swing.JTextField txtCantidad;
    // End of variables declaration//GEN-END:variables
}