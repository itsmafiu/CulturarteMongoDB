package Persistencia;

import Logica.Aporte;
import Logica.Categoria;
import Logica.Colaborador;
import Logica.Estado;
import Logica.Proponente;
import Logica.Propuesta;
import Logica.Usuario;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladorPersistencia {
    public ConexionMongoDB mongoDB;
    public MongoDatabase db;
    
    private MongoCollection<Usuario> usuDB;
    private MongoCollection<Propuesta> propuDB;
    private MongoCollection<Estado> estadoDB;
    private MongoCollection<Categoria> categoriaDB;
    private MongoCollection<Aporte> aporteDB;

    public ControladorPersistencia(ConexionMongoDB mongoDB) throws Exception {
        this.mongoDB = mongoDB;
        this.db = mongoDB.getDatabaseWithCodec("Culturarte");
        
        this.usuDB = db.getCollection("usuario", Usuario.class);
        this.propuDB = db.getCollection("propuesta", Propuesta.class);
        this.estadoDB = db.getCollection("estado", Estado.class);
        this.categoriaDB = db.getCollection("categoria", Categoria.class);
        this.aporteDB = db.getCollection("aporte", Aporte.class);
    }
    
    public void añadirUsuario(Usuario u){
        usuDB.insertOne(u);
    }
    
    public List<Usuario> getListaUsuarios(){
        return usuDB.find().into(new ArrayList<>());
    }
    
    public void editarUsuario(Usuario usu) {
        usuDB.replaceOne(eq("_id", usu.getNickname()), usu);
    }

    public void eliminarUsuario(String usu){
        usuDB.deleteOne(eq("_id", usu));
    }
    
    public Usuario buscarUsuario(String nick) {
        return usuDB.find(eq("_id", nick)).first();
    }
    
    public Proponente buscarProponente(String nick) {
        return (Proponente) usuDB.find(eq("_id", nick)).first();
    }

    public List<Usuario> getListaProponentes() {

        List<Usuario> listaUsuarios = new ArrayList<>();
        
        for(Usuario u : usuDB.find(eq("tipo", "Proponente"))){
            listaUsuarios.add(u);
        }

        return listaUsuarios;
    }

    public List<String> getNickProponente(){
        
        List<String> listaUsuarios = new ArrayList<>();
        
        for(Usuario u : usuDB.find(eq("tipo", "Proponente"))){
            listaUsuarios.add(u.getNickname());
        }
        
        return listaUsuarios;
    }

    public List<Usuario> getListaColaboradores() { //getColaboradores
        
        List<Usuario> listaUsuarios = new ArrayList<>();
        
        for(Usuario u : usuDB.find(eq("tipo", "Colaborador"))){
            listaUsuarios.add(u);
        }

        return listaUsuarios;
    }

    public void añadirPropuesta(Propuesta p) {
        this.propuDB.insertOne(p);

        Proponente prop = p.getProponente();
        if(!prop.getPropuestas().contains(p)){
            prop.agregarPropuesta(p); //Sin esto no se guarda en PROPONENTE_Propuesta aunque claro
            editarUsuario(prop);  //no hay que olvidarte el .edit para que se persista
        }
        Categoria cat = p.getCategoriaClase();
        if (!cat.getPropuestas().contains(p)) { 
            cat.agregarPropuesta(p); //Lo mismo con esto pero aca se agrega la FK en Propuesta
            editarCategoria(cat);
        }
    }

    public List<Propuesta> getListaPropuestas() {
        return propuDB.find().into(new ArrayList<>());
    }
    
    public Propuesta getPropuesta(String titulo){
        return propuDB.find(eq("_id", titulo)).first();
    }
    
    public void editarPropuesta(Propuesta prop){
        propuDB.replaceOne(eq("_id", prop.getTitulo()), prop);
    }
    
//    public void modificarPropuesta(Propuesta p){ //Tal vez me serviria que me pases la categoria tambien asi la edito aca
//        try {
//            propJPA.edit(p);
//        } catch (Exception ex) {
//            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

    public void añadirEstado(Estado e) {
        this.estadoDB.insertOne(e);
    }
  
    public void createCategoria(Categoria cat) {
        this.categoriaDB.insertOne(cat);
    }

    public Categoria findCategoria(String nombreCat) {
        return this.categoriaDB.find(eq("_id", nombreCat)).first();
    }

    public List<Categoria> listarCategorias() {
        return this.categoriaDB.find().into(new ArrayList<>());
    }
    
    public void editarCategoria(Categoria cat){
        categoriaDB.replaceOne(eq("_id", cat.getNombre()), cat);
    }

    public List<String> getNickColaboradores() {
               
        List<String> listaUsuarios = new ArrayList<>();
        
        for(Usuario u : usuDB.find(eq("tipo", "Colaborador"))){
            listaUsuarios.add(u.getNickname());
        }
        
        return listaUsuarios;
    }
    
//    public void editarColaborador(Colaborador cola){
//        try {
//            colaJPA.edit(cola);
//        } catch (Exception ex) {
//            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

    public void añadirAporte(Aporte a, Propuesta p, Colaborador c) {
        aporteDB.insertOne(a);
        editarPropuesta(p);
        editarUsuario(c);
    }
    
    public void borrarAporte(Aporte a, Propuesta p, Colaborador c) throws Exception {
        aporteDB.deleteOne(eq("_id", a.getId()));
        editarPropuesta(p);
        editarUsuario(c);
    }

    public void editarAporte(Aporte a) {
        aporteDB.replaceOne(eq("_id", a.getId()), a);
    }
    
//    OPERACIONES
//    insertar = usuDB.insertOne(u);
//    obtener todos = usuDB.find();
//    buscar = usuDB.find(eq("_id", "mafiu")).first(); // eq --> filtro / first() --> usar cuando se espera un solo resultado
//    actualizar = usuDB.updateOne(eq("_id", "mafiu"), set("correo", "nuevo@correo.com"));
//    eliminar = usuDB.deleteOne(eq("_id", "mafiu"));
//    //añadir a una lista 
//    Bson update = Updates.push("misSeguidos", "nuevoUsuario"); (Updates.addToSet si no quiere que esté repetido, Updates.pull para eliminar de lista)
//    usuDB.updateOne(eq("_id", "mafiu"), update);
//    //obtener una lista de una clase
//    List<String> seguidosNicks = usuario.getMisSeguidos();
//    List<Usuario> seguidos = usuarios.find(Filters.in("_id", seguidosNicks)).into(new ArrayList<>());
}
