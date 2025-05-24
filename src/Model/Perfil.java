/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author karin
 */
public class Perfil {
    private int id_perfil;
    private String nickName;
    private int id_membresia;
    
    private List<GustaDe> gustos;
    private List<Recomendacion> recomendaciones;
    private List<Historial> historial;

    public Perfil() {
    }

    public Perfil(int id_perfil, String nickName, int id_membresia) {
        this.id_perfil = id_perfil;
        this.nickName = nickName;
        this.id_membresia = id_membresia;
    }

    public Perfil(String nickName) {
        this.nickName = nickName;
    }

    public Perfil(int id_perfil) {
        this.id_perfil = id_perfil;
    }

    public int getId_perfil() {
        return id_perfil;
    }

    public void setId_perfil(int id_perfil) {
        this.id_perfil = id_perfil;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getId_membresia() {
        return id_membresia;
    }

    public void setId_membresia(int id_membresia) {
        this.id_membresia = id_membresia;
    }

    public List<GustaDe> getGustos() {
        return gustos;
    }

    public void setGustos(List<GustaDe> gustos) {
        this.gustos = gustos;
    }

    public List<Recomendacion> getRecomendaciones() {
        return recomendaciones;
    }

    public void setRecomendaciones(List<Recomendacion> recomendaciones) {
        this.recomendaciones = recomendaciones;
    }

    public List<Historial> getHistorial() {
        return historial;
    }

    public void setHistorial(List<Historial> historial) {
        this.historial = historial;
    }
    
    
}
