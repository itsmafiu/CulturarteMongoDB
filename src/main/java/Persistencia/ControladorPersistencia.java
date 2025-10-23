package Persistencia;

import Logica.Usuario;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.List;

public class ControladorPersistencia {
    public ConexionMongoDB mongoDB;
    public MongoDatabase db;
    
    private MongoCollection<Usuario> usuDB;

    public ControladorPersistencia(ConexionMongoDB mongoDB) throws Exception {
        this.mongoDB = mongoDB;
        this.db = mongoDB.getDatabaseWithCodec("Culturarte");
        
        this.usuDB = db.getCollection("usuarios", Usuario.class);
    }
    
    public void añadirUsuario(Usuario u){
        usuDB.insertOne(u);
    }
    
    public List<Usuario> getListaUsuarios(){
        List<Usuario> listaUsuarios = new ArrayList<>();
        
        for(Usuario u : usuDB.find()){
            listaUsuarios.add(u);
        }
        return listaUsuarios;
    }
    
    
    
    //OPERACIONES
    //insertar = usuDB.insertOne(u);
    //obtener todos = usuDB.find();
    //buscar = usuDB.find(eq("_id", "mafiu")).first(); // eq --> filtro / first() --> usar cuando se espera un solo resultado
    //actualizar = usuDB.updateOne(eq("_id", "mafiu"), set("correo", "nuevo@correo.com"));
    //eliminar = usuDB.deleteOne(eq("_id", "mafiu"));
    ////añadir a una lista 
    //Bson update = Updates.push("misSeguidos", "nuevoUsuario"); (Updates.addToSet si no quiere que esté repetido, Updates.pull para eliminar de lista)
    //usuDB.updateOne(eq("_id", "mafiu"), update);
    ////obtener una lista de una clase
    //List<String> seguidosNicks = usuario.getMisSeguidos();
    //List<Usuario> seguidos = usuarios.find(Filters.in("_id", seguidosNicks)).into(new ArrayList<>());
}
