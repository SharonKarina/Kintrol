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
public class PerfilDAO {
    private Connection conn;
    
    public PerfilDAO(Connection conn){
        this.conn = conn;
    }
    
    public PerfilDAO(){
        this.conn = Conexion.getCnx().getCnn();
    }
    
    public ArrayList<Perfil> listar() throws SQLException {
        ArrayList<Perfil> lista = new ArrayList<>();
        String sql = "SELECT * FROM perfil";
        
        Connection conn = Conexion.getCnx().getCnn();
        Statement stmt = conn.createStatement();
        
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            lista.add(mapearPerfil(rs));
        }
        return lista;
    }
    
    public Perfil obtenerPorId(int id) throws SQLException {
        String sql = "SELECT * FROM perfil WHERE id_perfil = ?";
        
        Connection conn = Conexion.getCnx().getCnn();
        PreparedStatement ps = conn.prepareStatement(sql);
        
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return mapearPerfil(rs);
        }
        return null;
    }
    
    public int insertar(Perfil p) throws SQLException {
        String sql = "INSERT INTO perfil (nickName, id_membresia) VALUES (?, ?)";
        
        Connection conn = Conexion.getCnx().getCnn();
        PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        
        ps.setString(1, p.getNickName());
        ps.setInt(2, p.getId_membresia());
        
        int rows = ps.executeUpdate();
        if (rows >0){
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()){
                return rs.getInt(1);
            }
        }
        return -1;
    }
    
    public boolean actualizar(Perfil p) throws SQLException {
        String sql = "UPDATE perfil SET nickName=? WHERE id_perfil=?";
        
        Connection conn = Conexion.getCnx().getCnn();
        PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, p.getNickName());
            ps.setInt(2, p.getId_perfil());
            
            return ps.executeUpdate() > 0;
        
    }
    
    public boolean eliminar(int idPerfil) throws SQLException {
        String sql = "DELETE FROM perfil WHERE id_perfil=?";

        Connection conn = Conexion.getCnx().getCnn();
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setInt(1, idPerfil);
        return ps.executeUpdate() > 0;
    }
    
    
    private Perfil mapearPerfil(ResultSet rs) throws SQLException {
        return new Perfil(
            rs.getInt("id_perfil"),
            rs.getString("nickName"),
            rs.getInt("id_membresia")
        );
    }
}
