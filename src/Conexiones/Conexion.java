/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author karin
 */
public class Conexion {
    private String DRIVER = "";
    private String URL = "";
    private String USER = "";
    private String PASSWORD = "contraseña";
    
    private Connection cnn = null;
    
    private static Conexion cnx = null;
    
    private Conexion() {
        try {
            Class.forName(DRIVER);
            cnn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException ex){
            System.out.println("Error de driver");
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            System.out.println("Error en la conexión");
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static synchronized Conexion getCnx() {
        if (cnx == null) {
            cnx = new Conexion();
        }
        return cnx;
    }

    public Connection getCnn() {
        return cnn;
    }

    public void cerrarCnn() {
        try {
            if (cnn != null) {
                cnn.close();
                System.out.println("Se cierra la conexion");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
