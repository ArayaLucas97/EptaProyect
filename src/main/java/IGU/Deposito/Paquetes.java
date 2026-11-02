package IGU.Deposito;

import Deposito.DAO.Producto;
import Deposito.DAO.ProductoDAO;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Paquetes extends javax.swing.JPanel {

    public Paquetes() {
        initComponents();
        cargarInventario();

        //tabla de informacion inventario
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
        //Jtabla de informacion paquete
        JTablePaquete.getColumnModel().getColumn(0).setPreferredWidth(35);
        JTablePaquete.getColumnModel().getColumn(0).setResizable(false);
        JTablePaquete.getColumnModel().getColumn(1).setPreferredWidth(200);
        JTablePaquete.getColumnModel().getColumn(1).setResizable(false);
        JTablePaquete.getColumnModel().getColumn(2).setPreferredWidth(200);
        JTablePaquete.getColumnModel().getColumn(2).setResizable(false);
        JTablePaquete.getColumnModel().getColumn(3).setPreferredWidth(25);
        JTablePaquete.getColumnModel().getColumn(3).setResizable(false);
        JTablePaquete.getColumnModel().getColumn(4).setPreferredWidth(10);
        JTablePaquete.getColumnModel().getColumn(4).setResizable(false);

    }

    public void cargarInventario() {
        ProductoDAO dao = new ProductoDAO();
        List<Producto> lista = dao.listarItems();

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

    public void CargarTablaFiltrada(String filtro) {
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

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNombrePaquete = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTablePaquete = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        JTableInventario = new javax.swing.JTable();
        btnGuardarPaquete = new javax.swing.JButton();
        btnBorrarItem = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtCodigoProducto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        btnAgregarProducto = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtCodigoNombre = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JToggleButton();
        jLabel5 = new javax.swing.JLabel();
        txtCodigoPaquete = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        jLabel2.setText("Nombre del Paquete:");

        JTablePaquete.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Comentario", "Cantidad", "ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(JTablePaquete);

        JTableInventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Comentario", "Cantidad", "ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(JTableInventario);

        btnGuardarPaquete.setText("Guardar Paquete");
        btnGuardarPaquete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarPaqueteActionPerformed(evt);
            }
        });

        btnBorrarItem.setText("Borrar Item");
        btnBorrarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarItemActionPerformed(evt);
            }
        });

        jLabel1.setText("Codigo:");

        jLabel3.setText("Cantidad:");

        btnAgregarProducto.setText("Agregar Item");
        btnAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar Paquete");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        jLabel4.setText("Buscar Codigo/Nombre:");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel5.setText("Cod del Paquete:");

        jLabel6.setText("CREAR PAQUETE");

        jLabel7.setText("AGREGAR ITEMS AL PAQUETE");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCodigoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnAgregarProducto)
                                .addGap(0, 221, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnBorrarItem, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLimpiar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardarPaquete)
                        .addGap(14, 14, 14))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCodigoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBuscar)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNombrePaquete, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCodigoPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCodigoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNombrePaquete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(txtCodigoPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2))
                .addGap(25, 25, 25)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarProducto)
                    .addComponent(txtCodigoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBorrarItem)
                    .addComponent(btnLimpiar)
                    .addComponent(btnGuardarPaquete))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) JTablePaquete.getModel();
        modelo.setRowCount(0);
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoActionPerformed
        String codigo = txtCodigoProducto.getText().toUpperCase();

        // 1) Validar que el código no esté vacío
        if (codigo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar un código de producto");
            return;
        }

        // 2) Validar que la cantidad no esté vacía
        if (txtCantidad.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar la cantidad a usar");
            return;
        }

        int cantidadUsada;

        try {
            cantidadUsada = Integer.parseInt(txtCantidad.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "La cantidad debe ser un número válido");
            return;
        }

        // 3) Buscar el producto en el inventario
        ProductoDAO dao = new ProductoDAO();
        Producto p = dao.buscarPorCodigo(codigo);

        if (p == null) {
            JOptionPane.showMessageDialog(this, "El código no existe en el inventario");
            return;
        }

        /*
        // 4) Validar stock suficiente
        if (cantidadUsada > p.getCantidad()) {
            JOptionPane.showMessageDialog(this,
                    "Stock insuficiente.\nDisponible: " + p.getCantidad() + "\nSolicitado: " + cantidadUsada);
            return;
        }
         */
        // 5) Validar que NO esté repetido en la tabla del paquete
        DefaultTableModel modelo = (DefaultTableModel) JTablePaquete.getModel();

        for (int i = 0; i < modelo.getRowCount(); i++) {
            String codigoExistente = modelo.getValueAt(i, 0).toString();
            if (codigoExistente.equalsIgnoreCase(codigo)) {
                JOptionPane.showMessageDialog(this,
                        "Este producto ya fue agregado al paquete");
                return;
            }
        }

        // 6) Agregar a la tabla del paquete
        modelo.addRow(new Object[]{
            p.getCodigo(),
            p.getNombre(),
            p.getDescripcion(),
            cantidadUsada,
            p.getId()
        });

        // 7) Limpiar campos
        txtCodigoProducto.setText("");
        txtCantidad.setText("");
    }//GEN-LAST:event_btnAgregarProductoActionPerformed

    private void btnBorrarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarItemActionPerformed
        int fila = JTablePaquete.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un material para eliminar");
            return;
        }

        DefaultTableModel modelo = (DefaultTableModel) JTablePaquete.getModel();
        modelo.removeRow(fila);
    }//GEN-LAST:event_btnBorrarItemActionPerformed

    private void btnGuardarPaqueteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarPaqueteActionPerformed

        String nombrePaquete = txtNombrePaquete.getText().trim(); // tu campo de nombre
        String codigoPaquete = txtCodigoPaquete.getText().trim(); // tu campo de código

        if (nombrePaquete.isEmpty() || codigoPaquete.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar nombre y código del paquete");
            return;
        }

        ProductoDAO dao = new ProductoDAO();

        try {
            // 1) Guardar paquete y obtener ID
            int idPaquete = dao.guardarPaquete(codigoPaquete, nombrePaquete);

            if (idPaquete == -1) {
                JOptionPane.showMessageDialog(this, "Error al guardar el paquete");
                return;
            }

            // 2) Recorrer la tabla jTablePaquete
            DefaultTableModel modelo = (DefaultTableModel) JTablePaquete.getModel();

            for (int i = 0; i < modelo.getRowCount(); i++) {
                String codigoProducto = modelo.getValueAt(i, 0).toString();
                String nombreProducto = modelo.getValueAt(i,1).toString();
                int cantidadUsada = Integer.parseInt(modelo.getValueAt(i, 3).toString());
             

                // 3) Guardar cada material del paquete
                dao.guardarMaterialPaquete(idPaquete, codigoProducto, nombreProducto,cantidadUsada);
            }

            JOptionPane.showMessageDialog(this, "Paquete guardado correctamente");

            // 4) Limpiar tabla y campos
            modelo.setRowCount(0);
            txtCodigoPaquete.setText("");
            txtNombrePaquete.setText("");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }

    }//GEN-LAST:event_btnGuardarPaqueteActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        CargarTablaFiltrada(txtCodigoNombre.getText());
    }//GEN-LAST:event_btnBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable JTableInventario;
    public javax.swing.JTable JTablePaquete;
    private javax.swing.JButton btnAgregarProducto;
    private javax.swing.JButton btnBorrarItem;
    private javax.swing.JToggleButton btnBuscar;
    private javax.swing.JButton btnGuardarPaquete;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCodigoNombre;
    private javax.swing.JTextField txtCodigoPaquete;
    private javax.swing.JTextField txtCodigoProducto;
    private javax.swing.JTextField txtNombrePaquete;
    // End of variables declaration//GEN-END:variables
}
