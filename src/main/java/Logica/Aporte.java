package Logica;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="Aporte")
public class Aporte implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne
    @JoinColumn(name = "titulo")
    private Propuesta miPropuesta;
    @ManyToOne
    @JoinColumn(name = "nickname")
    private Colaborador miColaborador;
    private double $aporte;
    private LocalDateTime fechaHora;
    private int cantidad;
    private EnumRetorno retorno;
    private String comentario;
    private LocalDateTime fecComentario;

    public Aporte() {
    }
    
    public Aporte(Colaborador miColaborador, double $aporte, int cantidad, EnumRetorno retorno) {
            
        this.miColaborador = miColaborador;
        this.$aporte = $aporte;
        this.fechaHora = LocalDateTime.now();
        this.cantidad = cantidad;
        this.retorno = retorno;
    }
    
    public Aporte(Colaborador miColaborador, double $aporte, int cantidad, EnumRetorno retorno, LocalDateTime fecAp) {
            
        this.miColaborador = miColaborador;
        this.$aporte = $aporte;
        this.fechaHora = fecAp;
        this.cantidad = cantidad;
        this.retorno = retorno;
    }
    
    public String getTituloNickMiPropuesta(){
        if(this.miPropuesta != null){
            return this.miPropuesta.getTitulo_Nickname();
        }else{
            return null;
        }        
    }
    
    public String getTituloMiPropuesta(){
        if(this.miPropuesta != null){
            return this.miPropuesta.getTitulo();
        }else{
            return null;
        }        
    }
    
    public String getNicknameMiColaborador(){
        if(this.miColaborador != null){
            return this.miColaborador.getNickname();
        }else{
            return null;
        }        
    }
    
    public void desvincular(){
        this.miPropuesta.desvincularAporte(this);
        //miColaborador=null;
        //miPropuesta=null;
    }
    
    public double get$aporte() {
        return $aporte;
    }

    public void setMiPropuesta(Propuesta miPropuesta) {
        this.miPropuesta = miPropuesta;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public int getCantidad() {
        return cantidad;
    }

    public EnumRetorno getRetorno() {
        return retorno;
    }
    
    public Colaborador getColaborador(){
        return miColaborador;
    }
    public Propuesta getPropuesta(){
        return this.miPropuesta;
    }
    public DataPropuesta getDataPropuesta(){
        if(miPropuesta!=null){
            return new DataPropuesta(miPropuesta.getAlcanzada() ,miPropuesta.getTitulo(), miPropuesta.getEstadoActual(),miPropuesta.getLugar(),miPropuesta.getProponente().getNickname());
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getImagenMiPropuesta(){
        return this.miPropuesta.getImagen();
    }
    
    public double getNecesaria(){
        return this.miPropuesta.getNecesaria();
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public LocalDateTime getFecComentario() {
        return fecComentario;
    }

    public void setFecComentario(LocalDateTime fecComentario) {
        this.fecComentario = fecComentario;
    }
    
    

}
