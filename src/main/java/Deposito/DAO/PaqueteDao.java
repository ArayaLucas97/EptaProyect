package Deposito.DAO;

import Deposito.Util.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaqueteDao {

    public List<Paquete> listarpaquetes() {
        List<Paquete> lista = new ArrayList<>();

        String sql = "SELECT * FROM paquetes";
        try (Connection con = ConexionDB.getConnection(); PreparedStatement st = con.prepareStatement(sql); ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                Paquete p = new Paquete(
                        rs.getInt("id_paquete"),
                        rs.getString("nombre"),
                        rs.getString("codigo")
                );
                lista.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public List<String> obtenerItemsDePaquete(int idPaquete) {
        List<String> items = new ArrayList<>();
        String sql = "SELECT codigo_producto, nombre_producto ,cantidad_usada FROM paquetes_detalle WHERE id_paquete = ?";

        try (Connection con = ConexionDB.getConnection(); PreparedStatement st = con.prepareStatement(sql)) {

            st.setInt(1, idPaquete);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                String codigo = rs.getString("codigo_producto");
                String nombre = rs.getString("nombre_producto");
                int cant = rs.getInt("cantidad_usada");
                items.add(codigo + ": " + nombre + " x" + cant);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }


    public void actualizarPaquete(int idPaquete, String codigo, String nombre) throws SQLException {
        String sql = "UPDATE paquetes SET codigo=?, nombre=? WHERE id_paquete=?";
        try (Connection con = ConexionDB.getConnection(); PreparedStatement st = con.prepareStatement(sql)) {

            st.setString(1, codigo);
            st.setString(2, nombre);
            st.setInt(3, idPaquete);
            st.executeUpdate();
        }
    }

    public void borrarItemsPaquete(int idPaquete) throws SQLException {
        String sql = "DELETE FROM paquetes_detalle WHERE id_paquete=?";
        try (Connection con = ConexionDB.getConnection(); PreparedStatement st = con.prepareStatement(sql)) {

            st.setInt(1, idPaquete);
            st.executeUpdate();
        }
    }

    public void guardarMaterialPaquete(int idPaquete, String codigoProducto, String nombreProducto, int cantidadUsada) throws SQLException {
        String sql = "INSERT INTO paquetes_detalle (id_paquete, codigo_producto, nombre_producto, cantidad_usada) VALUES (?,?,?,?)";

        try (Connection con = ConexionDB.getConnection(); PreparedStatement st = con.prepareStatement(sql)) {

            st.setInt(1, idPaquete);
            st.setString(2, codigoProducto);
            st.setString(3, nombreProducto);
            st.setInt(4, cantidadUsada);

            st.executeUpdate();
        }
    }

    public void eliminarPaquete(int idPaquete) throws SQLException {
        String sql = "DELETE FROM paquetes WHERE id_paquete=?";
        try (Connection con = ConexionDB.getConnection(); PreparedStatement st = con.prepareStatement(sql)) {

            st.setInt(1, idPaquete);
            st.executeUpdate();
        }
    }

    public Paquete buscarPorCodigo(String codigo) {

        String sql = "SELECT * FROM paquetes WHERE UPPER(codigo)=UPPER(?)";

        try (Connection con = ConexionDB.getConnection(); PreparedStatement st = con.prepareStatement(sql)) {

            st.setString(1, codigo);

            ResultSet rs = st.executeQuery();

            if (rs.next()) {

                return new Paquete(
                        rs.getInt("id_paquete"),
                        rs.getString("nombre"),
                        rs.getString("codigo")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Paquete> buscar(String filtro) {

        List<Paquete> lista = new ArrayList<>();

        String sql
                = "SELECT * FROM paquetes "
                + "WHERE UPPER(codigo) LIKE UPPER(?) "
                + "OR UPPER(nombre) LIKE UPPER(?)";

        try (Connection con = ConexionDB.getConnection(); PreparedStatement st = con.prepareStatement(sql)) {

            st.setString(1, "%" + filtro + "%");
            st.setString(2, "%" + filtro + "%");

            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                Paquete p = new Paquete(
                        rs.getInt("id_paquete"),
                        rs.getString("nombre"),
                        rs.getString("codigo")
                );

                lista.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

}
