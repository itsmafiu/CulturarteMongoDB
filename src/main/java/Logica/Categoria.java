package Logica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Categoria")
public class Categoria implements Serializable{
    @Id
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "padre_nombre")
    private Categoria padre; //Necesito agregar esto para poder llenar ArbolCategoria y
    //mantener la Jerarquia entre Categorias sacando las Categorias de la base de Datos
    
    @OneToMany(mappedBy="padre")
    private List<Categoria> hijas = new ArrayList<>();
    
    @OneToMany(mappedBy = "categoria")
    private List<Propuesta> misPropuestas = new ArrayList();

    public Categoria() {
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public Categoria(String nomCat){
        this.nombre = nomCat;
    }    
    
    public void setHijas(List<Categoria> hijas) {
        this.hijas = hijas;
    }

    public List<Categoria> getHijas() {
        return hijas;
    }
    
    public Categoria getPadre() {
        return padre;
    }

    public void setPadre(Categoria padre) {
        this.padre = padre;
    }
    public List<Propuesta> getPropuestas(){
        return misPropuestas;
    }
    
    public void agregarPropuesta(Propuesta prop){ //Esto hara que tenga una complejidad adicional para el alta de propuesta y modificar propuestas y más para propuestas
        //canceladas que supongo no debo mostrar...
        misPropuestas.add(prop);
    }
    
    public void sacarPropuesta(Propuesta prop){ //No hago verificaciones si esta propuesta ya existe en la lista de Propuestas porque esto se usara para modifcar
        //propuesta y al estar parado en la propuesta y querer cambiar su categoria no deberia dar problemas eliminar esta propuesta de la categoria usandolo
        //luego pienso bien en la logica asi lo termino practicamente implementando yo 
        misPropuestas.remove(prop);
    }
    public void agregarHija(Categoria cat){
        hijas.add(cat);
        cat.setPadre(this);
    }
}
