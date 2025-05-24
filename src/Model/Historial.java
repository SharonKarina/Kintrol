/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author karin
 */
public class Historial {
    private int idHistorial;
    private String descripcion;
    private String fecha;
    private int id_perfil;

    public Historial() {
    }

    public Historial(int idHistorial, String descripcion, String fecha, int id_perfil) {
        this.idHistorial = idHistorial;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.id_perfil = id_perfil;
    }

    public Historial(int idHistorial, String descripcion, String fecha) {
        this.idHistorial = idHistorial;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public Historial(int idHistorial) {
        this.idHistorial = idHistorial;
    }

    public int getIdHistorial() {
        return idHistorial;
    }

    public void setIdHistorial(int idHistorial) {
        this.idHistorial = idHistorial;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getId_perfil() {
        return id_perfil;
    }

    public void setId_perfil(int id_perfil) {
        this.id_perfil = id_perfil;
    }
    
    
}
