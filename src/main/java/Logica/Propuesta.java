package Logica;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.bson.BsonType;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.codecs.pojo.annotations.BsonRepresentation;



//@Entity
//@Table(name="Propuesta")
public class Propuesta implements Serializable {
//    @Id
    @BsonId
    @BsonProperty("_id")
    private String titulo;
//    @Column(name="descripcion",length=1000)
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
//    @OneToOne
    //@JoinColumn(name = "ESTADOACTUAL_NUMERACION")
    private Estado estadoActual;
    //@ManyToOne
//    @OneToMany(mappedBy = "miPropuesta")
    private List<Aporte> misAportes = new ArrayList<>();
//    @OneToMany//(mappedBy = "propuesta")
//    @JoinTable(name = "ListaEstados", joinColumns = @JoinColumn(name = "tituloPropuesta"), inverseJoinColumns = @JoinColumn(name = "numeracionEstado"))
    public List<Estado> misEstados = new ArrayList<>();//A CAMBIAR
//    @ManyToOne
    private String miProponente;
//    @ManyToOne
//    @JoinColumn(name = "nombre_Categoria")
    private String categoria;
    
    public Propuesta(){
    }

    public Propuesta(String prop, String titulo, String descripcion, String lugar, LocalDate fechaPrev, double montoXentrada, double montoNecesario, EnumRetorno posibleRetorno, LocalDate fechaActual) {
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
    
    public Propuesta(String c,String prop, String titulo, String descripcion, String lugar, LocalDate fechaPrev, double montoXentrada, double montoNecesario, EnumRetorno posibleRetorno, LocalDate fechaActual) {
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
    
    public Propuesta(String c, String prop, String titulo, String descripcion, String lugar, LocalDate fechaPrev, double montoXentrada, double montoNecesario, EnumRetorno posibleRetorno, LocalDate fechaActual, String imagen) {
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
    
    public void modificarPropuesta(String descripcion, String lugar, LocalDate fechaPrev, double montoXentrada, double montoNecesario, String posibleRetorno, String estado, String imagen, String c){
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
        return this.titulo+" by "+this.miProponente;
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
        a.setTituloMiPropuesta(titulo);
        a.setTituloNickMiPropuesta(titulo+" by "+miProponente);
        a.setImagenMiPropuesta(imagen);
        a.setNecesaria(montoNecesaria);
        montoAlcanzada+=a.getAporte();
    }
    
    public void desvincularAporte(String nickCola){
        for (Aporte a : misAportes) {
            if (nickCola.equals(a.getNickMiColaborador())) {
                //a.desvincular();
                this.montoAlcanzada-=a.getAporte();
                this.misAportes.remove(a);
                return;
            }
        }
    }
    
    public String getImagen(){
        return this.imagen;
    }
    
    public Estado getEstadoActual(){
        return this.estadoActual;
    }
    
    public String getProponente(){
        return this.miProponente;
    }
    
    public String getLugar(){
        return this.lugar;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    
    public String getCategoria(){
        return this.categoria;
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

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public void setMontoEntrada(double montoEntrada) {
        this.montoEntrada = montoEntrada;
    }

    public void setMontoNecesaria(double montoNecesaria) {
        this.montoNecesaria = montoNecesaria;
    }

    public void setMontoAlcanzada(double montoAlcanzada) {
        this.montoAlcanzada = montoAlcanzada;
    }

    public void setFechaPubli(LocalDate fechaPubli) {
        this.fechaPubli = fechaPubli;
    }

    public void setPosibleRetorno(EnumRetorno posibleRetorno) {
        this.posibleRetorno = posibleRetorno;
    }

    public void setMisAportes(List<Aporte> misAportes) {
        this.misAportes = misAportes;
    }

    public void setMisEstados(List<Estado> misEstados) {
        this.misEstados = misEstados;
    }

    public void setMiProponente(String miProponente) {
        this.miProponente = miProponente;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescrip() {
        return descrip;
    }

    public double getMontoEntrada() {
        return montoEntrada;
    }

    public double getMontoNecesaria() {
        return montoNecesaria;
    }

    public double getMontoAlcanzada() {
        return montoAlcanzada;
    }

    public LocalDate getFechaPubli() {
        return fechaPubli;
    }

    public List<Aporte> getMisAportes() {
        return misAportes;
    }

    public List<Estado> getMisEstados() {
        return misEstados;
    }

    public String getMiProponente() {
        return miProponente;
    }
  
    
}


