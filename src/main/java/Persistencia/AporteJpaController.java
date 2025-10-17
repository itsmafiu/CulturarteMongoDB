/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Logica.Aporte;
import Persistencia.exceptions.NonexistentEntityException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import javax.persistence.Persistence;

/**
 *
 * @author Luiano
 */
public class AporteJpaController implements Serializable {

    public AporteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public AporteJpaController() {
        this.emf = Persistence.createEntityManagerFactory("CulturartePU");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Aporte aporte) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(aporte);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Aporte aporte) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            aporte = em.merge(aporte);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = aporte.getId();
                if (findAporte(id) == null) {
                    throw new NonexistentEntityException("The aporte with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Aporte aporte;
            try {
                aporte = em.getReference(Aporte.class, id);
                aporte.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The aporte with id " + id + " no longer exists.", enfe);
            }
            em.remove(aporte);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Aporte> findAporteEntities() {
        return findAporteEntities(true, -1, -1);
    }

    public List<Aporte> findAporteEntities(int maxResults, int firstResult) {
        return findAporteEntities(false, maxResults, firstResult);
    }

    private List<Aporte> findAporteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Aporte.class));
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

    public Aporte findAporte(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Aporte.class, id);
        } finally {
            em.close();
        }
    }

    public int getAporteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Aporte> rt = cq.from(Aporte.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
