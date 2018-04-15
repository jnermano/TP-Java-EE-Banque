/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entities.TypeOperation;
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
public class GestionnaireDeTypeOperation {
    @PersistenceContext(unitName = "TP3CompteBancaireErmanoArielleBrutus-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    public TypeOperation update(TypeOperation ope){
        return em.merge(ope);
    }
    
    public List<TypeOperation> getAllTypes(){
        Query query = em.createQuery("SELECT t FROM TypeOperation t");
        return query.getResultList();
    }
    
    public TypeOperation getTypeOperation(long id){
        return em.find(TypeOperation.class, id);
    }
}
