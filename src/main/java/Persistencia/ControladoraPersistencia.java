package Persistencia;

import Logica.Aporte;
import Logica.Categoria;
import Logica.Colaborador;
import Logica.Estado;
import Logica.Proponente;
import Logica.Propuesta;
import Logica.Usuario;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladoraPersistencia {

    UsuarioJpaController usuJPA = new UsuarioJpaController();

    public Usuario buscarUsuario(String nick) {
        return usuJPA.findUsuario(nick);
    }

    public ArrayList<Usuario> getListaUsuarios() {

        List<Usuario> lista = usuJPA.findUsuarioEntities();
        ArrayList<Usuario> listaUsuarios = new ArrayList<>(lista);

        return listaUsuarios;
    }

    public void editarUsuario(Usuario usu) {
        try {
            usuJPA.edit(usu);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarUsuario(String usu){
        try {
            usuJPA.destroy(usu);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    ProponenteJpaController usuPropJPA = new ProponenteJpaController();

    public void añadirUsuario(Proponente usu) {
        try {
            usuJPA.create(usu);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Proponente buscarProponente(String nick) {
        return usuPropJPA.findProponente(nick);
    }

    public ArrayList<Proponente> getListaProponentes() {

        List<Proponente> lista = usuPropJPA.findProponenteEntities();
        ArrayList<Proponente> listaUsuarios = new ArrayList<Proponente>(lista);

        return listaUsuarios;
    }

    public List<String> getNickProponente(){
        return usuPropJPA.getListaNick();
    }
    
    ColaboradorJpaController usuColaJPA = new ColaboradorJpaController();

    public void añadirUsuario(Colaborador usu) {
        try {
            usuJPA.create(usu);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Colaborador> getColaboradores() {
        return usuColaJPA.findColaboradorEntities();
    }

    
    PropuestaJpaController propJPA = new PropuestaJpaController();

    public void añadirPropuesta(Propuesta p) {
        try {
            propJPA.create(p);
            
            Proponente prop = p.getProponente();
            if(!prop.getPropuestas().contains(p)){
                prop.agregarPropuesta(p); //Sin esto no se guarda en PROPONENTE_Propuesta aunque claro
                usuPropJPA.edit(prop);  //no hay que olvidarte el .edit para que se persista
            }
            Categoria cat = p.getCategoriaClase();
            if (!cat.getPropuestas().contains(p)) { 
                cat.agregarPropuesta(p); //Lo mismo con esto pero aca se agrega la FK en Propuesta
                catJPA.edit(cat);
            }
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Propuesta> getListaPropuestas() {
        return propJPA.findPropuestaEntities();
    }
    
    public Propuesta getPropuesta(String titulo){
        return propJPA.findPropuesta(titulo);
    }
    public void editarPropuesta(Propuesta prop){
        try {
            propJPA.edit(prop);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void modificarPropuesta(Propuesta p){ //Tal vez me serviria que me pases la categoria tambien asi la edito aca
        try {
            propJPA.edit(p);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    EstadoJpaController estadoJPA = new EstadoJpaController();

    public void añadirEstado(Estado e) {
        try {
            estadoJPA.create(e);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private CategoriaJpaController catJPA = new CategoriaJpaController();

    public void createCategoria(Categoria cat) {
        try {
            this.catJPA.create(cat);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Categoria findCategoria(String nombreCat) {
        return this.catJPA.findCategoria(nombreCat);
    }

    public List<Categoria> listarCategorias() {
        return this.catJPA.findCategoriaEntities();
    }
    public void editarCategoria(Categoria cat){
        try {
            catJPA.edit(cat);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    ColaboradorJpaController colaJPA = new ColaboradorJpaController();

    public List<String> getNickColaboradores() {
        return colaJPA.getListaNick();
    }
    
    public Colaborador buscarColaborador(String NickName){
        return colaJPA.findColaborador(NickName);
    }
    
    public void editarColaborador(Colaborador cola){
        try {
            colaJPA.edit(cola);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    AporteJpaController aporteJPA = new AporteJpaController();

    public void añadirAporte(Aporte a, Propuesta p, Colaborador c) {
        try {
            aporteJPA.create(a);
            propJPA.edit(p);
            colaJPA.edit(c);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void borrarAporte(Aporte a, Propuesta p, Colaborador c) throws Exception {
        try {
            aporteJPA.destroy(a.getId());
            propJPA.edit(p);
            colaJPA.edit(c);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editarAporte(Aporte a) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
