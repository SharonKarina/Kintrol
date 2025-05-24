/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author karin
 */
public class Recomendacion {
    private int id_recomendacion;
    private Date fecha;
    private String nombreEstilo;
    private int id_estilo;
    private int id_perfil;

    public Recomendacion() {
    }

    public Recomendacion(int id_recomendacion, Date fecha, String nombreEstilo, int id_estilo) {
        this.id_recomendacion = id_recomendacion;
        this.fecha = fecha;
        this.nombreEstilo = nombreEstilo;
        this.id_estilo = id_estilo;
    }
    
    public Recomendacion(int id_recomendacion, Date fecha, String nombreEstilo, int id_estilo, int id_perfil) {
        this.id_recomendacion = id_recomendacion;
        this.fecha = fecha;
        this.nombreEstilo = nombreEstilo;
        this.id_estilo = id_estilo;
        this.id_perfil = id_perfil;
    }

    public int getId_recomendacion() {
        return id_recomendacion;
    }

    public void setId_recomendacion(int id_recomendacion) {
        this.id_recomendacion = id_recomendacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNombreEstilo() {
        return nombreEstilo;
    }

    public void setNombreEstilo(String nombreEstilo) {
        this.nombreEstilo = nombreEstilo;
    }

    public int getId_estilo() {
        return id_estilo;
    }

    public void setId_estilo(int id_estilo) {
        this.id_estilo = id_estilo;
    }
    
    public int getId_perfil() {
        return id_perfil;
    }

    public void setId_perfil(int id_perfil) {
        this.id_perfil = id_perfil;
    }
    
    
    
}
