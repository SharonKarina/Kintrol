/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author karin
 */
public class GustaDe {
    private String nombreEstilo;
    private int frecuencia;
    private int nivelGusto;

    public GustaDe() {
    }

    public GustaDe(String nombreEstilo, int frecuencia, int nivelGusto) {
        this.nombreEstilo = nombreEstilo;
        this.frecuencia = frecuencia;
        this.nivelGusto = nivelGusto;
    }

    public String getNombreEstilo() {
        return nombreEstilo;
    }

    public void setNombreEstilo(String nombreEstilo) {
        this.nombreEstilo = nombreEstilo;
    }

    public int getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(int frecuencia) {
        this.frecuencia = frecuencia;
    }

    public int getNivelGusto() {
        return nivelGusto;
    }

    public void setNivelGusto(int nivelGusto) {
        this.nivelGusto = nivelGusto;
    }
    
    
}
