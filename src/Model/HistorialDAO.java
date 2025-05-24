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
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, idPerfil);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            lista.add(new Historial(
            rs.getInt("id_historial"),
            rs.getString("descripcion"),
            rs.getString("fecha")
            ));
        }
        return lista;
    }
}
