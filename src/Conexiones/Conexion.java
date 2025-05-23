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
    private String DRIVER = "com.mysql.cj.jdbc.Driver";
    private String URL = "jdbc:mysql://localhost:3306/db_kintrol";
    private String USER = "root";
    private String PASSWORD = "AlexitoKarina";
    
    private Connection cnn = null; //Conexión con la base de datos
    
    private static Conexion cnx = null; //Instancia singleton
    
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
    
    //Obtiene la intancia del singleton
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
