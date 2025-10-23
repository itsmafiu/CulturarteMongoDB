package Logica;

import Persistencia.ConexionMongoDB;

public class Fabrica {
    private static Fabrica instancia;

    public Fabrica() {
    }
    
    public static Fabrica getInstancia(){
        if(instancia==null){
            instancia = new Fabrica();
        }
        return instancia;
    }
    
    public IControlador getIControlador(ConexionMongoDB mongoDB) throws Exception{
        return new Controlador(mongoDB);
    }
}
