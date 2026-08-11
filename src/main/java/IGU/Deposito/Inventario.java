package IGU.Deposito;

import Deposito.DAO.Producto;
import Deposito.DAO.ProductoDAO;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

public class Inventario extends javax.swing.JPanel {

    public Inventario() {
        initComponents();
       JTableInventario.getColumnModel().getColumn(0).setPreferredWidth(35);
       JTableInventario.getColumnModel().getColumn(0).setResizable(false);
       JTableInventario.getColumnModel().getColumn(1).setPreferredWidth(200);
       JTableInventario.getColumnModel().getColumn(1).setResizable(false);
       JTableInventario.getColumnModel().getColumn(2).setPreferredWidth(200);
       JTableInventario.getColumnModel().getColumn(2).setResizable(false);
       JTableInventario.getColumnModel().getColumn(3).setPreferredWidth(25);
       JTableInventario.getColumnModel().getColumn(3).setResizable(false);
       JTableInventario.getColumnModel().getColumn(4).setPreferredWidth(10);
       JTableInventario.getColumnModel().getColumn(4).setResizable(false);
       
    }

    public void cargarTabla() {
        ProductoDAO dao = new ProductoDAO();
        List<Producto> lista = dao.listar();

        DefaultTableModel modelo = (DefaultTableModel) JTableInventario.getModel();
        modelo.setRowCount(0); // limpia la tabla

        for (Producto p : lista) {
            modelo.addRow(new Object[]{
                p.getCodigo(),
                p.getNombre(),
                p.getDescripcion(),
                p.getCantidad(),
                p.getId()
            });
        }
    }

    public void cargarTablaFiltrada(String filtro) {
        ProductoDAO dao = new ProductoDAO();
        List<Producto> lista = dao.buscar(filtro);

        DefaultTableModel modelo = (DefaultTableModel) JTableInventario.getModel();
        modelo.setRowCount(0);

        for (Producto p : lista) {
            modelo.addRow(new Object[]{
                p.getCodigo(),
                p.getNombre(),
                p.getDescripcion(),
                p.getCantidad(),
                p.getId()
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTableInventario = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTextBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnItems = new javax.swing.JButton();
        btnPaquetes = new javax.swing.JButton();
        btnCancelarBusqueda = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        JTableInventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Comentarios", "Cantidad", "ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(JTableInventario);

        jLabel1.setText("Ingresar Dato:");

        jTextBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextBuscarActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnItems.setText("Items");

        btnPaquetes.setText("Paquetes");

        btnCancelarBusqueda.setText("Cancelar");
        btnCancelarBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarBusquedaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 618, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextBuscar)
                        .addGap(30, 30, 30)
                        .addComponent(btnBuscar)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelarBusqueda)
                        .addGap(14, 14, 14))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnItems)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPaquetes)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnItems)
                    .addComponent(btnPaquetes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(btnCancelarBusqueda))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarBusquedaActionPerformed
        jTextBuscar.setText("");
        cargarTablaFiltrada(jTextBuscar.getText());
    }//GEN-LAST:event_btnCancelarBusquedaActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        cargarTablaFiltrada(jTextBuscar.getText());
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void jTextBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextBuscarActionPerformed

    }//GEN-LAST:event_jTextBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable JTableInventario;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelarBusqueda;
    private javax.swing.JButton btnItems;
    private javax.swing.JButton btnPaquetes;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextBuscar;
    // End of variables declaration//GEN-END:variables
}
