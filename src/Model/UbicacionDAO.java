/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Conexiones.Conexion;
import java.sql.*;

/**
 *
 * @author karin
 */
public class UbicacionDAO {
    private Connection conn;

    public UbicacionDAO(Connection conn) {
        this.conn = conn;
    }

    public UbicacionDAO() {
        this.conn = Conexion.getCnx().getCnn();
    }

    public Ubicacion obtenerPorId(int id) throws SQLException {
        String sql = "SELECT * FROM ubicacion WHERE id_ubicacion = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return new Ubicacion(
                id,
                rs.getString("pais"),
                rs.getString("ciudad")
            );
        }
        return null;
    }
}
