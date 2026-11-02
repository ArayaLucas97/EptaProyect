package Deposito.DAO;

import Deposito.Util.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {

    public Producto buscarPorCodigo(String codigo) {

        String sql
                = "SELECT * FROM inventario WHERE UPPER(codigo)=UPPER(?)";

        try (Connection con = ConexionDB.getConnection(); PreparedStatement st = con.prepareStatement(sql)) {

            st.setString(1, codigo);

            ResultSet rs = st.executeQuery();

            if (rs.next()) {

                return new Producto(
                        rs.getString("codigo"),
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        rs.getInt("cantidad"),
                        rs.getInt("id")
                );
            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return null;
    }

    public List<Producto> listarItems() {
        List<Producto> lista = new ArrayList<>();

        String sql = "SELECT * FROM inventario";

        try (Connection con = ConexionDB.getConnection(); PreparedStatement st = con.prepareStatement(sql); ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                Producto p = new Producto(
                        rs.getString("codigo"),
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        rs.getInt("cantidad"),
                        rs.getInt("id")
                );
                lista.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void guardar(Producto t) throws SQLException {
        String sql = "INSERT INTO inventario (codigo, nombre, descripcion, cantidad) VALUES (?,?,?,?)";

        try (Connection con = ConexionDB.getConnection(); PreparedStatement st = con.prepareStatement(sql)) {

            st.setString(1, t.getCodigo()); // codigo es INTEGER
            st.setString(2, t.getNombre());
            st.setString(3, t.getDescripcion()); // tu atributo se llama Descripcion
            st.setInt(4, t.getCantidad());

            st.executeUpdate();
        }
    }

    public List<Producto> buscar(String filtro) {
        List<Producto> lista = new ArrayList<>();

        String sql = "SELECT * FROM inventario WHERE codigo LIKE ? OR nombre LIKE ? ";

        try (Connection con = ConexionDB.getConnection(); PreparedStatement st = con.prepareStatement(sql)) {

            st.setString(1, "%" + filtro + "%");
            st.setString(2, "%" + filtro + "%");

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Producto p = new Producto(
                        rs.getString("codigo"),
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        rs.getInt("cantidad"),
                        rs.getInt("id")
                );
                lista.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public int guardarPaquete(String codigo, String nombre) throws SQLException {
        String sql = "INSERT INTO paquetes (codigo, nombre) VALUES (?, ?)";

        try (Connection con = ConexionDB.getConnection(); PreparedStatement st = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            st.setString(1, codigo);
            st.setString(2, nombre);
            st.executeUpdate();

            ResultSet rs = st.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1); // ID del paquete
            }
        }
        return -1;
    }

    public void guardarMaterialPaquete(int idPaquete, String codigoProducto, String nombreProducto, int cantidadUsada) throws SQLException {
        String sql = "INSERT INTO paquetes_detalle (id_paquete, codigo_producto, nombre_producto,cantidad_usada) VALUES (?,?,?,?)";
        try (Connection con = ConexionDB.getConnection(); PreparedStatement st = con.prepareStatement(sql)) {

            st.setInt(1, idPaquete);
            st.setString(2, codigoProducto);
            st.setString(3, nombreProducto);
            st.setInt(4, cantidadUsada);
            st.executeUpdate();
        }
    }

    public void actualizarProducto(Producto p) throws SQLException {
        String sql = "UPDATE inventario SET nombre = ?, descripcion = ?, cantidad = ? WHERE id = ?";

        try (Connection con = ConexionDB.getConnection(); PreparedStatement st = con.prepareStatement(sql)) {

            st.setString(1, p.getNombre());
            st.setString(2, p.getDescripcion());
            st.setInt(3, p.getCantidad());
            st.setInt(4, p.getId());

            st.executeUpdate();
        }
    }

    public void eliminarProducto(int id) throws SQLException {
        String sql = "DELETE FROM inventario WHERE id=?";
        try (Connection con = ConexionDB.getConnection(); PreparedStatement st = con.prepareStatement(sql)) {

            st.setInt(1, id);
            st.executeUpdate();
        }
    }

    public Producto buscarPorId(int id) {

        String sql = "SELECT * FROM inventario WHERE id = ?";

        try (Connection con = ConexionDB.getConnection(); PreparedStatement st = con.prepareStatement(sql)) {

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();

            if (rs.next()) {

                return new Producto(
                        rs.getString("codigo"),
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        rs.getInt("cantidad"),
                        rs.getInt("id")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

}
