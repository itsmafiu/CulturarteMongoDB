/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Logica.Categoria;
import Persistencia.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
/**
 *
 * @author brito
 */
public class CategoriaJpaController implements Serializable{
    private EntityManagerFactory emf = null;
    
    public CategoriaJpaController(EntityManagerFactory emf){
        this.emf=emf;
    }
    public CategoriaJpaController(){
        this.emf = Persistence.createEntityManagerFactory("CulturartePU");
    }
    public EntityManager getEntityManager(){
        return this.emf.createEntityManager();
    }
    public void create(Categoria cat) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(cat);
            em.flush();
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCategoria(cat.getNombre()) != null) {
                throw new PreexistingEntityException("La Categoria " + cat + " ya existe.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    //Busco la categoria por su nombre
    public Categoria findCategoria(String nombre){
        EntityManager em = getEntityManager();
        try{
            return em.find(Categoria.class,nombre);
        } finally{
            em.close();
        }
    }
    //Listar todas las Categorias
    public List<Categoria> findCategoriaEntities(){
        EntityManager em = getEntityManager();
        try{
            TypedQuery<Categoria> query = em.createQuery("Select c From Categoria c",Categoria.class);
            return query.getResultList();
        } finally{
            em.close();
        }
    }
    
    public void edit(Categoria cat) throws Exception {
        EntityManager em = null;
        try{
            em = getEntityManager();
            em.getTransaction().begin();
            
            em.merge(cat);
            em.getTransaction().commit();
        }catch(Exception ex) {
            if(findCategoria(cat.getNombre()) == null){
                throw new Exception("La categoria con nombre " + cat.getNombre() + " no existe");
            }
            throw ex;
        } finally{
            if(em != null){
                em.close();
            }
        }
    }
    
    
}
