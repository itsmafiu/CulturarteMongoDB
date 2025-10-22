package Presentacion;

import Logica.Fabrica;
import Logica.IControlador;
import Persistencia.ConexionMongoDB;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Culturarte {
    private static final Logger logger = LoggerFactory.getLogger(Culturarte.class);
    
    public static void main(String[] args) throws Exception {
        
        Fabrica fb = new Fabrica();
        IControlador ic = Fabrica.getInstancia().getIControlador();
//                
//        VentanaPrincipal ventana = new VentanaPrincipal(ic);
//        ventana.setLocationRelativeTo(null);
//        ventana.setVisible(true);
        
        ConexionMongoDB cp = new ConexionMongoDB("localhost", 27017, "root", "1234");
        
        
        try{
            cp.crearConexion();
        }catch(MongoException e){
            logger.error("Error: " + e.getMessage());
            return;
        }

        System.out.println("Conexion establecida");
        
        cp.mostrarInformacionCluster();
        
        cp.mostrarBasesDeDatos();
        
        cp.cerrarConexion();
    }
}
