package IGU.Deposito;

import Deposito.DAO.Paquete;
import Deposito.DAO.PaqueteDao;
import Deposito.DAO.Producto;
import Deposito.DAO.ProductoDAO;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Inventario extends javax.swing.JPanel {

    public Inventario() {
        initComponents();
        //Accion del mouse para ver la totalidad de items en los paquetes
        JTableInventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int fila = JTableInventario.getSelectedRow();
                if (fila != -1) {
                    int idPaquete = Integer.parseInt(JTableInventario.getValueAt(fila, 2).toString());
                    mostrarItemsPaquete(idPaquete);
                }
            }
        });

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

    //Inventario de Items
    public void CargarTablaItems() {
        String[] columnasItems = {"Código", "Nombre", "Descripción", "Cantidad", "ID"};

        ProductoDAO dao = new ProductoDAO();
        List<Producto> lista = dao.listarItems();
        DefaultTableModel modelo = new DefaultTableModel(columnasItems, 0);
        JTableInventario.setModel(modelo);
        JTableInventario.setDefaultEditor(Object.class, null);
        JTableInventario.getColumnModel().getColumn(0).setPreferredWidth(80);  // Código
        JTableInventario.getColumnModel().getColumn(1).setPreferredWidth(150); // Nombre
        JTableInventario.getColumnModel().getColumn(2).setPreferredWidth(250); // Descripción
        JTableInventario.getColumnModel().getColumn(3).setPreferredWidth(60);  // Cantidad
        JTableInventario.getColumnModel().getColumn(4).setPreferredWidth(10);  // ID

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

    //Inventario Paquetes
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

    //Mostrar los Subconjuntos de cada Paquete
    public void mostrarItemsPaquete(int idPaquete) {
        PaqueteDao paq = new PaqueteDao();
        List<String> items = paq.obtenerItemsDePaquete(idPaquete);

        StringBuilder sb = new StringBuilder("Items del paquete:\n\n");
        for (String item : items) {
            sb.append("• ").append(item).append("\n");
        }

        JOptionPane.showMessageDialog(this, sb.toString(), "Detalle del paquete", JOptionPane.INFORMATION_MESSAGE);
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
        btnItem = new javax.swing.JButton();
        btnPaquete = new javax.swing.JButton();
        btnCancelarBusqueda = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        JTableInventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

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

        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnItem.setText("Item");
        btnItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnItemActionPerformed(evt);
            }
        });

        btnPaquete.setText("Paquete");
        btnPaquete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPaqueteActionPerformed(evt);
            }
        });

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
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelarBusqueda)
                        .addGap(8, 8, 8)
                        .addComponent(btnBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                        .addComponent(btnItem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPaquete)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(btnCancelarBusqueda)
                    .addComponent(btnItem)
                    .addComponent(btnPaquete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)
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

    private void btnCancelarBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarBusquedaActionPerformed
        txtBuscar.setText("");
        CargarTablaFiltrada(txtBuscar.getText());
    }//GEN-LAST:event_btnCancelarBusquedaActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        CargarTablaFiltrada(txtBuscar.getText());
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed

    }//GEN-LAST:event_txtBuscarActionPerformed

    private void btnItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnItemActionPerformed
        CargarTablaItems();
    }//GEN-LAST:event_btnItemActionPerformed

    private void btnPaqueteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPaqueteActionPerformed
        CargarTablaPaquete();
    }//GEN-LAST:event_btnPaqueteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable JTableInventario;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelarBusqueda;
    private javax.swing.JButton btnItem;
    private javax.swing.JButton btnPaquete;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables

}
