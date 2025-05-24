/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Conexiones.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author karin
 */
public class HistorialDAO {
    private Connection conn;

    public HistorialDAO(Connection conn) {
        this.conn = conn;
    }
    
    public HistorialDAO(){
        this.conn = Conexion.getCnx().getCnn();
    }
    
    public List<Historial> obtenerHistorialPorPerfil(int idPerfil) throws SQLException {
        List<Historial> lista = new ArrayList<>();
        String sql = "SELECT * FROM historial WHERE id_perfil = ?";
        
        try (PreparedStatement ps = this.conn.prepareStatement(sql)){
            
            ps.setInt(1, idPerfil);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                int idHistorial = rs.getInt("id_historial");
                String contenido = rs.getString("descripcion");
                String fecha = rs.getString("fecha");
                
                lista.add(new Historial(idHistorial, contenido, fecha));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        
        return lista;
    }
}
