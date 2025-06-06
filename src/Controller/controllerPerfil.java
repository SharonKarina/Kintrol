/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Perfil;
import Model.PerfilDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author karin
 */
public class controllerPerfil {
    public PerfilDAO dao;

    public controllerPerfil(PerfilDAO dao) {
        this.dao = dao;
    }
    
    public controllerPerfil(){
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public ArrayList<Perfil> listarPerfil() {
        try {
            return dao.listar();
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
    
    public int crearPerfil(Perfil p) {
        try {
            return dao.insertar(p);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public boolean actualizarPerfil(Perfil p) {
        try {
            return dao.actualizar(p);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarPerfil(int id) {
        try {
            return dao.eliminar(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Perfil obtenerPerfil(int id) {
        try {
            return dao.obtenerPorId(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}

    
