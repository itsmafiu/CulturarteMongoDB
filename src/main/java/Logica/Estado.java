package Logica;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Estado")
public class Estado implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int numeracion;
    EnumEstado estado;
    LocalDate fecha;

    public Estado(){
    }
     
    public Estado(EnumEstado est, LocalDate fec){
        this.estado = est;
        this.fecha = fec;
    }
    
    public int getNumeracion() {
        return numeracion;
    }

    public void setNumeracion(int numeracion) {
        this.numeracion = numeracion;
    }
    
    public EnumEstado getEstado(){
        return this.estado;
    }

    public LocalDate getFecha() {
        return fecha;
    }
    
}
