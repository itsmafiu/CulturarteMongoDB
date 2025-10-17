package Logica;


import javax.swing.tree.DefaultMutableTreeNode;
import java.util.Enumeration;

public class ArbolCategorias {

    private Categoria raizCategoria;
    
    public ArbolCategorias(Categoria raiz){
        this.raizCategoria = raiz;
    }
    
    public Categoria getRaizCategoria(){
        return raizCategoria;
    }
    
    public Categoria buscarCategoria(String nombre){
        return buscarRecursivo(raizCategoria,nombre);
    }
    public Categoria buscarRecursivo(Categoria actual, String nombre){
        if(actual.getNombre().equalsIgnoreCase(nombre)){
            return actual;
        }
        for(Categoria hija: actual.getHijas()){
            Categoria encontrada = buscarRecursivo(hija,nombre);
            if(encontrada != null){
                return encontrada;
            }
        }
        return null;
    }
    public void insertarCategoria(String nombrePadre, Categoria hija){
        Categoria padre = buscarCategoria(nombrePadre);
        if(padre != null){
            padre.getHijas().add(hija);
            hija.setPadre(padre);
        }else{
            System.out.println("No se encontró el padre: " + nombrePadre);
        }
    }
    
    public DefaultMutableTreeNode generarNodoJTree(){
        return generarNodoRecursivo(raizCategoria);
    }
    private DefaultMutableTreeNode generarNodoRecursivo(Categoria cat){
        DefaultMutableTreeNode nodo = new DefaultMutableTreeNode(cat);
        for(Categoria hija: cat.getHijas()){
            nodo.add(generarNodoRecursivo(hija));
        }
        return nodo;
    }
}
