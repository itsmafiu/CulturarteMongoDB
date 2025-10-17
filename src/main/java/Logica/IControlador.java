package Logica;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import javax.swing.tree.DefaultMutableTreeNode;

public interface IControlador {
    
    int añadirUsuario(String nick, String nombre, String apellido, String correo, LocalDate fecNac, String imagen, String contraseña, String direccion, String bio, String sitioWeb, String imagenWeb);
    
    int añadirUsuario(String nick, String nombre, String apellido, String correo, LocalDate fecNac, String imagen, String contraseña, String imagenWeb);
    
    int altaCategoria(String nombreCat);
    
    int altaCategoria(String nombreCat,String nombrePadreCat);
    
    int altaAporte(String miColaborador, String miPropuesta, double $aporte, int cantidad, EnumRetorno retorno);
    
    int altaAporte(String miColaborador, String miPropuesta, double $aporte, int cantidad, EnumRetorno retorno,LocalDateTime fecAp);
        
    List<String> getUsuarios(); 
    
    List<String> getUsuariosProponentes();
    
    DataProponente consultaDeProponente(String NickName);
    
    DataColaborador consultaDeColaborador(String NickName);
    
    List<String> getSeguidos(String seguidor);
    
    List<String> getColaboradores();
    
    List<String> getPropuestas_Proponentes();
    
    int seguirUsuario(String nick1, String nick2);
    
    int dejarSeguirUsuario(String nick1, String nick2);
    
    int altaPropuesta(String nick, String tipo, String titulo, String descripcion, String lugar, LocalDate fechaPrev, String montoXentrada, String montoNecesario, EnumRetorno posibleRetorno, LocalDate fechaActual, String imagen);
    
    int cambiarEstadoPropuesta(String titulo, String est);
    
    int modificarPropuesta(String titulo, String descripcion, String lugar, LocalDate fechaPrev, String montoXentrada, String montoNecesario, String posibleRetorno, String estado, String imagen, String categoria);
    
    DefaultMutableTreeNode cargarNodoRaizCategorias();
        
    List<String> getPropuestas();
    
    List<String> getPropuestasI();
    
    DataPropuesta consultaDePropuesta(String titulo);
    
    DataPropuesta getDataPropuesta(String titulo_nick);
    
    List<String> getEstados();
    
    List<String> getPropXEstado(String estado);
    
    List<String> getPropuestasXColaborador(String nick);
    
    DataAporte getDataAporte(String tituloNick, String nick);
    
    void borrarAporte(String tituloNick, String nick);
    
    boolean existeTitulo(String titulo);
    
    List<String> getColabsProp(String titulo);
    
    boolean seleccionaCategoria(String categoria);
    
    void cambiarEstado(String titulo, int n);
    void eliminarUsuario(String usu);
                
    boolean esFavorita(String titulo, String nick);
    
    int cambiarFavorita(String titulo, String nick);
    
    void addComentario(String titulo, String nick, String comentario);
    
    public DataComentario getDataComentario(String titulo, String nick);
}
