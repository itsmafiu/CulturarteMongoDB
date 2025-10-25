package Logica;

import java.io.Serializable;
import java.time.LocalDate;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;


//@Entity
//@Table(name="Estado")
public class Estado implements Serializable {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @BsonId
    ObjectId numeracion = new ObjectId();
    EnumEstado estado;
    LocalDate fecha;

    public Estado(){
    }
     
    public Estado(EnumEstado est, LocalDate fec){
        this.estado = est;
        this.fecha = fec;
    }
    
    public ObjectId getNumeracion() {
        return numeracion;
    }

    public void setNumeracion(ObjectId numeracion) {
        this.numeracion = numeracion;
    }
    
    public EnumEstado getEstado(){
        return this.estado;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setEstado(EnumEstado estado) {
        this.estado = estado;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    
}
