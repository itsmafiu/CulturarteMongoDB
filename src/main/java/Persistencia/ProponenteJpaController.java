/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Logica.Proponente;
import Persistencia.exceptions.NonexistentEntityException;
import Persistencia.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author mafiu
 */
public class ProponenteJpaController implements Serializable {

    public ProponenteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public ProponenteJpaController(){
        this.emf = Persistence.createEntityManagerFactory("CulturartePU");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Proponente proponente) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(proponente);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findProponente(proponente.getNickname()) != null) {
                throw new PreexistingEntityException("Proponente " + proponente + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Proponente proponente) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            proponente = em.merge(proponente);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = proponente.getNickname();
                if (findProponente(id) == null) {
                    throw new NonexistentEntityException("The proponente with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Proponente proponente;
            try {
                proponente = em.getReference(Proponente.class, id);
                proponente.getNickname();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The proponente with id " + id + " no longer exists.", enfe);
            }
            em.remove(proponente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Proponente> findProponenteEntities() {
        return findProponenteEntities(true, -1, -1);
    }

    public List<Proponente> findProponenteEntities(int maxResults, int firstResult) {
        return findProponenteEntities(false, maxResults, firstResult);
    }

    private List<Proponente> findProponenteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Proponente.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Proponente findProponente(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Proponente.class, id);
        } finally {
            em.close();
        }
    }

    public int getProponenteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Proponente> rt = cq.from(Proponente.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    public List<String> getListaNick(){
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT p.nickname FROM Proponente p");
        return query.getResultList();               
    }
}
