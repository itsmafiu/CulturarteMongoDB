package Logica;

import java.time.LocalDateTime;

public class DataAporte {

    private final Double $aporte;
    private final LocalDateTime fechaHora;
    private final int cantidad;
    private final EnumRetorno retorno;
    private final String imagen;
    private final String miColaborador;
    private final String miPropuesta;
    private final Double $necesaria;

    public DataAporte(double $aporte, LocalDateTime fechaHora, int cantidad, EnumRetorno retorno, String miColaborador, String miPropuesta, String imagen, double $necesaria) {
        this.$aporte = $aporte;
        this.fechaHora = fechaHora;
        this.cantidad = cantidad;
        this.retorno = retorno;
        this.miColaborador = miColaborador;
        this.miPropuesta = miPropuesta;
        this.imagen = imagen;
        this.$necesaria = $necesaria;
    }

    public Double get$aporte() {
        return $aporte;
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

    public String getMiColaborador() {
        return miColaborador;
    }

    public String getMiPropuesta() {
        return miPropuesta;
    }

    public String getImagen() {
        return imagen;
    }

    public Double getNecesaria() {
        return $necesaria;
    }
    
}
