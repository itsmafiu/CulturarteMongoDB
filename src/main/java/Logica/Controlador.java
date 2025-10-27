package Logica;

import Persistencia.ConexionMongoDB;
import Persistencia.ControladorPersistencia;
import ch.qos.logback.core.read.ListAppender;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import javax.swing.tree.DefaultMutableTreeNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Controlador implements IControlador{

//    public List<Usuario> misUsuarios = new ArrayList<>();
//    public List<Proponente> misProponentes = new ArrayList<>();
//    public List<Colaborador> misColaboradores = new ArrayList<>();
//    public List<Propuesta> misPropuestas = new ArrayList<>();
    private static final Logger logger = LoggerFactory.getLogger(Controlador.class);
    
    public ConexionMongoDB mongoDB;
    ControladorPersistencia cp;
    
    public Controlador(ConexionMongoDB mongoDB) throws Exception {
        this.mongoDB = mongoDB;
        this.cp = new ControladorPersistencia(mongoDB);
    }
    
    @Override //colaborador
    public int añadirUsuario(String nick, String nombre, String apellido, String correo, LocalDate fecNac, String imagen, String contraseña, String imagenWeb){
        String nickNuevo = nick;
        String correoNuevo = correo;
        
        List<Usuario> listaUsuarios = cp.getListaUsuarios();
        
        for(Usuario u : listaUsuarios){
            if(u.getNickname().equals(nickNuevo)){
                return 0;
            }
        }
        
        for(Usuario u : listaUsuarios){
            if(u.getEmail().equals(correoNuevo)){
                return 2;
            }
        }
        
        Colaborador colaNuevo = new Colaborador(nick, correo, nombre, apellido, fecNac, imagen, contraseña, imagenWeb);
        //misUsuarios.add(colaNuevo);
        colaNuevo.setTipo("Colaborador");
        cp.añadirUsuario(colaNuevo);
        return 1;
    }
    
    @Override //proponente
    public int añadirUsuario(String nick, String nombre, String apellido, String correo, LocalDate fecNac, String imagen, String contraseña, String direccion, String bio, String sitioWeb, String imagenWeb){
        String nickNuevo = nick;
        String correoNuevo = correo;

        List<Usuario> listaUsuarios = cp.getListaUsuarios();
        
        for(Usuario u : listaUsuarios){
            if(u.getNickname().equals(nickNuevo)){
                return 0;
            }
        }
        
        for(Usuario u : listaUsuarios){
            if(u.getEmail().equals(correoNuevo)){
                return 2;
            }
        }
        
        Proponente propNuevo = new Proponente(direccion, bio, sitioWeb, nick, correo, nombre, apellido, fecNac, imagen, contraseña, imagenWeb);
        propNuevo.setTipo("Proponente");
        cp.añadirUsuario(propNuevo);
        return 1;
    }
    
    @Override
    public int altaCategoria(String nombreCat){
        if(cp.findCategoria(nombreCat) != null){
            return -2; //ya existe esta categoria
        }
        
        Categoria padre = cp.findCategoria("Categoria");
        if(padre==null){
            padre = new Categoria("Categoria");
            cp.createCategoria(padre);
        }
        Categoria nueva = new Categoria(nombreCat);
        nueva.setPadre(padre.getNombre());
        padre.getHijas().add(nueva);
        
        try {
            cp.createCategoria(nueva);
        } catch (Exception e){
            return -3; //Error de persistencia
        }
        return 0; //Funciono
    }
    
    @Override
    public int altaCategoria(String nombreCat,String nombrePadreCat){
       if(cp.findCategoria(nombreCat) != null){
            return -2; //ya existe esta categoria
        }
       Categoria padre = cp.findCategoria(nombrePadreCat);
        if(padre == null){
            if(nombrePadreCat.equals("Categoria")){
                padre = new Categoria("Categoria");
                cp.createCategoria(padre);
            } else{
                return -1; //Padre no existe
            }    
        }
        Categoria nueva = new Categoria(nombreCat);
        nueva.setPadre(padre.getNombre());
        padre.getHijas().add(nueva);
        
        try {
            cp.createCategoria(nueva);
        } catch (Exception e){
            return -3; //Error de persistencia
        }
            
        return 0;
    }
 
    @Override
    public DefaultMutableTreeNode cargarNodoRaizCategorias(){
        List<Categoria> todas = cp.listarCategorias();
        
        Categoria raizCat = cp.findCategoria("Categoria");
        if(raizCat == null){
            raizCat = new Categoria("Categoria");
            cp.createCategoria(raizCat);
        }
        
        DefaultMutableTreeNode nodoRaiz = new DefaultMutableTreeNode(raizCat);
        
        List<DefaultMutableTreeNode> pendientes = new ArrayList<>();
        
        for(Categoria cat : todas){
            if(!cat.getNombre().equalsIgnoreCase("Categoria")){
                DefaultMutableTreeNode nodo = new DefaultMutableTreeNode(cat);
                Categoria padre = cp.findCategoria(cat.getPadre());
                if(padre == null){
                    nodoRaiz.add(nodo);
                }else{
                    DefaultMutableTreeNode nodoPadre = buscarNodo(nodoRaiz, padre.getNombre());
                    if(nodoPadre != null){
                        nodoPadre.add(nodo);
                    }else{
                       pendientes.add(nodo);
                    }
                }
                        
            }
        }
        
        //Reintento para huerfanos (cuando se intento ingresar no tenia el padre en el DefaultMutableTree
        boolean agregado;
        do{
            agregado = false;
            Iterator<DefaultMutableTreeNode> it = pendientes.iterator();
            while(it.hasNext()){
                DefaultMutableTreeNode nodoPendiente = it.next();
                Categoria catPend = (Categoria) nodoPendiente.getUserObject();
                DefaultMutableTreeNode nodoPadre = buscarNodo(nodoRaiz , catPend.getPadre());
                if(nodoPadre != null){
                    nodoPadre.add(nodoPendiente);
                    it.remove();
                    agregado = true;
                }
            }
        } while(agregado && !pendientes.isEmpty());
        
        return nodoRaiz;
    }
    private DefaultMutableTreeNode buscarNodo(DefaultMutableTreeNode raiz, String nombre){
        Enumeration<?> en = raiz.breadthFirstEnumeration();
        while(en.hasMoreElements()){
            DefaultMutableTreeNode nodo = (DefaultMutableTreeNode) en.nextElement();
            Categoria cat = (Categoria) nodo.getUserObject();
            if(cat.getNombre().equalsIgnoreCase(nombre)){
                return nodo;
            }
        }
        return null;
    }
    
    @Override
    public int altaAporte(String strmiColaborador, String strmiPropuesta,  double $aporte, int cantidad, EnumRetorno retorno){
        Propuesta miPropuesta = null;
        Colaborador miColaborador = null;                
        for (Usuario c : cp.getListaColaboradores()){
            if(c.getNickname().equals(strmiColaborador)){
                miColaborador = (Colaborador) c;
                break;
            }
        }         
        for (Propuesta p : cp.getListaPropuestas()) {
            if (p.getTitulo_Nickname().equals(strmiPropuesta)) {
                miPropuesta = p;
                break;        
            }
        }                     
        if (miColaborador.createAporte(miPropuesta.getTitulo(), $aporte, cantidad, retorno) == null) {
            return -3;  //Error: El usuario ya colabora con la Propuesta
        }         
        if (miPropuesta.getPosibleRetorno()!=EnumRetorno.AMBOS && miPropuesta.getPosibleRetorno()!=retorno){
            return -4; //Error: Retorno no valido en esta Propuesta
        }        
        Aporte a = miColaborador.createAporte(miPropuesta.getTitulo(), $aporte, cantidad, retorno);
        cp.añadirAporte(a);
        miPropuesta.addAporte(a);
        miColaborador.añadirAporte(a);
        cp.editarAporte(a);
        cp.editarPropuesta(miPropuesta);
        cp.editarColaborador(miColaborador);
        return 0; //PROPUESTA AGREGADA CORRECTAMENTE  
    }
    
    @Override
    public int altaAporte(String strmiColaborador, String strmiPropuesta,  double $aporte, int cantidad, EnumRetorno retorno, LocalDateTime fecAp){
        Propuesta miPropuesta = null;
        Colaborador miColaborador = null;                
        for (Usuario c : cp.getListaColaboradores()){
            if(c.getNickname().equals(strmiColaborador)){
                miColaborador = (Colaborador) c;
                break;
            }
        }        
        for (Propuesta p : cp.getListaPropuestas()) {
            if (p.getTitulo().equals(strmiPropuesta)) {
                miPropuesta = p;
                break;        
            }
        }                      
        if (miColaborador.createAporte(miPropuesta.getTitulo(), $aporte, cantidad, retorno) == null) {
            return -3;  //Error: El usuario ya colabora con la Propuesta
        }         
        if (miPropuesta.getPosibleRetorno()!=EnumRetorno.AMBOS && miPropuesta.getPosibleRetorno()!=retorno){
            return -4; //Error: Retorno no valido en esta Propuesta
        }        
        Aporte a = miColaborador.createAporte(miPropuesta.getTitulo(), $aporte, cantidad, retorno,fecAp);
        cp.añadirAporte(a);
        miPropuesta.addAporte(a);
        miColaborador.añadirAporte(a);
        cp.editarAporte(a);
        cp.editarPropuesta(miPropuesta);
        cp.editarColaborador(miColaborador);
        
        return 0; //PROPUESTA AGREGADA CORRECTAMENTE  
    }
    
    
    @Override
    public List<String> getUsuarios() {
        List<String> listaNombres = new ArrayList<>();
        List<Usuario> listaUsuarios = cp.getListaUsuarios();
        String aux;
        for(Usuario u : listaUsuarios){
            aux = u.getNickname();
            listaNombres.add(aux);
        }
        
        return listaNombres;
    }
    
     @Override
    public List<String> getColaboradores() {
        
        //MEMORIA LOCAL
//        List<String> lista = new ArrayList<>();
//        for(Colaborador c : misColaboradores){
//            lista.add(c.getNickname());
//        }
//        return lista;
        
        //CON PERSISTENCIA
        return cp.getNickColaboradores();
    }
    
    @Override
    public List<String> getPropuestas_Proponentes() {
        //MEMORIA LOCAL
//        List<String> lista = new ArrayList<>();
//        for(Propuesta p : misPropuestas){
//            lista.add(p.getTitulo_Nickname());
//        }
//        return lista;
        
        //CON PERSISTENCIA 
        List<String> lista = new ArrayList<>();
        for(Propuesta p : cp.getListaPropuestas()){
            lista.add(p.getTitulo_Nickname());
        }
        return lista;
    }
    
    @Override
    public List<String> getUsuariosProponentes() {
        List<String> listaNombres = new ArrayList<>();
//        String aux;
//        for(Proponente p : misProponentes){
//            aux = p.getNickname();
//            listaNombres.add(aux);
//        }
        
        
        List<Usuario> listaProponentes = cp.getListaProponentes();
        String aux;
        for(Usuario p : listaProponentes){
            aux = p.getNickname();
            listaNombres.add(aux);
        }
        //Lo podemos dejar como prefieran pero yo siento que queda mejor si directamente le pedimos los name al controlador  de 
        //persistencia y funcionaria igual sin tener que hacer que el controlador reciba en este punto los Proponentes
        //return cp.getNickProponente();
        return listaNombres;
    }
    
    @Override
    public List<String> getSeguidos(String seguidor) {
        Usuario usu = cp.buscarUsuario(seguidor);
        return usu.getMisSeguidos();
    }

    @Override
    public int seguirUsuario(String nick1, String nick2) {
        Usuario seguidor, seguir;
        seguidor = cp.buscarUsuario(nick1);
        seguir = cp.buscarUsuario(nick2);

        int resultado = seguidor.seguirUsuario(seguir);
        if (resultado == 0) {
            return 0; //error 0: ya sigue al usuario nick2
        }
        cp.editarUsuario(seguidor);
        return 1;
    }
    
    @Override
    public int dejarSeguirUsuario(String nick1, String nick2){
        //persistencia
        Usuario seguidor, seguir;
        seguidor = cp.buscarUsuario(nick1);
        seguir = cp.buscarUsuario(nick2);
        
        int res = seguidor.dejarDeSeguir(seguir);
        if(res == 1){
            //persistencia
            cp.editarUsuario(seguidor);
            return 1;
        }else{
            return 0; //error: no lo encontró
        }
    }
    
    @Override
    public int altaPropuesta(String nick, String tipo, String titulo, String descripcion, String lugar, LocalDate fechaPrev, String montoXentrada, String montoNecesario, EnumRetorno posibleRetorno, LocalDate fechaActual, String imagen){
     
        if (existeTitulo(titulo)) {
            return -1;
        }
        
        Proponente prop = cp.buscarProponente(nick);
        
        Categoria c  = cp.findCategoria(tipo);
        
        Propuesta nuevaProp = new Propuesta(c.getNombre(), prop.getNickname(), titulo, descripcion, lugar, fechaPrev, Double.parseDouble(montoXentrada), Double.parseDouble(montoNecesario), posibleRetorno, fechaActual, imagen);
//        misPropuestas.add(nuevaProp);
          cp.añadirEstado(nuevaProp.getEstadoActual());
          cp.añadirPropuesta(nuevaProp);
            //Agregar propuesta a esa categoria directamente lo hare con persistencia antes seria c.agregarPropuesta(nuevaProp);
        return 1;
    }
    
    @Override 
    public int cambiarEstadoPropuesta(String titulo, String estado){
        Propuesta p = cp.getPropuesta(titulo);
        
        p.modificarPropuesta(p.getDescrip(), p.getLugar(), p.getFechaPubli(), p.getMontoEntrada(), p.getMontoNecesaria(), p.getPosibleRetorno().toString(), estado, p.getImagen(), p.getCategoria());
        cp.editarPropuesta(p);
        
        return 0;
    }
    
    @Override
    public int modificarPropuesta(String titulo, String descripcion, String lugar, LocalDate fechaPrev, String montoXentrada, String montoNecesario, String posibleRetorno, String estado, String imagen, String categoria){
    
        Propuesta p = cp.getPropuesta(titulo);
        Categoria c = cp.findCategoria(categoria);
        //Ya se busca directamente en la BD el arbol categoria no tendra los
        //datos
        boolean seCambioCat = false;
        //Quitar esta propuesta de la categoria que la apuntaba (por el caso de cambio de categoria) hacerlo directo con persistencia
        if(!p.getCategoria().equals(c.getNombre())){ //p.getCategoria no anda
//            //Quitar esta propuesta de la categoria que la apuntaba
              Categoria viejaCat = cp.findCategoria(p.getCategoria()); //Aca saco la categoria que tenia antes ya que aun no se modifico
              viejaCat.sacarPropuesta(p); //La saco de su lista de propuestas
              cp.editarCategoria(viejaCat); //mando el edit para reflejar cambios en BD
              seCambioCat = true;
        }
        p.modificarPropuesta(descripcion, lugar, fechaPrev, Double.parseDouble(montoXentrada), Double.parseDouble(montoNecesario), posibleRetorno, estado, imagen, c.getNombre());
        cp.editarPropuesta(p);
        
        //Agregar propuesta a esa categoria directamente lo hare con persistencia antes seria c.agregarPropuesta(nuevaProp);
        if(seCambioCat){
            c.agregarPropuesta(p); //Si se cambio entonces la nuevaCat o bueno "c" debe agregar esta propuesta a su lista
            cp.editarCategoria(c); //Y reflejarlo en la BD
        }
        return 0;
    }

    
   
    @Override
    public List<String> getPropuestas() {
//        List<String> listaPropuestas = new ArrayList<>();
//        String aux;
//        for(Propuesta p : misPropuestas){
//            aux = p.getTitulo();
//            listaPropuestas.add(aux);
//        }
//        return listaPropuestas;
          

          //PERSISTENCIA
          List<String> listaPropuestas = new ArrayList<>();
          String aux;
          for (Propuesta p : cp.getListaPropuestas()) {
              aux = p.getTitulo();
              System.out.println("titulo: " + aux);
              listaPropuestas.add(aux); 
          }
          System.out.println("Lista Propuestas:" + listaPropuestas);
          return listaPropuestas;
    }
    
    @Override
    public List<String> getPropuestasI(){
        List<String> listaPropuestas = new ArrayList<>();
          String aux;
          for (Propuesta p : cp.getListaPropuestas()) {
              if (p.getEstadoActual().getEstado().toString().equals("INGRESADA")) {
                  aux = p.getTitulo();
                  listaPropuestas.add(aux); 
              }
            }
          return listaPropuestas;
    }
    
    @Override
    public DataPropuesta consultaDePropuesta(String titulo){
        
//        DataPropuesta DP = null;
        
//        boolean encontrado = false;
//        for (Propuesta p : misPropuestas) {
//            if (p.getTitulo().equalsIgnoreCase(titulo)) {
//                encontrado = true;
//                DP = new DataPropuesta(titulo, p.getImagen(), p.getEstadoActual(), p.getProponente(), p.getDescripcion(), p.getLugar(), p.getEntrada(), p.getNecesaria(),p.getAlcanzada() , p.getFechaARealizar(), p.getRetorno(), p.getCategoria());
//                return DP;
//            }
//        }
//       return DP;

        //persistencia
        Propuesta p = cp.getPropuesta(titulo);
        return new DataPropuesta(titulo, p.getImagen(), p.getEstadoActual(), p.getProponente(), p.getDescrip(), p.getLugar(), p.getMontoEntrada(), p.getMontoNecesaria(),p.getMontoAlcanzada() , p.getFechaPubli(), p.getPosibleRetorno(), p.getCategoria()/*"SIN FUNCIONAR"*/);
    }
    
    @Override
    public DataPropuesta getDataPropuesta(String titulo_nick){
        //CON MEMORIA LOCAL
//        DataPropuesta DP = null;
//        for (Propuesta p : misPropuestas) {
//            if (p.getTitulo_Nickname().equalsIgnoreCase(titulo_nick)) {
//                DP = new DataPropuesta(p.getTitulo(), p.getImagen(), p.getEstadoActual(), p.getProponente(), p.getDescripcion(), p.getLugar(), p.getEntrada(), p.getNecesaria(),p.getmontoAlcanzada(), p.getFechaARealizar(), p.getRetorno(), p.getCategoria());
//                return DP;
//            }
//        }
//        return DP;
        
        //CON PERSISTENCIA
        DataPropuesta DP = null;
        for (Propuesta p : cp.getListaPropuestas()) {
            if (p.getTitulo_Nickname().equalsIgnoreCase(titulo_nick)) {
                DP = new DataPropuesta(p.getTitulo(), p.getImagen(), p.getEstadoActual(), p.getProponente(), p.getDescrip(), p.getLugar(), p.getMontoEntrada(), p.getMontoNecesaria(),p.getmontoAlcanzada(), p.getFechaPubli(), p.getPosibleRetorno(), p.getCategoria());
                return DP;
            }
        }
        return DP;
        
    }
    
    @Override
    public DataProponente consultaDeProponente(String NickName){
        
        DataProponente DProp = null;
        Proponente p = (Proponente) cp.buscarUsuario(NickName);
                List<DataPropuesta> propuestasDe = new ArrayList<>();
                DataPropuesta dataProp;
                for(String propuestas : p.getPropuestas()){
                    DataPropuesta prop = consultaDePropuesta(propuestas);
                    dataProp = new DataPropuesta(prop.getAlcanzada(),prop.getTitulo(),prop.getEstadoActual(),prop.getLugar());
                    propuestasDe.add(dataProp);
                }
                DProp = new DataProponente(NickName, p.getNombre(),p.getApellido(),p.getEmail(),p.getFecNac(),p.getImagen(),p.getDireccion(),p.getBiografia(),p.getSitioWeb(),propuestasDe);
                return DProp;
    }
    
    @Override
    public DataColaborador consultaDeColaborador(String NickName){
        
        DataColaborador DCola = null;
        Colaborador c = (Colaborador) cp.buscarUsuario(NickName);
        List<String> titulos = c.getTituloPropuestas();
        List<DataPropuesta> DP = new ArrayList<>();
        for(String t : titulos){
           Propuesta p = (Propuesta) cp.getPropuesta(t);
           DataPropuesta dp = new DataPropuesta(p.getMontoAlcanzada(), p.getTitulo(), p.getEstadoActual(), p.getLugar(), p.getProponente());
           DP.add(dp);
        }
        
        DCola = new DataColaborador(NickName, c.getNombre(),c.getApellido(),c.getEmail(),c.getFecNac(),c.getImagen(),DP);
        return DCola;
        
    }
    
    @Override
    public List<String> getEstados(){
    List<String> listaEstados = new ArrayList<>();
    for (EnumEstado e : EnumEstado.values()) {
        listaEstados.add(e.name());
    }
    return listaEstados;
    }
    
    @Override
    public List<String> getPropXEstado(String estado){
//        List<String> listaPropuestas = new ArrayList<>();
//        String aux;
//        for(Propuesta p : misPropuestas){
//            aux = p.getTitulo();
//            if(p.getEstadoActual().getEstado().toString().equalsIgnoreCase(estado)){
//                listaPropuestas.add(aux);
//            }
//        }
//        return listaPropuestas;
        
        //PERSISTENCIA
        
        List<String> listaPropuestas = new ArrayList<>();
        String aux;
        for(Propuesta p : cp.getListaPropuestas()){
            aux = p.getTitulo();
            if(p.getEstadoActual().getEstado().toString().equalsIgnoreCase(estado)){
                listaPropuestas.add(aux);
            }
        }
        return listaPropuestas;
    }
    
    @Override
    public List<String> getPropuestasXColaborador(String colab){
        //CON MEMEORIA LOCAL
//        for(Colaborador c : this.misColaboradores){
//            if(colab.equals(c.getNickname())){
//                return c.getTituloPropuestas();
//            }
//        }   
//        return null;
        
        //CON PERSISTENCIA
        for(Usuario c : cp.getListaColaboradores()){
            if(colab.equals(c.getNickname())){
                Colaborador cola = (Colaborador) c;
                return  cola.getTituloNickPropuestas();
            }
        }   
        return null;
    }
    
    @Override
    public DataAporte getDataAporte(String tituloNick, String nick){
        for(Usuario c : cp.getListaColaboradores()){
            if(nick.equals(c.getNickname())){
                Colaborador cola = (Colaborador) c;
                return cola.getDataAporte(tituloNick);
            }
        }
        return null;
    }
    
    @Override
    public void borrarAporte(String tituloNick, String nick){
        for(Usuario c : cp.getListaColaboradores()){
            if(nick.equals(c.getNickname())){
                Colaborador cola = (Colaborador) c;
                Aporte a = cola.borrarAporte(tituloNick);
                try {
                    Propuesta p = cp.getPropuesta(a.getTituloMiPropuesta());
                    p.desvincularAporte(nick);
                    cp.borrarAporte(a,p,cola);
                } catch (Exception ex) {
                    System.getLogger(Controlador.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                }
                break;
            }
        }
    }
    
    @Override
    public boolean existeTitulo(String titulo){
        
        boolean encontrado = false;
        for (Propuesta p : cp.getListaPropuestas()) {
            if (p.getTitulo().equalsIgnoreCase(titulo)) {
                encontrado = true;
            }
        }
        
        return encontrado;
    }
    
    @Override
    public List<String> getColabsProp(String titulo){
        List<String> listaColabProp = new ArrayList<>();
        Propuesta prop = cp.getPropuesta(titulo);
        double aporte$;
        String c;
        String aporteColab;
        
        for (Aporte a : prop.getMisAportes()) {
            aporte$ = a.getAporte();
            c = a.getNickMiColaborador();
            
            aporteColab = c + "\t" + aporte$;
            listaColabProp.add(aporteColab);
        }
        
        return listaColabProp;
    }
    
    @Override
    public boolean seleccionaCategoria(String categoria){
        boolean encontrado = false;
        
        for (Categoria c : cp.listarCategorias()) {
            if (c.getNombre().equalsIgnoreCase(categoria)) {
                encontrado = true;
            }
        }
        
        
        return encontrado;
    }
    
    @Override
    public void cambiarEstado(String titulo, int n){
        Propuesta prop = cp.getPropuesta(titulo);
        LocalDate fec = LocalDate.now();
        EnumEstado est;
        if (n == 0) {
            est = EnumEstado.valueOf("PUBLICADA");
        }else{
            est = EnumEstado.valueOf("CANCELADA");
        }
        
        Estado estadoActual = new Estado(est, fec);
        prop.setEstadoActual(estadoActual);
        prop.misEstados.add(estadoActual);
        cp.editarPropuesta(prop);
    }
        
    @Override
    public void eliminarUsuario(String usu){
        cp.eliminarUsuario(usu);
    }
    
        @Override
    public boolean esFavorita(String titulo, String nick){
        Usuario u = cp.buscarUsuario(nick);
        Propuesta p = cp.getPropuesta(titulo);
        
        return u.esFavorita(p);
    }
    
    @Override
    public int cambiarFavorita(String titulo, String nick){
        Usuario u = cp.buscarUsuario(nick);
        Propuesta p = cp.getPropuesta(titulo);
        
        if(u.esFavorita(p)){
            u.addFavorita(p);
            cp.editarUsuario(u);
            return 1;
        }else{
            u.eliminarFavorita(p);
            cp.editarUsuario(u);
            return 0;
        }
    }    
    
    @Override
    public void addComentario(String titulo, String nick, String comentario){
        Colaborador c = (Colaborador) cp.buscarUsuario(nick);
        Aporte a = c.getAporte(titulo);
        a.setComentario(comentario);
        a.setFecComentario(LocalDateTime.now());
        cp.editarAporte(a);
    }
    
    
    @Override
    public DataComentario getDataComentario(String titulo, String nick){
        Colaborador c = (Colaborador) cp.buscarUsuario(nick);
        Aporte a = c.getAporte(titulo);
                    
        return new DataComentario(a.getComentario(),a.getFecComentario(),nick,titulo);               
    }   

}
