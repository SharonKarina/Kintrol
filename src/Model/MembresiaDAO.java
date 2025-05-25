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
        
        Connection conn = Conexion.getCnx().getCnn();
        Statement stmt = conn.createStatement();
        
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            lista.add(mapearMembresia(rs));
        }
        return lista;
    }
    
    public Membresia obtenerPorId(int id) throws SQLException {
        String sql = "SELECT * FROM membresias WHERE id_membresia = ?";
        
        Connection conn = Conexion.getCnx().getCnn();
        PreparedStatement ps = conn.prepareStatement(sql);
        
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return mapearMembresia(rs);
        }
        return null;
    }
    
    public int insertar(Membresia m) throws SQLException {
        String sql = "INSERT INTO membresias (limite, fecha_inicio, duracion, id_administrador, id_ubicacion) VALUES (?, ?, ?, ?, ?)";
        
        Connection conn = Conexion.getCnx().getCnn();
        PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        
        ps.setInt(1, m.getLimite());
        ps.setString(2, m.getFechaInicio());
        ps.setInt(3, m.getDuracion());
        ps.setInt(4, m.getIdAdministrador());
        ps.setInt(5, m.getIdUbicacion());
        
        int rows = ps.executeUpdate();
        if (rows > 0) {
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1); // retorna el id_membresia generado
            }
        }
        return -1; 
        
    }
    
    public boolean actualizar(Membresia m) throws SQLException {
        String sql = "UPDATE membresias SET limite=?, duracion=?, id_ubicacion=? WHERE id_membresia=?";
        
        Connection conn = Conexion.getCnx().getCnn();
        PreparedStatement ps = conn.prepareStatement(sql);
        
        ps.setInt(1, m.getLimite());
        ps.setInt(2, m.getDuracion());
        ps.setInt(3, m.getIdUbicacion());
        ps.setInt(4, m.getIdMembresia());
        return ps.executeUpdate() > 0;
    }
    
    public boolean eliminar(int idMembresia) throws SQLException {
        String sql = "DELETE FROM membresias WHERE id_membresia=?";
        
        Connection conn = Conexion.getCnx().getCnn();
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
