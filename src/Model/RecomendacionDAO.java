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
public class RecomendacionDAO {
    private Connection conn;

    public RecomendacionDAO(Connection conn) {
        this.conn = conn;
    }

    public RecomendacionDAO() {
        this.conn = Conexion.getCnx().getCnn();
    }
    
    public List<Recomendacion> obtenerRecomendacionesPorPerfil(int idPerfil) {
        List<Recomendacion> lista = new ArrayList<>();
        String sql = "SELECT r.id_recomendacion, r.fecha, em.nombre_estilo, em.id_estilo " +
                 "FROM estilo_recomendado er " +
                 "JOIN recomendaciones r ON er.id_recomendacion = r.id_recomendacion " +
                 "JOIN estilos_musicales em ON er.id_estilo = em.id_estilo " +
                 "WHERE r.id_perfil = ?";

        try (Connection conn = Conexion.getCnx().getCnn();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idPerfil);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int idRecomendacion = rs.getInt("id_recomendacion");
                Date fecha = rs.getDate("fecha_recomendacion");
                String nombreEstilo = rs.getString("nombreE");
                int idEstilo = rs.getInt("id_estilo");
                

                lista.add(new Recomendacion(idRecomendacion, fecha, nombreEstilo, idEstilo));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
}
