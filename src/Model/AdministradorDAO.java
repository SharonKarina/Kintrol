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
    
    public int insertarAdministrador(Administrador admin) throws SQLException {
    String sql = "INSERT INTO administrador (nombreA, apellidoA, correoA, fecha_nacimiento, edad) VALUES (?, ?, ?, ?, ?)";
    try (Connection conn = Conexion.getCnx().getCnn(); PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
        stmt.setString(1, admin.getNombre());
        stmt.setString(2, admin.getApellido());
        stmt.setString(3, admin.getCorreo());
        stmt.setString(4, admin.getFechaNacimiento()); 
        stmt.setInt(5, admin.getEdad());
        
        int rows = stmt.executeUpdate();
        if (rows > 0) {
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1); // ID generado
            }
        }
        return -1;
    }
    }
    
    public boolean existeAdministrador(int id) {
    try (Connection con = Conexion.getCnx().getCnn()) {
        String sql = "SELECT COUNT(*) FROM Administrador WHERE id_administrador = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getInt(1) > 0;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
}
}
