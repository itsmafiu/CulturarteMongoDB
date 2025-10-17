/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Presentacion;
import Logica.Categoria;
import Logica.Propuesta;
import java.util.Enumeration;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author brito
 */
public class UtilArbol {
    public static DefaultMutableTreeNode construirArbolConPropuestas(DefaultMutableTreeNode raizCategorias){
        //Variante para altaPropuesta y para modificarPropuesta
        Categoria cat = (Categoria) raizCategorias.getUserObject();
        DefaultMutableTreeNode nodoCategoria = new DefaultMutableTreeNode(cat.getNombre());
        
        for(Propuesta prop : cat.getPropuestas()){
            nodoCategoria.add(new DefaultMutableTreeNode(prop.getTitulo()));
        }
        
        Enumeration<?> hijos = raizCategorias.children();
        while(hijos.hasMoreElements()){
            DefaultMutableTreeNode hijo = (DefaultMutableTreeNode) hijos.nextElement();
            nodoCategoria.add(construirArbolConPropuestas(hijo));
        }
        return nodoCategoria;
    }
    public static DefaultMutableTreeNode construirArbolCategorias(DefaultMutableTreeNode raizCategorias){ //Para altaCategoria solamente
        Categoria cat = (Categoria) raizCategorias.getUserObject();
        DefaultMutableTreeNode nodoCategoria = new DefaultMutableTreeNode(cat.getNombre());
        
        Enumeration<?> hijos = raizCategorias.children();
        while(hijos.hasMoreElements()){
            DefaultMutableTreeNode hijo = (DefaultMutableTreeNode) hijos.nextElement();
            nodoCategoria.add(construirArbolCategorias(hijo));
        }
        return nodoCategoria;
    }
    
}
