/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author brito
 */
public class DataProponente {
    String nickname;
    String nombre;
    String apellido;
    String email;
    LocalDate fecNac;
    String imagen = "";
    String direccion;
    String biografia = "";
    String sitioWeb = "";
    List<DataPropuesta> misPropuestas;
    public DataProponente(String nickname,String nombre, String apellido,String email,LocalDate fecNac, String imagen,String direccion, String biografia, String sitioWeb) {
        this.nickname = nickname;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.fecNac = fecNac;
        this.imagen = imagen;
        this.direccion = direccion;
        this.biografia = biografia;
        this.sitioWeb = sitioWeb;
    }
     public DataProponente(String nickname,String nombre, String apellido,String email,LocalDate fecNac, String imagen,String direccion, String biografia, String sitioWeb,List<DataPropuesta> propuestas) {
        this.nickname = nickname;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.fecNac = fecNac;
        this.imagen = imagen;
        this.direccion = direccion;
        this.biografia = biografia;
        this.sitioWeb = sitioWeb;
        this.misPropuestas = propuestas;
    }
    public String getNickname() {
        return this.nickname;
    }

    public String getEmail() {
        return this.email;
    }

        public String getNombre() {
        return this.nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public LocalDate getFecNac() {
        return this.fecNac;
    }
    public String getImagen(){
        return this.imagen;
    }
    public String getDireccion() {
        return this.direccion;
    }

    public String getBiografia() {
        return this.biografia;
    }

    public String getSitioWeb() {
        return this.sitioWeb;
    }
    public List<DataPropuesta> getPropuestas(){
        return this.misPropuestas;
    }
}
