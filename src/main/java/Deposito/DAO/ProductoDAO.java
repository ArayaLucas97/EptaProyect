package Deposito.DAO;

import Deposito.Util.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {

    public List<Producto> listar() {
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

        String sql = "SELECT * FROM inventario WHERE codigo LIKE ? OR nombre LIKE ?";

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

}
