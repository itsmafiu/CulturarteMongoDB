package Logica;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "nickname")
public class Proponente extends Usuario {

    
    String direccion;
    @Column(name="descripcion",length=1000)
    String biografia = "";
    String sitioWeb = "";
    List<Propuesta> misPropuestas;
    public Proponente() {
        
    }
    
    public Proponente(String direccion, String biografia, String sitioWeb, String nickname, String email, String nombre, String apellido, LocalDate fecNac, String imagen, String contraseña, String imagenWeb) {
        super(nickname, email, nombre, apellido, fecNac, imagen, contraseña, imagenWeb);
        this.direccion = direccion;
        this.biografia = biografia;
        this.sitioWeb = sitioWeb;
        this.misPropuestas = new ArrayList<>();
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public String getSitioWeb() {
        return sitioWeb;
    }

    public void setSitioWeb(String sitioWeb) {
        this.sitioWeb = sitioWeb;
    }
    public void agregarPropuesta(Propuesta nuevaProp){
        this.misPropuestas.add(nuevaProp);
    }
    public List<Propuesta> getPropuestas(){
        return this.misPropuestas;
    }   
}
