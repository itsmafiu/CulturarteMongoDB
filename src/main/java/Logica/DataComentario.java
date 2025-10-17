/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.time.LocalDateTime;

public class DataComentario {
    
    private final String comentario;
    private final LocalDateTime fecComentario;
    private final String nickColaborador;
    private final String tituloPropuesta;

    public DataComentario(String comentario, LocalDateTime fecComentario, String nickColaborador, String tituloPropuesta) {
        this.comentario = comentario;
        this.fecComentario = fecComentario;
        this.nickColaborador = nickColaborador;
        this.tituloPropuesta = tituloPropuesta;
    }

    public String getComentario() {
        return comentario;
    }

    public LocalDateTime getFecComentario() {
        return fecComentario;
    }

    public String getNickColaborador() {
        return nickColaborador;
    }

    public String getTituloPropuesta() {
        return tituloPropuesta;
    }
    
    
    
            
}
