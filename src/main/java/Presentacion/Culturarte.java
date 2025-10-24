package Presentacion;

import Logica.Colaborador;
import Logica.Fabrica;
import Logica.IControlador;
import Logica.Usuario;
import Persistencia.ConexionMongoDB;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import java.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Culturarte {
    private static final Logger logger = LoggerFactory.getLogger(Culturarte.class);
    
    public static void main(String[] args) throws Exception {
        
        ConexionMongoDB mongoDB = new ConexionMongoDB("localhost", 27017, "admin", "1234");
        try{
            mongoDB.crearConexion();
        }catch(MongoException e){
            logger.error("Error: " + e.getMessage());
            return;
        }
        System.out.println("Conexion establecida");
        
        Fabrica fb = new Fabrica();
        IControlador ic = Fabrica.getInstancia().getIControlador(mongoDB);
//                
        VentanaPrincipal ventana = new VentanaPrincipal(ic);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        
        ///////////////PRUEBAS////////////////////
//        mongoDB.mostrarInformacionCluster();
//        
//        mongoDB.mostrarBasesDeDatos();
//        
//        MongoCollection<Usuario> usuarios;
//        
//        try{
//            usuarios = (MongoCollection<Usuario>) mongoDB.getCollection("Culturarte", "usuarios", Usuario.class);
//        }catch(Exception e){
//            mongoDB.cerrarConexion();
//            logger.error("No ha sido posible acceder a la colección de usuarios. Finaliza el programa.");
//            logger.error("Error: " + e.getMessage());
//            return;
//        }
//        
//        logger.info("Se ha accedido a la colección Usuarios");
//        
//        //usuarios.insertOne(new Colaborador("mafiu", "mafiu@gmail.com", "Matthew", "Freire", LocalDate.now(), "", "1234", ""));
//        
//        mongoDB.mostrarColecciones("Culturarte");
//        
//        mongoDB.cerrarConexion();
    }
}
