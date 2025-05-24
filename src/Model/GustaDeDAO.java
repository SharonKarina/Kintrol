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
public class GustaDeDAO {
    private Connection conn;

    public GustaDeDAO(Connection conn) {
        this.conn = conn;
    }

    public GustaDeDAO() {
        this.conn = Conexion.getCnx().getCnn();
    }
    
    public List<GustaDe> obtenerGustosPorPerfil(int idPerfil) {
        List<GustaDe> lista = new ArrayList<>();
        String sql = "SELECT em.nombreE, gd.frecuencia_escucha, gd.nivel_gusto " +
                 "FROM gusta_de gd " +
                 "JOIN estilos_musicales em ON gd.id_estilo = em.id_estilo " +
                 "WHERE gd.id_perfil = ?";

        try (Connection conn = Conexion.getCnx().getCnn();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idPerfil);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String estilo = rs.getString("nombreE");
                int frecuencia = rs.getInt("frecuencia_escucha");
                int nivel = rs.getInt("nivel_gusto");

                lista.add(new GustaDe(estilo, frecuencia, nivel));
            }

        } catch (SQLException e) {
        e.printStackTrace();
        }

        return lista;
    }
}
