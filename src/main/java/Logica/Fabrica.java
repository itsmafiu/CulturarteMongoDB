package Logica;

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
    
    public IControlador getIControlador(){
        return new Controlador();
    }
}
