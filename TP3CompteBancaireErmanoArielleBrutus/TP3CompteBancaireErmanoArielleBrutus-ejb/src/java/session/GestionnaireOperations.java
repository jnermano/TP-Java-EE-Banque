/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entities.Operations;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Ermano
 */
@Stateless
@LocalBean
public class GestionnaireOperations {
    @PersistenceContext(unitName = "TP3CompteBancaireErmanoArielleBrutus-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }
    
    public List<Operations> getAllOperations(){
        Query query = em.createNamedQuery("Operations.findAll");
        return query.getResultList();
    }
    
    public Operations update(Operations ope){
        return em.merge(ope);
    }
    
    public void creerOperation(Operations ope){
        em.persist(ope);
    }
    
    public Operations getOperation(long id){
        return em.find(Operations.class, id);
    }
    
     public long getCount() {
        Query query = em.createNamedQuery("Operations.count");
        return (Long) query.getSingleResult();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
