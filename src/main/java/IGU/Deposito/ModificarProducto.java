package IGU.Deposito;

import Deposito.DAO.Paquete;
import Deposito.DAO.PaqueteDao;
import Deposito.DAO.Producto;
import Deposito.DAO.ProductoDAO;
import java.util.List;
import javax.swing.*;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
//Lucas Araya & Juan Lencina
public class ModificarProducto extends javax.swing.JPanel {

    private boolean modoPaquete = false;

    public ModificarProducto() {

        initComponents();
    }

    // ============================
    // CARGAR ITEMS
    // ============================
    public void CargarTablaItems() {
        String[] columnasItems = {"Código", "Nombre", "Descripción", "Cantidad", "ID"};

        ProductoDAO dao = new ProductoDAO();
        List<Producto> lista = dao.listarItems();
        DefaultTableModel modelo = new DefaultTableModel(columnasItems, 0);

        JTableInventario.setModel(modelo);
        JTableInventario
                .setDefaultEditor(Object.class,
                        null);

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

    // ============================
    // CARGAR PAQUETES
    // ============================
    public void CargarTablaPaquete() {
        String[] columnasPaquete = {"Código", "Nombre", "ID", "Items"};

        PaqueteDao paq = new PaqueteDao();
        List<Paquete> lista = paq.listarpaquetes();
        DefaultTableModel modelo = new DefaultTableModel(columnasPaquete, 0);

        JTableInventario.setModel(modelo);

        for (Paquete p : lista) {
            List<String> items = paq.obtenerItemsDePaquete(p.getId_paquete());
            String itemsTexto = String.join(", ", items);

            modelo.addRow(new Object[]{
                p.getCodigo(),
                p.getNombre(),
                p.getId_paquete(),
                itemsTexto
            });
        }
    }

    //Filtro Buscar
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

    private void abrirVentanaEdicionPaquete(String codigo) {

        PaqueteDao dao = new PaqueteDao();

        Paquete p = dao.buscarPorCodigo(codigo);

        if (p == null) {

            JOptionPane.showMessageDialog(
                    this,
                    "No existe un paquete con ese código."
            );

            return;
        }

        mostrarEditorPaquete(
                p.getId_paquete(),
                p.getCodigo(),
                p.getNombre()
        );
    }

    public void CargarTablaPaqueteFiltrada(String filtro) {

        PaqueteDao dao = new PaqueteDao();

        List<Paquete> lista = dao.buscar(filtro);

        DefaultTableModel modelo
                = (DefaultTableModel) JTableInventario.getModel();

        modelo.setRowCount(0);

        for (Paquete p : lista) {

            List<String> items
                    = dao.obtenerItemsDePaquete(p.getId_paquete());

            String itemsTexto
                    = String.join(", ", items);

            modelo.addRow(new Object[]{
                p.getCodigo(),
                p.getNombre(),
                p.getId_paquete(),
                itemsTexto
            });
        }
    }
// ============================
// EDITAR PRODUCTO
// ============================

    private void abrirVentanaEdicionPorCodigo(String codigo) {

        ProductoDAO dao = new ProductoDAO();

        Producto p = dao.buscarPorCodigo(codigo);

        if (p == null) {

            JOptionPane.showMessageDialog(this,
                    "No existe un producto con ese código.");

            return;
        }

        mostrarEditorProducto(
                p.getCodigo(),
                p.getNombre(),
                p.getDescripcion(),
                p.getCantidad(),
                p.getId()
        );
    }

    private void mostrarEditorPaquete(
            int idPaquete,
            String codigo,
            String nombre) {

        JDialog dialog = new JDialog();

        dialog.setTitle("Editar Paquete");
        dialog.setSize(400, 220);
        dialog.setLocationRelativeTo(this);
        dialog.setModal(true);
        dialog.setLayout(null);

        JLabel lblCodigo = new JLabel("Código:");
        lblCodigo.setBounds(20, 20, 100, 25);
        dialog.add(lblCodigo);

        JTextField txtCodigo = new JTextField(codigo);
        txtCodigo.setBounds(120, 20, 200, 25);
        dialog.add(txtCodigo);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(20, 60, 100, 25);
        dialog.add(lblNombre);

        JTextField txtNombre = new JTextField(nombre);
        txtNombre.setBounds(120, 60, 200, 25);
        dialog.add(txtNombre);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(120, 120, 120, 30);
        dialog.add(btnGuardar);

        btnGuardar.addActionListener(e -> {

            try {

                PaqueteDao dao = new PaqueteDao();

                dao.actualizarPaquete(
                        idPaquete,
                        txtCodigo.getText().trim().toUpperCase(),
                        txtNombre.getText().trim()
                );

                JOptionPane.showMessageDialog(
                        dialog,
                        "Paquete actualizado correctamente."
                );

                dialog.dispose();

                CargarTablaPaquete();

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(
                        dialog,
                        "Error: " + ex.getMessage()
                );
            }
        });

        dialog.setVisible(true);
    }

    private void mostrarEditorProducto(String codigo, String nombre, String descripcion, int cantidad, int id) {
        JDialog dialog = new JDialog();
        dialog.setTitle("Editar Producto ID: " + id);
        dialog.setSize(400, 300);
        dialog.setLocationRelativeTo(this);
        dialog.setModal(true);
        dialog.setLayout(null);

        JLabel lblCodigo = new JLabel("Código:");
        lblCodigo.setBounds(20, 20, 100, 25);
        dialog.add(lblCodigo);

        JTextField txtCodigo = new JTextField(codigo);
        txtCodigo.setBounds(140, 20, 200, 25);
        txtCodigo.setEditable(false);
        dialog.add(txtCodigo);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(20, 60, 100, 25);
        dialog.add(lblNombre);

        JTextField txtNombre = new JTextField(nombre);
        txtNombre.setBounds(140, 60, 200, 25);
        dialog.add(txtNombre);

        JLabel lblDesc = new JLabel("Descripción:");
        lblDesc.setBounds(20, 100, 100, 25);
        dialog.add(lblDesc);

        JTextField txtDesc = new JTextField(descripcion);
        txtDesc.setBounds(140, 100, 200, 25);
        dialog.add(txtDesc);

        JLabel lblCant = new JLabel("Cantidad:");
        lblCant.setBounds(20, 140, 100, 25);
        dialog.add(lblCant);

        JTextField txtCant = new JTextField(String.valueOf(cantidad));
        txtCant.setBounds(140, 140, 200, 25);
        dialog.add(txtCant);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(140, 200, 120, 30);
        dialog.add(btnGuardar);

        btnGuardar.addActionListener(e -> {
            try {
                ProductoDAO dao = new ProductoDAO();
                Producto p = new Producto(
                        codigo,
                        txtNombre.getText(),
                        txtDesc.getText(),
                        Integer.parseInt(txtCant.getText()),
                        id
                );
                dao.actualizarProducto(p);
                JOptionPane.showMessageDialog(dialog, "Producto actualizado correctamente.");

                dialog.dispose(); // Cierra la ventana emergente
                CargarTablaItems(); // <--- REFRESCAR LA TABLA PRINCIPAL

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(dialog, "La cantidad debe ser un número entero válido.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(dialog, "Error al guardar: " + ex.getMessage());
            }
        });

        dialog.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTableInventario = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnItem = new javax.swing.JButton();
        btnTablaPaquete = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        txtEliminar = new javax.swing.JTextField();

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        JTableInventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Comentario", "Cantidad"
            }
        ));
        JTableInventario.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(JTableInventario);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cod/Nombre:");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnItem.setText("Item");
        btnItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnItemActionPerformed(evt);
            }
        });

        btnTablaPaquete.setText("Paquete");
        btnTablaPaquete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTablaPaqueteActionPerformed(evt);
            }
        });

        btnEliminar.setText("E");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnEditar.setText("Eliminar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        txtEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                        .addComponent(btnItem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnTablaPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(btnCancelar)
                    .addComponent(btnItem)
                    .addComponent(btnTablaPaquete)
                    .addComponent(btnEliminar)
                    .addComponent(btnEditar)
                    .addComponent(txtEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
                .addContainerGap())
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

    private void btnTablaPaqueteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTablaPaqueteActionPerformed
        modoPaquete = true;
        CargarTablaPaquete();
    }//GEN-LAST:event_btnTablaPaqueteActionPerformed

    private void btnItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnItemActionPerformed
        modoPaquete = false;

        CargarTablaItems();
    }//GEN-LAST:event_btnItemActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        txtBuscar.setText("");

        if (modoPaquete) {

            CargarTablaPaquete();

        } else {

            CargarTablaItems();

        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String filtro = txtBuscar.getText();

        if (modoPaquete) {

            CargarTablaPaqueteFiltrada(filtro);

        } else {

            CargarTablaFiltrada(filtro);

        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEliminarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        String codigo = txtEliminar.getText()
                .trim()
                .toUpperCase();

        if (modoPaquete) {

            abrirVentanaEdicionPaquete(codigo);

        } else {

            abrirVentanaEdicionPorCodigo(codigo);

        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        try {

            if (modoPaquete) {

                String codigo = txtEliminar.getText()
                        .trim()
                        .toUpperCase();

                PaqueteDao dao = new PaqueteDao();

                Paquete p = dao.buscarPorCodigo(codigo);

                if (p == null) {

                    JOptionPane.showMessageDialog(
                            this,
                            "No existe un paquete con ese código.");

                    return;
                }

                dao.borrarItemsPaquete(
                        p.getId_paquete());

                dao.eliminarPaquete(
                        p.getId_paquete());

                CargarTablaPaquete();

                JOptionPane.showMessageDialog(
                        this,
                        "Paquete eliminado.");

            } else {

                int id
                        = Integer.parseInt(
                                txtEliminar.getText());

                ProductoDAO dao
                        = new ProductoDAO();

                dao.eliminarProducto(id);

                CargarTablaItems();

                JOptionPane.showMessageDialog(
                        this,
                        "Producto eliminado.");
            }

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Error: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable JTableInventario;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnItem;
    private javax.swing.JButton btnTablaPaquete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtEliminar;
    // End of variables declaration//GEN-END:variables
}
