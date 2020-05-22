/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastore;

import Dtos.ComentarioDTO;
import Dtos.ProductoDTO;
import Dtos.UsuarioDTO;
import Modelos.ModeloComentario;
import Modelos.ModeloProducto;
import java.util.ArrayList;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ppluigui
 */
public class ListaComentarios extends javax.swing.JInternalFrame {

    /**
     * Creates new form ListaProductos
     */
    public ListaComentarios() {
        initComponents();
        listarComentarios();
    }

    
    private void listarComentarios(){

        int proveedorId = UsuarioDTO.getId();
        
        ModeloComentario mComentario = new ModeloComentario();
        ArrayList<ComentarioDTO> listaComentarios = mComentario.listarPorProveedorId(proveedorId);
        
       
        DefaultTableModel dtm = (DefaultTableModel) tblComentarios.getModel();
        dtm.setRowCount(0);
        
        for( ComentarioDTO comentario : listaComentarios ) {
           
            Object[] fila = new Object[5];
        
            fila[0] = comentario.getId_comentario(); // id
            fila[1] = comentario.getCliente().getNombre(); // cliente
            fila[2] = comentario.getFecha(); // fecha
            fila[3] = comentario.getComentario(); // comentario
            fila[4] = comentario.getLeido(); // leido

            dtm.addRow(fila);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblComentarios = new javax.swing.JTable();

        setClosable(true);
        setTitle("Lista de Comentarios");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/comentarios.png"))); // NOI18N

        tblComentarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "id", "Cliente", "Fecha", "Comentario", "leido"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblComentarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblComentariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblComentarios);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblComentariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblComentariosMouseClicked
        
        int selectedIndex = tblComentarios.getSelectedRow();
        DefaultTableModel dtm = (DefaultTableModel) tblComentarios.getModel();
        
        
        // Con este IF detectamos si hizo doble click en algun comentario
        if (evt.getClickCount() == 2 && selectedIndex != -1) {
            
            // Obtenemmos que Mensaje Quiere Leer
            int comentarioId = Integer.valueOf( dtm.getValueAt(selectedIndex, 0).toString() );
            String comentario = dtm.getValueAt(selectedIndex, 3).toString();
            
            // Se lo mostramos
             JOptionPane.showMessageDialog(null, comentario);
            
            // Lo marcamos como Leido
            ModeloComentario mComentario = new ModeloComentario();
            mComentario.marcarComoLeido(comentarioId);
            
            
        }
        
        
        
    }//GEN-LAST:event_tblComentariosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblComentarios;
    // End of variables declaration//GEN-END:variables
}
