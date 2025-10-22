package Persistencia;

import com.mongodb.ConnectionString;
import com.mongodb.MongoException;
import com.mongodb.client.ListDatabasesIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.BsonDocument;
import org.bson.Document;
import org.bson.BsonInt64;
import org.bson.conversions.Bson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConexionMongoDB {
    private static final Logger logger = LoggerFactory.getLogger(ConexionMongoDB.class);
    private final ConnectionString connectionString;
    private MongoClient client;

    public ConexionMongoDB(String host, int port, String usuario, String clave) {
        String uri = String.format("mongodb://%s:%s@%s:%d/", usuario, clave, host, port);
        this.connectionString = new ConnectionString(uri);
        this.client = null;
    }
    
    public boolean crearConexion() throws MongoException{
        try{
            MongoClient mongoClient = MongoClients.create(this.connectionString);
            
            MongoDatabase database = mongoClient.getDatabase("admin");
            Bson comando = new BsonDocument("ping", new BsonInt64(1));
            Document resultado = database.runCommand(comando);
            
            logger.info("Conexion establecida. Ping: " + resultado.toString());
            
            this.client = mongoClient;
            
            return true;
        }catch(MongoException e){
            logger.error("Error: " + e.getMessage());
            throw e;
        }
    }
    
    public void mostrarInformacionCluster(){
        if(this.client == null){
            logger.warn("No hay conexion establecida");
            return;
        }
        
        logger.info("Informacion del cluster");
        logger.info(this.client.getClusterDescription().toString());
    }
    
    public void mostrarBasesDeDatos(){
        if(this.client == null){
            logger.warn("No hay conexion establecida");
            return;
        }
        
        logger.info("Listado de bases de datos");
        
        ListDatabasesIterable<Document> databases = this.client.listDatabases();
        
        int aux = 1;
        for(Document d : databases){
            logger.info(String.format("%d-) %s", aux, d.toString()));
            aux++;
        }
    }
    
    public void cerrarConexion(){
        if(this.client != null){
            this.client.close();
            logger.info("Se ha cerrado la conexión con MongoDB");
        }
    }
}
