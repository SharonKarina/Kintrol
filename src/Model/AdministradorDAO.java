/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.*;

/**
 *
 * @author karin
 */
public class AdministradorDAO {
    private Connection conn;
    
    public AdministradorDAO(Connection conn){
        this.conn = conn;
    }

    public AdministradorDAO() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public Administrador obtenerPorId(int id) throws SQLException {
        String sql = "SELECT * FROM administrador WHERE idAdministrador = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return new Administrador(
                id,
                rs.getString("nombre"),
                rs.getString("apellido"),
                rs.getString("correo"),
                rs.getString("nacimiento"),
                rs.getInt("edad")
            );
        }
        return null;
    }
    
}
