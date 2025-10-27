package Logica;

import java.io.Serializable;
import java.time.LocalDateTime;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

public class Aporte implements Serializable {
    @BsonId
    private ObjectId id;
    private String tituloMiPropuesta;
    private String tituloNickMiPropuesta;
    private String imagenMiPropuesta;
    private String nickMiColaborador;
    private double $aporte;
    private double $necesaria;
    private LocalDateTime fechaHora;
    private int cantidad;
    private EnumRetorno retorno;
    private String comentario;
    private LocalDateTime fecComentario;

    public Aporte() {
    }
    
    public Aporte(String nickMiColaborador, double $aporte, int cantidad, EnumRetorno retorno) {
            
        this.nickMiColaborador = nickMiColaborador;
        this.$aporte = $aporte;
        this.fechaHora = LocalDateTime.now();
        this.cantidad = cantidad;
        this.retorno = retorno;
    }
    
    public Aporte(String nickMiColaborador, double $aporte, int cantidad, EnumRetorno retorno, LocalDateTime fecAp) {
            
        this.nickMiColaborador = nickMiColaborador;
        this.$aporte = $aporte;
        this.fechaHora = fecAp;
        this.cantidad = cantidad;
        this.retorno = retorno;
    }
        
//    public void desvincular(){
//        this.miPropuesta.desvincularAporte(this);
//        //miColaborador=null;
//        //miPropuesta=null;
//    }

//    public DataPropuesta getDataPropuesta(){
//        if(miPropuesta!=null){
//            return new DataPropuesta(miPropuesta.getMontoAlcanzada() ,miPropuesta.getTitulo(), miPropuesta.getEstadoActual(),miPropuesta.getLugar(),miPropuesta.getProponente());
//        }
//        return null;
//    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getTituloMiPropuesta() {
        return tituloMiPropuesta;
    }

    public void setTituloMiPropuesta(String tituloMiPropuesta) {
        this.tituloMiPropuesta = tituloMiPropuesta;
    }

    public String getTituloNickMiPropuesta() {
        return tituloNickMiPropuesta;
    }

    public void setTituloNickMiPropuesta(String tituloNickMiPropuesta) {
        this.tituloNickMiPropuesta = tituloNickMiPropuesta;
    }
    
    public String getNickMiColaborador() {
        return nickMiColaborador;
    }

    public void setNickMiColaborador(String nickMiColaborador) {
        this.nickMiColaborador = nickMiColaborador;
    }

    public double get$aporte() {
        return $aporte;
    }

    public void set$aporte(double $aporte) {
        this.$aporte = $aporte;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public EnumRetorno getRetorno() {
        return retorno;
    }

    public void setRetorno(EnumRetorno retorno) {
        this.retorno = retorno;
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

    public String getImagenMiPropuesta() {
        return imagenMiPropuesta;
    }

    public void setImagenMiPropuesta(String imagenMiPropuesta) {
        this.imagenMiPropuesta = imagenMiPropuesta;
    }

    public double getNecesaria() {
        return $necesaria;
    }

    public void setNecesaria(double $necesaria) {
        this.$necesaria = $necesaria;
    }
    
    
    
}
