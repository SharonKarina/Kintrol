/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Conexiones.Conexion;
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

    public MembresiaDAO() {
        this.conn = Conexion.getCnx().getCnn();
    }
    
    public ArrayList<Membresia> listar() throws SQLException {
        ArrayList<Membresia> lista = new ArrayList<>();
        String sql = "SELECT * FROM membresias";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            lista.add(mapearMembresia(rs));
        }
        return lista;
    }
    
    public Membresia obtenerPorId(int id) throws SQLException {
        String sql = "SELECT * FROM membresias WHERE id_membresia = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return mapearMembresia(rs);
        }
        return null;
    }
    
    public boolean insertar(Membresia m) throws SQLException {
        String sql = "INSERT INTO membresias (id_membresia, limite, fecha_inicio, duracion, id_administrador, id_ubicacion) VALUES (?, ?, ?, ?, ?, ?)";
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
        String sql = "UPDATE membresias SET limite=?, fecha_inicio=?, duracion=?, id_administrador=?, id_ubicacion=? WHERE id_membresia=?";
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
        String sql = "DELETE FROM membresias WHERE id_membresia=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, idMembresia);
        return ps.executeUpdate() > 0;
    }
    
    private Membresia mapearMembresia(ResultSet rs) throws SQLException {
        return new Membresia(
            rs.getInt("id_membresia"),
            rs.getInt("limite"),
            rs.getString("fecha_inicio"),
            rs.getInt("duracion"),
            rs.getInt("id_administrador"),
            rs.getInt("id_ubicacion")
        );
    }
}
