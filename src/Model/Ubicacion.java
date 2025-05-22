/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author karin
 */
public class Ubicacion {
    private int idUbicacion;
    private String pais;
    private String ciudad;

    public Ubicacion() {
    }

    public Ubicacion(int idUbicacion, String pais, String ciudad) {
        this.idUbicacion = idUbicacion;
        this.pais = pais;
        this.ciudad = ciudad;
    }

    public Ubicacion(int idUbicacion) {
        this.idUbicacion = idUbicacion;
    }

    public int getIdUbicacion() {
        return idUbicacion;
    }

    public void setIdUbicacion(int idUbicacion) {
        this.idUbicacion = idUbicacion;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    
    
}
