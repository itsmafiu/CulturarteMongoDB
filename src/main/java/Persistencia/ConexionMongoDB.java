package Persistencia;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.client.ListDatabasesIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import org.bson.BsonDocument;
import org.bson.Document;
import org.bson.BsonInt64;
import org.bson.BsonReader;
import org.bson.BsonWriter;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
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
    
    private boolean getPing(MongoDatabase database){
        try{
            Bson comando = new BsonDocument("ping", new BsonInt64(1));
            Document resultado = database.runCommand(comando);
            
            logger.info("Resultado ping: " + resultado.toString());

        }catch(MongoException e){
            logger.error("Error Ping: " + e.getMessage());
            return false;
        }
        
        return true;
    }
    
    public boolean crearConexion() throws MongoException{
        try{
            MongoClient mongoClient = MongoClients.create(this.connectionString);
            
            MongoDatabase database = mongoClient.getDatabase("admin");
            if(getPing(database)){
                this.client = mongoClient;
                return true;
            }
            
        }catch(MongoException e){
            logger.error("Error: " + e.getMessage());
            throw e;
        }
        
        return false;
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
    
    public class LocalDateCodec implements Codec<LocalDate> {
    @Override
    public void encode(BsonWriter writer, LocalDate value, EncoderContext encoderContext) {
        writer.writeDateTime(value.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli());
    }

    @Override
    public LocalDate decode(BsonReader reader, DecoderContext decoderContext) {
        return Instant.ofEpochMilli(reader.readDateTime()).atZone(ZoneId.systemDefault()).toLocalDate();
    }

    @Override
    public Class<LocalDate> getEncoderClass() {
        return LocalDate.class;
    }
}

public class LocalDateTimeCodec implements Codec<LocalDateTime> {
    @Override
    public void encode(BsonWriter writer, LocalDateTime value, EncoderContext encoderContext) {
        writer.writeDateTime(value.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
    }

    @Override
    public LocalDateTime decode(BsonReader reader, DecoderContext decoderContext) {
        return Instant.ofEpochMilli(reader.readDateTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    @Override
    public Class<LocalDateTime> getEncoderClass() {
        return LocalDateTime.class;
    }
}
    
public MongoDatabase getDatabaseWithCodec(String databaseName) throws Exception {
    if (this.client == null) {
        if (!this.crearConexion()) {
            throw new Exception("No se ha podido crear la conexión con el servidor MongoDB.");
        }
    }

    CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();

    CodecRegistry pojoCodecRegistry = CodecRegistries.fromRegistries(
        MongoClientSettings.getDefaultCodecRegistry(),
        CodecRegistries.fromProviders(pojoCodecProvider),
        CodecRegistries.fromCodecs(new LocalDateCodec(), new LocalDateTimeCodec())
    );

    MongoDatabase database = this.client.getDatabase(databaseName).withCodecRegistry(pojoCodecRegistry);

    if (!getPing(database)) {
        throw new Exception("No se ha podido acceder a la base de datos.");
    }

    return database;
}
    
    public MongoDatabase getDatabase(String databaseName) throws Exception{
        if(this.client == null){
            if(!this.crearConexion()){
                throw new Exception("No se ha podido crear la conexión con el servidor MongoDB.");
            }
        }
        
        MongoDatabase database = this.client.getDatabase(databaseName);
        if(!getPing(database)){
            throw new Exception("No se ha podido acceder a la base de datos.");
        }
        
        return database;
    }
    
    public void mostrarColecciones(String databaseName){
        try{
            MongoDatabase database = this.getDatabase(databaseName);
            int i = 1;
            logger.info("Colleciones de la base de datos: " + databaseName);
            for(String collectionName : database.listCollectionNames()){
                logger.info(String.format("Coleccion %d: %s", i, collectionName));
                i++;
            }
            logger.info("Fin de colleciones de la base de datos: " + databaseName);
        }catch (Exception e){
            logger.error("Error mostrando colecciones: " + e.getMessage());
        }
    }
    
    public MongoCollection<?> getCollection(String databaseName, String collectionName, Class entidad) throws Exception{
        MongoDatabase database = getDatabaseWithCodec(databaseName);
        return database.getCollection(collectionName, entidad);
    }
    
    public void cerrarConexion(){
        if(this.client != null){
            this.client.close();
            logger.info("Se ha cerrado la conexión con MongoDB");
        }
    }
}
