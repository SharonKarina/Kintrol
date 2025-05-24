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
public class AdministradorDAO {
    private Connection conn;

    public AdministradorDAO(Connection conn) {
        this.conn = conn;
    }

    public AdministradorDAO() {
        this.conn = Conexion.getCnx().getCnn();
    }

    public Administrador obtenerPorId(int id) throws SQLException {
        String sql = "SELECT * FROM administrador WHERE id_administrador = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return new Administrador(
                id,
                rs.getString("nombreA"),
                rs.getString("apellidoA"),
                rs.getString("correoA"),
                rs.getString("fecha_nacimiento"),
                rs.getInt("edad")
            );
        }
        return null;
    }
}
