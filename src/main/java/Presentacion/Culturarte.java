package Presentacion;

import Logica.Fabrica;
import Logica.IControlador;

public class Culturarte {

    public static void main(String[] args) {
        
//        Fabrica fb = new Fabrica();
        IControlador ic = Fabrica.getInstancia().getIControlador();
                
        VentanaPrincipal ventana = new VentanaPrincipal(ic);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        
    }
}
