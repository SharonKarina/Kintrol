/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author karin
 */
public class MembresiaDAO {
    private Connection conn;
    
    public MembresiaDAO(Connection conn){
        this.conn = conn;
    }
    
    public ArrayList<Membresia> listar() throws SQLException {
        ArrayList<Membresia> lista = new ArrayList<>();
        String sql = "SELECT * FROM membresia";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            lista.add(mapearMembresia(rs));
        }
        return lista;
    }
    
    public Membresia obtenerPorId(int id) throws SQLException {
        String sql = "SELECT * FROM membresia WHERE idMembresia = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return mapearMembresia(rs);
        }
        return null;
    }
    
    public boolean insertar(Membresia m) throws SQLException {
        String sql = "INSERT INTO membresia (idMembresia, limite, fechainicio, duracion, idAdministrador, idUbicacion) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, m.getIdMembresia());
        ps.setInt(2, m.getLimite());
        ps.setString(3, m.getFechaInicio());
        ps.setInt(4, m.getDuracion());
        ps.setInt(5, m.getIdAdministrador());
        ps.setInt(6, m.getIdUbicacion());
        return ps.executeUpdate() > 0;
    }
    
    public boolean actualizar(Membresia m) throws SQLException {
        String sql = "UPDATE membresia SET limite=?, fechainicio=?, duracion=?, idAdministrador=?, idUbicacion=? WHERE idMembresia=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, m.getLimite());
        ps.setString(2, m.getFechaInicio());
        ps.setInt(3, m.getDuracion());
        ps.setInt(4, m.getIdAdministrador());
        ps.setInt(5, m.getIdUbicacion());
        ps.setInt(6, m.getIdMembresia());
        return ps.executeUpdate() > 0;
    }
    
    public boolean eliminar(int idMembresia) throws SQLException {
        String sql = "DELETE FROM membresia WHERE idMembresia=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, idMembresia);
        return ps.executeUpdate() > 0;
    }
    
    private Membresia mapearMembresia(ResultSet rs) throws SQLException {
        return new Membresia(
            rs.getInt("idMembresia"),
            rs.getInt("limite"),
            rs.getString("fechainicio"),
            rs.getInt("duracion"),
            rs.getInt("idAdministrador"),
            rs.getInt("idUbicacion")
        );
    }
}
