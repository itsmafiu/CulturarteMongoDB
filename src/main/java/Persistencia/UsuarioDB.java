
package Persistencia;

import Logica.Usuario;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class UsuarioDB {
    private final MongoCollection<Usuario> coleccion;
    
    public UsuarioDB(ConexionMongoDB conexion) throws Exception{
        //MongoDatabase db = conexion.getDatabaseWithCodec("Culturarte");
        this.coleccion = (MongoCollection<Usuario>) conexion.getCollection("Culturarte", "Usuario", Usuario.class);
    }
    
    
}
