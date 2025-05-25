/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.MembresiaDAO;
import Model.Membresia;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author karin
 */
public class controllerMembresias {
    public MembresiaDAO dao;

    public controllerMembresias(MembresiaDAO dao) {
        this.dao = dao;
    }

    public controllerMembresias() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ArrayList<Membresia> listarMembresias() {
        try {
            return dao.listar();
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
    
    public int crearMembresia(Membresia m) {
        try {
            return dao.insertar(m);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public boolean actualizarMembresia(Membresia m) {
        try {
            return dao.actualizar(m);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarConAdministrador(int idMembresia) {
        MembresiaDAO dao = new MembresiaDAO();
        return dao.eliminarMembresiaYAdministrador(idMembresia);
    }

    public Membresia obtenerMembresia(int id) {
        try {
            return dao.obtenerPorId(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
