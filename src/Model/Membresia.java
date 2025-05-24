/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author karin
 */
public class Membresia {
    private int idMembresia;
    private int limite;
    private String fechaInicio;
    private int duracion;
    private int idAdministrador;
    private int idUbicacion;

    public Membresia() {
    }
    
    public Membresia(int idMembresia, int limite, String fechaInicio, int duracion, int idAdministrador, int idUbicacion) {
        this.idMembresia = idMembresia;
        this.limite = limite;
        this.fechaInicio = fechaInicio;
        this.duracion = duracion;
        this.idAdministrador = idAdministrador;
        this.idUbicacion = idUbicacion;
    }
    
    

    public Membresia(int idMembresia) {
        this.idMembresia = idMembresia;
    }
    
    public int getIdMembresia() {
        return idMembresia;
    }

    public void setIdMembresia(int idMembresia) {
        this.idMembresia = idMembresia;
    }

    public int getLimite() {
        return limite;
    }

    public void setLimite(int limite) {
        this.limite = limite;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(int idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public int getIdUbicacion() {
        return idUbicacion;
    }

    public void setIdUbicacion(int idUbicacion) {
        this.idUbicacion = idUbicacion;
    }
    
    
}
