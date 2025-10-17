package Logica;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="Propuesta")
public class Propuesta implements Serializable {
    @Id
    private String titulo;
    @Column(name="descripcion",length=1000)
    private String descrip;
    private String imagen = "";
    private String lugar;
    private LocalDate fecha;
    private double montoEntrada;
    private double montoNecesaria;
    private double montoAlcanzada = 0;
    private LocalDate fechaPubli;
    private LocalDateTime fechaLimit;
    private EnumRetorno posibleRetorno;
    @OneToOne
    //@JoinColumn(name = "ESTADOACTUAL_NUMERACION")
    private Estado estadoActual;
    //@ManyToOne
    @OneToMany(mappedBy = "miPropuesta")
    private List<Aporte> misAportes = new ArrayList<>();
    @OneToMany//(mappedBy = "propuesta")
    @JoinTable(name = "ListaEstados", joinColumns = @JoinColumn(name = "tituloPropuesta"), inverseJoinColumns = @JoinColumn(name = "numeracionEstado"))
    public List<Estado> misEstados = new ArrayList<>();//A CAMBIAR
    @ManyToOne
    private Proponente miProponente;
    @ManyToOne
    @JoinColumn(name = "nombre_Categoria")
    private Categoria categoria;
    
    public Propuesta(){
    }

    public Propuesta(Proponente prop, String titulo, String descripcion, String lugar, LocalDate fechaPrev, double montoXentrada, double montoNecesario, EnumRetorno posibleRetorno, LocalDate fechaActual) {
        this.miProponente = prop;
        this.titulo = titulo;
        this.descrip = descripcion;
        this.lugar = lugar;
        this.fechaPubli = fechaPrev;
        this.montoEntrada = montoXentrada;
        this.montoNecesaria = montoNecesario;
        this.posibleRetorno = posibleRetorno;
        this.fecha = fechaActual;
        this.fechaLimit = LocalDateTime.now().plusDays(30);
        Estado estado = new Estado(EnumEstado.valueOf("INGRESADA"), fechaActual);
        
        this.estadoActual = estado;
        this.misEstados.add(estado);

        //DIALOGAR PARA VER QUE HACEMOS CON ESTA EN ESPECIFICO!!!!!!!!!!!!!
    }
    
    public Propuesta(Categoria c,Proponente prop, String titulo, String descripcion, String lugar, LocalDate fechaPrev, double montoXentrada, double montoNecesario, EnumRetorno posibleRetorno, LocalDate fechaActual) {
        this.miProponente = prop;
        this.titulo = titulo;
        this.descrip = descripcion;
        this.lugar = lugar;
        this.fechaPubli = fechaPrev;
        this.montoEntrada = montoXentrada;
        this.montoNecesaria = montoNecesario;
        this.posibleRetorno = posibleRetorno;
        this.fecha = fechaActual;
        this.fechaLimit = LocalDateTime.now().plusDays(30);
        Estado estado = new Estado(EnumEstado.valueOf("INGRESADA"), fechaActual);
        
        this.estadoActual = estado;
        this.misEstados.add(estado);
        this.categoria = c;

    }
    
    public Propuesta(Categoria c, Proponente prop, String titulo, String descripcion, String lugar, LocalDate fechaPrev, double montoXentrada, double montoNecesario, EnumRetorno posibleRetorno, LocalDate fechaActual, String imagen) {
        this.miProponente = prop;
        this.titulo = titulo;
        this.descrip = descripcion;
        this.lugar = lugar;
        this.fechaPubli = fechaPrev;
        this.montoEntrada = montoXentrada;
        this.montoNecesaria = montoNecesario;
        this.posibleRetorno = posibleRetorno;
        this.fecha = fechaActual;
        
        Estado estado = new Estado(EnumEstado.valueOf("INGRESADA"), fechaActual);
        
        this.estadoActual = estado;
        this.misEstados.add(estado);
        this.categoria = c;
        
        this.imagen = imagen;

    }
    
    public void modificarPropuesta(String descripcion, String lugar, LocalDate fechaPrev, double montoXentrada, double montoNecesario, String posibleRetorno, String estado, String imagen, Categoria c){
        this.descrip = descripcion;
        this.lugar = lugar;
        this.fechaPubli = fechaPrev;
        this.montoEntrada = montoXentrada;
        this.montoNecesaria = montoNecesario;
        
        EnumRetorno retorno;
        switch(posibleRetorno){
            case "ENTRADAS_GRATIS" -> retorno = EnumRetorno.valueOf("ENTRADAS_GRATIS");
            case "PORCENTAJE_VENTAS" -> retorno = EnumRetorno.valueOf("PORCENTAJE_VENTAS");
            case "AMBOS" -> retorno = EnumRetorno.valueOf("AMBOS");
            default -> retorno = EnumRetorno.valueOf("ERROR");
        }
        this.posibleRetorno = retorno;
        
        Estado est = new Estado(EnumEstado.valueOf(estado), LocalDate.now());
        this.estadoActual = est;
        this.misEstados.add(est);
        
        this.imagen = imagen;
        
        this.categoria = c;
    }
    
     public String getTitulo_Nickname(){
        return this.titulo+" by "+this.miProponente.getNickname();
    }

    public double getmontoNecesaria() {
        return montoNecesaria;
    }

    public double getmontoAlcanzada() {
        return montoAlcanzada;
    }

    public String getTitulo() {
        return titulo;
    }

    public EnumRetorno getPosibleRetorno() {
        return posibleRetorno;
    }
        
    public void addAporte(Aporte a){
        misAportes.add(a);
        a.setMiPropuesta(this);
        montoAlcanzada+=a.get$aporte();
    }
    
    public void desvincularAporte(Aporte a){
        this.montoAlcanzada-=a.get$aporte();
        this.misAportes.remove(a);
    }
    
    public List<Aporte> getAportes(){
        return this.misAportes; 
    }
    
    public String getImagen(){
        return this.imagen;
    }
    
    public Estado getEstadoActual(){
        return this.estadoActual;
    }
    
    public Proponente getProponente(){
        return this.miProponente;
    }
    
    public String getDescripcion(){
        return this.descrip;
    }
    
    public String getLugar(){
        return this.lugar;
    }
    
    public Double getEntrada(){
        return this.montoEntrada;
    }
    
    public Double getNecesaria(){
        return this.montoNecesaria;
    }
    
    public EnumRetorno getRetorno(){
        return this.posibleRetorno;
    }
    
    public LocalDate getFechaARealizar(){
        return this.fechaPubli;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    
    public String getCategoria(){
        return this.categoria.getNombre();
    }
    public Categoria getCategoriaClase(){
        return this.categoria;
    }
    public Double getAlcanzada(){
        return this.montoAlcanzada;
    }
    
    public void setEstadoActual(Estado estadoActual) {
        this.estadoActual = estadoActual;
    }
    
        public LocalDateTime getFechaLimit() {
        return fechaLimit;
    }

    public void setFechaLimit(LocalDateTime fechaLimit) {
        this.fechaLimit = fechaLimit;
    }

    public void actualizarEstadoActual(EnumEstado estado){
        Estado e = new Estado(estado,LocalDate.now());
        this.estadoActual = e;
        this.misEstados.add(e);
    }
  
}


